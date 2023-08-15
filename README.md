### Dependency Injection

This app demontrates the dependency injection (DI) pattern. But first, I need to say a few words about cats.

Cats are individuals. Some like to play, some like to hunt, others are very clean. Every household should have a cat, but which type?

It would be very inconvenient for a household to have a cat for each different requirement. Personally, I need only one cat, and I want him to behave differently according to my requirements at any given time.

A household depends on its cat, and the cat is a dependency of the household. Now, please inspect the code in the di-demo app (it is very short and simple), and then run the app a few times. Observe the different outputs. Each output corresponds to a particular type of cat.

Different implementations of the TopCat interface can provide different functionalities depending on the state of the system. In terms of DI, an appropriate TopCat dependency is injected into the HouseHold object according to the state of the system at any given time.

In order for the HouseHold object to invoke different cat behaviours at different times, it does not have to instantiate new TopCat objects, it simply declares a mutable variable to hold a reference to the current TopCat object which was last 'injected' into it.

HouseHold and TopCat are loosely coupled. HouseHold objects know nothing about the internals of TopCat objects. This means that the HouseHold object is highly versatile, and the HouseHold class is much easier to develop and maintain. The same code in the HouseHold object can call different behaviours on the current TopCat object, and with a setter method, the same variable can hold different TopCat references at different times. Without DI, the HouseHold object would need to instantiate different TopCat objects as different behavioural requirements arose.

The framework controls what the HouseHold does, and when it does it. This is known as 'inversion of control' (IoC). The HouseHold class does not have to be modified or developed in order to provide this behavioural versatility.

Another important observation is that the framework's TopCat object can be passed around to various other dependent objects, and when any of these objects change the state of the injected object, then all the other dependent objects which hold a reference to the dependency object have immediate access to those state changes.

It is always the theory of computer science, paradigms, design patterns, etc. which are the most challenging. I understand the theory of DI, and have actually been using it for many years in various situations. For example, the Registrar object in the following system is a dependency object:

https://github.com/PaulGreer1/TheGardenersWeb

I have known for some time about DI being one of Spring's crucial features. I can assure you that this will not be a problem for me.
