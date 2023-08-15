package org.example;

import java.util.Random;

public class Main {

    public static void main( String[] args ) {

        Random r = new Random();
        int index = r.nextInt(0,3);

        TopCat playCat = new PlayCat();
        TopCat hunterCat = new HunterCat();
        TopCat cleanCat = new CleanCat();
        TopCat[] cats = { playCat, hunterCat, cleanCat };

        HouseHold houseHold = new HouseHold( playCat );

        houseHold.setCat( cats[index] );

        System.out.println( houseHold.useCat() );
    }
}