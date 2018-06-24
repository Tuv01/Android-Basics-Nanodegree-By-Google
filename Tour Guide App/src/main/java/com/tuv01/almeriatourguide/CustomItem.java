package com.tuv01.almeriatourguide;

/**
 * Created by Tuv01 on 08.03.2018.
 */

public class CustomItem {

    /** String resource ID for the description text */
    private String atgDescriptionText;

    /** String resource ID for the location */
    private String atgLocationText;

    /**String resource ID for the price */
    private String atgPriceText;

    //Image resource ID for the place's photo
    private int atgPhotoId=NO_IMAGE_PROVIDED;

    //Image resource ID for the price's icon
    private int atgPriceImageId=NO_IMAGE_PROVIDED;;

    //Image resource ID for the location's icon
    private int atgLocationImageId=NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this Item*/
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new CustomItem object.
     *
     * @param descriptionText is the description or name of the place
     * @param locationText is the location for the place
     */
    public CustomItem(String descriptionText,String locationText) {
        atgDescriptionText=descriptionText;
        atgLocationText=locationText;
    }
    /**
     * Create a new CustomItem object.
     * @param descriptionText is the description or name of the place
     * @param locationText is the location for the place
     * @param priceText is the entrance price.
     */
    public CustomItem(String descriptionText, String locationText, String priceText) {
        atgDescriptionText=descriptionText;
        atgLocationText=locationText;
        atgPriceText=priceText;
    }
    /**
     * Create a new CustomItem object.
     * @param descriptionText is the description or name of the place
     * @param locationText is the location for the place
     * @param priceText is the entrance price.
     * @param photoId is the resource ID for the price ImageView
     */
    public CustomItem(String descriptionText, String locationText, String priceText, int photoId) {
        atgDescriptionText=descriptionText;
        atgLocationText=locationText;
        atgPhotoId=photoId;
        atgPriceText=priceText;
    }

    /**
     * Create a new CustomItem object.
     *
     * @param descriptionText is the description or name of the place
     * @param locationText is the location for the place
     * @param photoId is the resource ID for the photo
     * @param priceImageId is the resource ID for the price ImageView
     * @param locationImageId is the resource ID for the location ImageView
     * @param priceText is the entrance price.
     */
    public CustomItem(String descriptionText,String locationText,String priceText,int photoId,int priceImageId,int locationImageId){
        atgDescriptionText=descriptionText;
        atgLocationText=locationText;
        atgPhotoId=photoId;
        atgPriceImageId=priceImageId;
        atgLocationImageId=locationImageId;
        atgPriceText=priceText;
    }

    /**
     * Get the description.
     */
    public String getAtgDescriptionText() {
        return atgDescriptionText;
    }

    /**
     * Get the location.
     */
    public String getAtgLocationText() {
        return atgLocationText;
    }

    /**
     * Get the price.
     */
    public String getAtgPriceText() {
        return atgPriceText;
    }

    /**
     * Return the audio resource ID of the photo.
     */
    public int getAtgPhotoId() {
        return atgPhotoId;
    }

    /**
     * Return the audio resource ID of the price's image.
     */
    public int getAtgPriceImageId() {
        return atgPriceImageId;
    }

    /**
     * Return the audio resource ID of the location's image.
     */
    public int getAtgLocationImageId() {
        return atgLocationImageId;
    }

   /**
    * Returns whether or not there is an location's image for this CustomItem.
    */
    public boolean hasPhotoImage() {
        return atgPhotoId != NO_IMAGE_PROVIDED;
    }

    /**
     * Returns whether or not there is an location's image for this CustomItem.
     */
    public boolean hasLocationImage() {
        return atgLocationImageId != NO_IMAGE_PROVIDED;
    }

    /**
     * Returns whether or not there is an location's image for this CustomItem.
     */
    public boolean hasPriceImage() {
        return atgPriceImageId != NO_IMAGE_PROVIDED;
    }
}