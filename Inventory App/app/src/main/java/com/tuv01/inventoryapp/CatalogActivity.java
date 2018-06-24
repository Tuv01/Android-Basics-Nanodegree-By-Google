package com.tuv01.inventoryapp;

import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tuv01.inventoryapp.data.InventoryContract.InventoryEntry;

/**
 * Displays list of products that were entered and stored in the app.
 */
public class CatalogActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    /**
     * Identifier for the product data loader
     */
    private static final int PRODUCT_LOADER = 0;

    /**
     * Adapter for the ListView
     */
    InventoryCursorAdapter mCursorAdapter;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    View emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        //  Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        // Find the ListView which will be populated with the inventory data
        recyclerView = (RecyclerView) findViewById(R.id.list_view);
        layoutManager = new LinearLayoutManager(CatalogActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        //  Find and set empty view on the ListView, so that it only shows when the list has 0 items.
        emptyView = findViewById(R.id.empty_view);

        //  Setup an Adapter to create a list item for each row of product data in the Cursor.
        //  there is no product data yet (until the loader finishes) so pass in null for the Cursor.
        mCursorAdapter = new InventoryCursorAdapter(this, null);
        recyclerView.setAdapter(mCursorAdapter);

        //  Kick off the loader
        getLoaderManager().initLoader(PRODUCT_LOADER, null, this);
    }

    public void onProductClick(long id) {
        Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);
        Uri currentProductUri = ContentUris.withAppendedId(InventoryEntry.CONTENT_URI, id);
        intent.setData(currentProductUri);
        startActivity(intent);
    }

    /* Sale Button, reduces quantity by one */
    public void onSale(long id, int quantity) {
        Uri currentProductUri = ContentUris.withAppendedId(InventoryEntry.CONTENT_URI, id);
        Log.v("CatalogActivity", "Uri: " + currentProductUri);
        quantity--;
        ContentValues values = new ContentValues();
        values.put(InventoryEntry.COLUMN_PRODUCT_QUANTITY, quantity);
        int rowsEffected = getContentResolver().update(currentProductUri, values, null, null);
    }

    /**
     * Helper method to insert hardcoded pet data into the database. For debugging purposes only.
     */
    private void insertProduct() {

        // Create a ContentValues object where column names are the keys,
        // and the product attributes are the values.
        ContentValues values = new ContentValues();
        values.put(InventoryEntry.COLUMN_PRODUCT_NAME, getString(R.string.bmw));
        values.put(InventoryEntry.COLUMN_PRODUCT_PICTURE, getString(R.string.pictureUri));
        values.put(InventoryEntry.COLUMN_PRODUCT_PRICE, getString(R.string.money));
        values.put(InventoryEntry.COLUMN_PRODUCT_QUANTITY, 0);
        values.put(InventoryEntry.COLUMN_PRODUCT_SUPPLIER_NAME, getString(R.string.companyProduct));
        values.put(InventoryEntry.COLUMN_PRODUCT_PHONE, getString(R.string.companyProductNumber));

        // Insert a new row for the product into the provider using the ContentResolver.
        // Use the {@link InventoryEntry#CONTENT_URI} to indicate that we want to insert
        // into the inventory database table.
        // Receive the new content URI that will allow us to access product's data in the future.
        Uri newUri = getContentResolver().insert(InventoryEntry.CONTENT_URI, values);
        Log.v("CatalogActivity", "Uri of new product: " + newUri);
    }

    /**
     * Helper method to delete all pets in the database.
     */
    private void deleteAllProducts() {
        int rowsDeleted = getContentResolver().delete(InventoryEntry.CONTENT_URI, null, null);
        Log.v("CatalogActivity", rowsDeleted + " rows deleted from inventory database");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                insertProduct();
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                deleteAllProducts();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                InventoryEntry._ID,
                InventoryEntry.COLUMN_PRODUCT_NAME,
                InventoryEntry.COLUMN_PRODUCT_PRICE,
                InventoryEntry.COLUMN_PRODUCT_QUANTITY,
                InventoryEntry.COLUMN_PRODUCT_SUPPLIER_NAME,
                InventoryEntry.COLUMN_PRODUCT_PICTURE,
                InventoryEntry.COLUMN_PRODUCT_PHONE};

        //This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                InventoryEntry.CONTENT_URI,     // Provider content URI to query
                projection,                     // Colums to include in the resulting Cursor
                null,                  // No selection clause
                null,               // No selection arguments
                null);                 // Default sort order
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data.getCount() == 0) {
            emptyView.setVisibility(View.VISIBLE);
        } else {
            emptyView.setVisibility(View.GONE);
        }
        // Update {@link InventoryCursorAdapter} with this new cursor containing updated product data.
        mCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // Callback called when the data needs to be deleted
        mCursorAdapter.swapCursor(null);
    }
}