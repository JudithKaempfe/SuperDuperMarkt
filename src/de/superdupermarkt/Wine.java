package de.superdupermarkt;

import java.time.LocalDate;
import java.util.ArrayList;

public class Wine extends AProduct {
    public Wine(String productName, int productQuality, float basePrice, LocalDate date) {
        super(productName, productQuality, basePrice, date);
        shelfPrice = super.productPrice();
        lastQualityIncrease = getDate().minusDays(10);
    }


    private float shelfPrice;
    private LocalDate lastQualityIncrease;

    //überschreibt Produktpreis mit der oben erstellten Variable shelfPrice
    @Override
    public float productPrice() {
        return shelfPrice;
    }

    @Override
    public void timeAdvancing() {
        //wenn heute vor Stichtag, dann mache nichts
        if (Main.today.isBefore(getDate()))
            return;
        //andernfalls, wenn Produktqualität größer oder gleich 50, mache nichts
        if (getProductQuality() >= 50)
            return;
        // andernfalls, wenn letzte Qualitätssteigerung nicht 10 Tage her ist, mache nichts
        if (!lastQualityIncrease.isBefore(Main.today.minusDays(9)))
            return;
        //andernfalls, erhöhe Qualität um 1 und setze letzte Qualitätserhöhung auf heute
        setProductQuality(getProductQuality() + 1);
        lastQualityIncrease = Main.today;
    }

    /**
     * überprüft Weinprodukt, ob die Vorraussetzungen erfüllt sind, und stellt es ggf ins regal
     * @param shelf
     */
    @Override
    public void restocking(ArrayList<AProduct> shelf) {
        System.out.println();
        System.out.println(this);
        if (this.getProductQuality() > 0)
            shelf.add(this);
    }

    @Override
    public boolean toClearFromShelf() {
        return false;
    }

}
