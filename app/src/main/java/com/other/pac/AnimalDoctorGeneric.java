package com.other.pac;

import java.util.ArrayList;
import java.util.List;

public class AnimalDoctorGeneric {

    int ss=0;
    long dd=231;

    /*Keep in mind that the wildcards can be used only for reference declarations
(including arguments, variables, return types, and so on). They can't be used as the
type parameter when you create a new typed collection.*/
    List<? super DogSuper> dList = new ArrayList<Dog>();
    List<? extends Animal> aList = new ArrayList<Dog>();
    List<? extends Animal> foo = new ArrayList< Animal>();
    List<?> list = new ArrayList<Dog>();

    public void checkAnimals(List<? extends Animal> animals) {
        dd=ss;
//        ss=dd;// incompatible type

        /*
        * this(?) should subclass of Animal
        *
        * */
        for(Animal a : animals) {
            a.checkup();
        }
    }
    public void checkAnimalsSuper(List<? super Animal> animals) {
        /*
        <? super Animal> mean
        this(?) should be super class of Animal

    */
        /*for(Animal a : animals) {
            a.checkup();
        }*/
    }
    public static void main(String[] args) {
// make ArrayLists instead of arrays for Dog, Cat, Bird
        List<Dog> dogs = new ArrayList<Dog>();
        List<Top> supers = new ArrayList<Top>();

        dogs.add(new Dog());
        dogs.add(new Dog());
        List<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat());
        cats.add(new Cat());
        List<Bird> birds = new ArrayList<Bird>();
        birds.add(new Bird());
// this code is the same as the Array version
        AnimalDoctorGeneric doc = new AnimalDoctorGeneric();
// this worked when we used arrays instead of ArrayLists
        doc.checkAnimals(dogs); // send a List<Dog>
        doc.checkAnimals(cats); // send a List<Cat>
        doc.checkAnimals(birds); // send a List<Bird>
        doc.checkAnimalsSuper(supers);
    }
}
