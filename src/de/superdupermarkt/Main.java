package de.superdupermarkt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    //Erstellt Variable today und setzt dafür das heutige Datum ein
    public static LocalDate today = LocalDate.now();
    private static Random rnd = new Random();
    public static LocalDate getRandomProductDate(){
        return today.plusDays(rnd.nextInt(50)+50);
    }

    public static void main(String[] args) {


        ArrayList<AProduct> shelf = new ArrayList<>();

        ArrayList<AProduct> toDelete =  new ArrayList<>();



        Wine Chardonnay = new Wine("Chardonnay", rnd.nextInt(50), 15, today.plusDays(rnd.nextInt(50)+50));
        Wine Merlot = new Wine("Merlot", rnd.nextInt(50), 18, today.plusDays(rnd.nextInt(50)+50));
        Cheese Parmesan = new Cheese ("Parmesan", rnd.nextInt(50), 5, today.plusDays(rnd.nextInt(50)+50));
        Cheese Mozzarella = new Cheese ("Mozzarella", rnd.nextInt(50), 7, today.plusDays(rnd.nextInt(50)+50));

        Cheese TestKäse1 = new Cheese("TestKäse1", 29, 10, getRandomProductDate());
        Cheese TestKäse2 = new Cheese("TestKäse2", 30, 10, getRandomProductDate());
        Cheese TestKäse3 = new Cheese("TestKäse3", 31, 10, getRandomProductDate());

        Wine TestWein1 = new Wine("TestWein1", 49, 25, today);
        Wine TestWein2 = new Wine("TestWein2", 50, 25, today);
        Wine TestWein3 = new Wine("TestWein3", 51, 25, today);
        Wine TestWein4 = new Wine("TestWein4", -1, 25, today);
        Wine TestWein5 = new Wine("TestWein5",  0, 25, today);
        Wine TestWein6 = new Wine("TestWein6",  1, 25, today);

        System.out.println("\n----------------------------------" + "\nProduktverwaltung SuperDuperMarkt" + "\n----------------------------------" + "\n");
        System.out.println("\nÜbersicht aller vorhandenen Produkte:");
        System.out.println("\nHeute ist der: " + today);


        Chardonnay.restocking(shelf);
        Merlot.restocking(shelf);
        Parmesan.restocking(shelf);
        Mozzarella.restocking(shelf);


        TestKäse1.restocking(shelf);
        TestKäse2.restocking(shelf);
        TestKäse3.restocking(shelf);

        TestWein1.restocking(shelf);
        TestWein2.restocking(shelf);
        TestWein3.restocking(shelf);

        TestWein4.restocking(shelf);
        TestWein5.restocking(shelf);
        TestWein6.restocking(shelf);

        System.out.println("\nHeute ist der: "+today);
        System.out.println("\nFolgende Produkte befinden sich im Regal:");

        //Druckt jedes Produkt im Regal aus und überprüft, ob die produkte im shelf bleiben dürfen:
        for (AProduct product : shelf) {
            System.out.println("\n" + product);
            if (product.toClearFromShelf()) {
                toDelete.add(product);
            }
        }
        System.out.println("\nFolgende Produkte müssen aus dem Regal entfernt werden:");
        for (AProduct product : toDelete) {
            System.out.println("\n" + product);
        }

        shelf.removeAll(toDelete);
        toDelete.clear();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMöchten Sie das Programm beenden? x");
            System.out.println("\nMöchten Sie den nächsten Tag anzeigen? <jeder andere char>");

            String input = sc.nextLine();
            if (input.length() > 0)
                if (input.charAt(0) == 'x')
                    return;

            //lässt einen Tag verstreichen
            today = today.plusDays(1);

            System.out.println("\nHeute ist der: "+today);
            System.out.println("\nFolgende Produkte befinden sich im Regal:");

            //Druckt jedes Produkt im Regal aus und überprüft, ob die produkte im shelf bleiben dürfen:
            for (AProduct product : shelf) {
                product.timeAdvancing();
                System.out.println("\n" + product);
                if (product.toClearFromShelf()) {
                    toDelete.add(product);
                }
            }

            System.out.println("\nFolgende Produkte müssen aus dem Regal entfernt werden:");
            for (AProduct product : toDelete) {
                System.out.println("\n" + product);
            }

            shelf.removeAll(toDelete);
            toDelete.clear();
        }

    }

}


