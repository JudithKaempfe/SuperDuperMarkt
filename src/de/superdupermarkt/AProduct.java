package de.superdupermarkt;

import java.time.*;
import java.util.ArrayList;

abstract class AProduct {

    private String productName;
    private int productQuality;
    private float basePrice;
    private LocalDate date;

    public float productPrice() {
     return basePrice + 0.1f * productQuality;
    }

    public abstract void timeAdvancing();

    public abstract void restocking(ArrayList<AProduct> regal);

    public abstract boolean toClearFromShelf();


    public String getProductName() {
        return productName;
    }

    protected void setProductName(String productName) {
        this.productName = productName;
    }


    public int getProductQuality() {
        return productQuality;
    }

    protected void setProductQuality(int productQuality) {
        this.productQuality = productQuality;
    }


    public float getBasePrice() {
        return basePrice;
    }

    protected void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }


    public LocalDate getDate() {
        return date;
    }

    protected void setDate(LocalDate date) {
        this.date = date;
    }


    public AProduct(String productName, int productQuality, float basePrice, LocalDate date) {
        this.setProductName(productName);
        this.productQuality = productQuality;
        this.basePrice = basePrice;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Produkt: " + getProductName() + "\nQualität: " + getProductQuality() + "\nPreis: " + productPrice() + "\nStichtag: " + getDate();
    }
}
