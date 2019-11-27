package racetrack;

import java.util.*;
import java.io.*;

public abstract class Horse extends HashMap {
    protected String name;

    protected int weight;

    protected int numberOfWins;
    protected int numberOfPlaces;
    protected int numberOfShows;

    protected int topSpeed;
    protected int avgSpeed;

//    protected Set<Customer> customersBettingOnHorse;

    //EFFECTS: Constructor for horse object with name
    public Horse(String someName) {
        this.name = someName;
//        customersBettingOnHorse = new HashSet<Customer>();
    }

    //EFFECTS: Returns horse name
    public String getName() {
        return name;
    }

    //EFFECTS: Returns horse weight
    public int getWeight() {
        return weight;
    }

    //MODIFIES: this
    //EFFECTS: Adds weights associated with horse
    public void setWeight(int someWeight) {
        this.weight = someWeight;
    }

//    public void addCustomerToSet(Customer someCust) {
//        this.customersBettingOnHorse.add(someCust);
//    }
//
//    public int getSizeOfCustomersBetting() {
//        return this.customersBettingOnHorse.size();
//    }

//    @Override
//    public int hashCode() {
//        String title = name + name;
//        return title.hashCode();
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) {
//            return true;
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//
//        Horse other = (Horse) obj;
//        return this.getName().equals(other.getName());
//    }

}
