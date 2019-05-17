package com.tacoloco.beans;

import java.util.Objects;

/**
 * @author Heikel Khaldi
 */
/*
a pojo MenuItem that had basic data about a Toco Loco Menu Item
*/
public class MenuItem {

    /*
    // this should be set with a database will be ommited for purpose of simplification
    //  I am just giving an example with JPA annotation
    @Id
    @GeneratedValue
     */
    private Long itemId;

    //@NaturalId 
    //where name is used as constraint to the db so two items will not have the same name, ommmitted for simplification    
    private String itemName;
    private String itemDescription;
    private double itemPrice;

    private String itemImgURL;

    public MenuItem(){}

    /**
     *
     * @param itemId
     * @param itemName
     * @param itemDescription
     * @param itemPrice
     * @param url
     */
    public MenuItem(long itemId, String itemName,String itemDescription ,double itemPrice, String url) {

        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImgURL = url;
        this.itemDescription = itemDescription;

    }

    public Long getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    /*
        When adding a new Item to the Service we should make sure that we override the .equal method
        to define when an object is equal to another which will not increase the size of a Set<> 
        if we add the same object twice 
        in our case the name is the item is what will determine an object a is equal to object b
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        return Objects.equals(this.itemName, other.itemName);
    }

    public String getItemImgURL() {
        return itemImgURL;
    }

    public void setItemImgURL(String itemImgURL) {
        this.itemImgURL = itemImgURL;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
