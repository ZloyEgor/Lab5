package commands;

import app.Application;
import app.CityBuilder;
import app.CreatingCityCommand;
import classes.City;

/**
 * Command that adds new item to the collection if its value is less than the smallest item in this collection
 */
public class AddIfMinCommand extends Command implements CreatingCityCommand {

    public AddIfMinCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        City cityToAdd = CityBuilder.buildCity(application.getScanner());
        long min_id = 1000;
        for(City city: application.getCollection().getCollectionVector()){
            if(city.getId() < min_id)
                min_id = city.getId();
        }

        if(cityToAdd.getId() < min_id){
            application.getCollection().addElement(cityToAdd);
            System.out.println("Element added successfully");
        } else {
            System.out.println("This city has not the smallest id, element not added");
        }
    }

    @Override
    public void executeInScript(City generatedCity) {
        long min_id = 1000;

        for(City city: application.getCollection().getCollectionVector()){
            if(city.getId() < min_id)
                min_id = city.getId();
        }

        if(generatedCity.getId() < min_id){
            application.getCollection().addElement(generatedCity);
            System.out.println("Element added successfully");
        } else {
            System.out.println("This city has not the smallest id, element not added");
        }
    }

    @Override
    public String getInformationAboutCommand() {
        return "add_if_min {element}:\tadds new item to the collection if its value is less than the smallest item in this collection";
    }

    @Override
    public boolean needsArgument() {
        return false;
    }

    @Override
    public String toString() {
        return "add_if_min";
    }

}
