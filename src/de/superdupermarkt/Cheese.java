package de.superdupermarkt;


import java.time.LocalDate;
import java.util.ArrayList;

public class Cheese extends AProduct {
    public Cheese(String productName, int productQuality, float basePrice, LocalDate date) {
        super(productName, productQuality, basePrice, date);
    }

    /**
     * lässt die Käseprodukt Qualität um eins sinken
     */
    @Override
    public void timeAdvancing() {
        setProductQuality(getProductQuality() - 1);
    }

    /**
     * überprüft dieses käseprodukt, ob die Vorrausetzungen erfüllt sind und stellt den Käse ggf ins regal
     * @param shelf = Liste aller Produkte die ins regal durften
     */
    @Override
    public void restocking(ArrayList<AProduct> shelf) {
        System.out.println();
        System.out.println(this);
        if (this.getProductQuality() >= 30) {
            shelf.add(this);
        }
    }

    @Override
    public boolean toClearFromShelf() {
        if (this.getProductQuality() < 30 ) {
            return true;
        }
        if (this.getDate().isBefore(Main.today)) {
            return true;
        }
        return false;
    }
}
