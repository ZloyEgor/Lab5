package commands;

import app.Application;
import app.CityBuilder;
import app.CreatingCityCommand;
import classes.City;

import java.util.Collections;

/**
 * Command that adds new element to collection
 */
public class AddCommand extends Command implements CreatingCityCommand {

    public AddCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        application.getCollection().addElement(CityBuilder.buildCity(application.getScanner()));
        Collections.sort(application.getCollection().getCollectionVector());
        System.out.println("Element added successfully!");
    }

    @Override
    public void executeInScript(City generatedCity) {
        if(generatedCity != null) {
            application.getCollection().addElement(generatedCity);
            Collections.sort(application.getCollection().getCollectionVector());
            System.out.println("Element added successfully!");
        } else
            System.out.println("Element is null, unable to add");
    }

    @Override
    public String getInformationAboutCommand() {
        return "add {element}:\tadds new element to the collection";
    }

    @Override
    public boolean needsArgument() {
        return false;
    }

    @Override
    public String toString() {
        return "add";
    }

}
