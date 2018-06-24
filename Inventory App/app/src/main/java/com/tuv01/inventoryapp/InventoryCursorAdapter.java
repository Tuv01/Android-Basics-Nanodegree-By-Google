package com.tuv01.inventoryapp;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tuv01.inventoryapp.data.InventoryContract;

/**
 * Created by Tuv01 on 28.04.2018.
 */

/**
 * {@link InventoryCursorAdapter} is an adapter for a list or grid view
 * that uses a {@link Cursor} of inventory data as its data source. This adapter knows
 * how to create list items for each row of inventory data in the {@link Cursor}.
 */
public class InventoryCursorAdapter extends CursorRecyclerAdapter<InventoryCursorAdapter.ViewHolder> {
    private CatalogActivity activity = new CatalogActivity();

    /**
     * Constructs a new {@link InventoryCursorAdapter}.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public InventoryCursorAdapter(CatalogActivity context, Cursor c) {
        super(context, c);
        this.activity = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView nameTextView;
        protected TextView priceTextView;
        protected TextView quantityTextView;
        protected TextView saleTv;
        protected ImageView pictureImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            // Find individual views that we want to modify in the list item layout
            nameTextView = (TextView) itemView.findViewById(R.id.name);
            priceTextView = (TextView) itemView.findViewById(R.id.price);
            quantityTextView = (TextView) itemView.findViewById(R.id.quantity);
            pictureImageView = (ImageView) itemView.findViewById(R.id.product_image);
            saleTv = (TextView) itemView.findViewById(R.id.sale);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(InventoryCursorAdapter.ViewHolder viewHolder, Cursor cursor) {
        final long id;
        final int mQuantity;

        id = cursor.getLong(cursor.getColumnIndex(InventoryContract.InventoryEntry._ID));
        // Find the colums of inventory attributes that we are interested in
        int nameColumIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_PRODUCT_NAME);
        int priceColumIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_PRODUCT_PRICE);
        int quantityColumIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_PRODUCT_QUANTITY);
        int pictureColumIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_PRODUCT_PICTURE);

        // Read the pet attributes from the Cursor for the current product
        String productName = cursor.getString(nameColumIndex);
        String productPrice = Integer.toString(cursor.getInt(priceColumIndex));
        String productQuantity = Integer.toString(cursor.getInt(quantityColumIndex));
        int quantity = cursor.getInt(quantityColumIndex);
        String pictureImageUri;
        pictureImageUri = cursor.getString(pictureColumIndex);
        Uri productPicture = Uri.parse(pictureImageUri);

        mQuantity = quantity;

        // Update the TextViews with the attributes for the current product

        viewHolder.pictureImageView.setImageURI(productPicture);
        viewHolder.pictureImageView.invalidate();
        viewHolder.nameTextView.setText(productName);
        viewHolder.priceTextView.setText(productPrice);
        viewHolder.quantityTextView.setText(String.valueOf(quantity));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onProductClick(id);
            }
        });

        viewHolder.saleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mQuantity > 0) {
                    activity.onSale(id, mQuantity);
                } else {
                    Toast.makeText(activity, R.string.outStock, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}