package app;

import classes.City;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Vector;

/**
 * Collection of {@link City} objects
 */
public class Collection {

    /**
     * @param collectionVector list that contains {@link City} objects
     * @param timeInitialized time when collection was initialized
     * @param formatter represents timeInitialized in convenient way
     */
    private final Vector<City> collectionVector;
    private final LocalDateTime timeInitialized;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public Collection(){
        collectionVector = new Vector<>();
        timeInitialized = LocalDateTime.now();
    }

    public Vector<City> getCollectionVector() {
        return collectionVector;
    }

    public void addElement(City city){
        collectionVector.addElement(city);
        Collections.sort(collectionVector);
    }

    public void removeElement(City city){
        if(collectionVector.removeElement(city))
            System.out.println("Element deleted");
        else
            System.out.println("No such element found");
    }

    public String getCollectionInfo(){
        return  "Information about the Collection:" +
                "\nused class:\t\t\t\t" + collectionVector.getClass().toString().substring(6) +
                "\ninitialization time:\t" + formatter.format(timeInitialized) +
                "\namount of objects:\t\t" + collectionVector.size() +
                "\ncurrent capacity:\t\t" + collectionVector.capacity();
    }
}
