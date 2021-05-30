package app;

import classes.City;
import exceptions.UnableToCreateCityException;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that converts {@link Collection} object to ArrayList<String[]> and back
 * @see FileWorker
 */
public class CollectionHandler {

    /**
     * converts ArrayList<String[]> to Collection object
     * @param lines can be handed by {@link FileWorker}
     * @return collection of {@link City} objects
     */
    public static Collection convertFromLines(ArrayList<String[]> lines){

        Collection collection = new Collection();
        City city;

        try {
            for (int i = 0; i < lines.size(); i++) {

                String[] arr = lines.get(i);
                try {
                    city = new City(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[10], arr[11]);
                    collection.addElement(city);
                } catch (UnableToCreateCityException e) {
                    System.out.println("Error: unable to handle city: line " + (i + 1));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: line " + (i + 1) + " have less arguments than needed");
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        Collections.sort(collection.getCollectionVector());
        return collection;
    }

    /**
     * converts ArrayList<String[]> to Collection object
     * @param collection of {@link City} objects
     * @return can be handled by {@link FileWorker}
     */
    public static ArrayList<String[]> getLinesFromCollection(Collection collection){
        ArrayList<String[]> lines = new ArrayList<>();
        String[] line;

        for(City city : collection.getCollectionVector()){
            line = new String[12];
            line[0] = String.valueOf(city.getId());
            line[1] = city.getName();
            line[2] = String.valueOf(city.getCoordinates().getX());
            line[3] = String.valueOf(city.getCoordinates().getY());
            line[4] = city.getCreationDate();
            line[5] = String.valueOf(city.getArea());
            line[6] = String.valueOf(city.getPopulation());
            line[7] = String.valueOf(city.getMetersAboveSeaLevel());
            line[8] = String.valueOf(city.getCarCode());
            line[9] = city.getGovernment().toString();
            line[10] = city.getStandardOfLiving().toString();
            line[11] = String.valueOf(city.getGovernor() == null? "" : city.getGovernor().getAge());
            lines.add(line);
        }

        return lines;
    }

}
