package org.example;

public class HouseHold {

    TopCat cat;

    HouseHold( TopCat cat ) {
        this.cat = cat;
    }

    public void setCat( TopCat cat ) {
        this.cat = cat;
    }

    public String useCat() {
        return this.cat.doYourThing();
    }
}
