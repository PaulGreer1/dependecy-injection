### Dependency Injection

Cats are individuals. Some like to play, some like to hunt, others are very clean. Every household should have a cat, but which type? It would be very inconvenient for a household to have a cat for each different requirement. Personally, I want only one cat, and I want him to behave differently according to my requirements at any given time.

The following app demontrates the dependency injection (DI) pattern.

```
public interface TopCat {
    String doYourThing();
}

public class PlayCat implements TopCat {
    @Override
    public String doYourThing() {
        String myThing = "Roll around when tickled, get tangled up in wool, then try to dance on my keyboard and trash my current Java project.";
        return myThing;
    }
}

public class HunterCat implements TopCat {
    @Override
    public String doYourThing() {
        String myThing = "Go on a mouse hunt and minimise the current infestation.";
        return myThing;
    }
}

public class CleanCat implements TopCat {
    @Override
    public String doYourThing() {
        String myThing = "Vacuum the living room carpet, do the washing up, then make me some strong coffee.";
        return myThing;
    }
}

public class HouseHold {

    TopCat cat;
    
    HouseHold( TopCat cat ) {
        this.cat = cat;
    }
    
    public void setCat( TopCat cat ) {
        this.cat = cat;
    }
    
    public void useCat() {
        this.cat.doYourThing();
    }    
}

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

```

So clearly, the household depends on its cat. The cat is a dependency of the household.

Different implementations of the TopCat interface can provide different functionalities depending on the state of the system. In terms of DI, an appropriate TopCat dependency is injected into the HouseHold object given the state of the system at any given time.

the HouseHold object does not have to instantiate TopCat objects. it simply declares a mutable variable to hold a reference to the current TopCat which was last injected into it.

HouseHold and TopCat are loosely coupled. HouseHold objects know nothing about the internals of TopCat objects.

versatile - the same code in the HouseHold can call different behaviours on the TopCat. with a setter, the same variable can hold different TopCat references at different times. without DI, the HouseHold would need to instantiate different TopCat objects. the framework controls what the HouseHold does (this is inversion of control (IoC)), and when it does it, and the HouseHold does not have to be modified or developed in order to provide this behavioural versatility. moreover, the framework's TopCat can be passed around to various objects. when any of these objects changes the state of injected object, then all other dependent objects which hold a reference to the same object have immediate access to those state changes.

I've known for some time about DI being one of Spring's crucial features. it is always the theory of computer science, paradigms, design patterns, etc. which is challenging. I understand the theory of DI, and have actually been using it for many years in various situations. Spring's use of DI is merely a technical matter for me to learn. I can assure you that this would not be a problem for me.

> "Note that we write the code to create and inject the dependencies manually. In practice, a dependency injection container/framework like Spring will do the wiring automatically. You just declare the dependency information via XML file or annotations in Java classes, and the framework manages the dependencies for you."


























### asdf