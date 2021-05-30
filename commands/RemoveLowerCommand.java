package commands;

import app.Application;
import app.CityBuilder;
import app.CreatingCityCommand;
import classes.City;

/**
 * Command that deletes all elements from the collection that are less than the given one
 */
public class RemoveLowerCommand extends Command implements CreatingCityCommand {

    public RemoveLowerCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        int i = 0;
        City cityToCompare = CityBuilder.buildCity(application.getScanner());
        for(City city: application.getCollection().getCollectionVector()){
            if(cityToCompare.getId() > city.getId()) {
                application.getCollection().removeElement(city);
                i++;
            }
        }
        System.out.println("Deleted " + i + " cities");
    }

    @Override
    public void executeInScript(City generatedCity) {
        int i = 0;
        for(City city: application.getCollection().getCollectionVector()){
            if(generatedCity.getId() > city.getId()) {
                application.getCollection().removeElement(city);
                i++;
            }
        }
        System.out.println("Deleted " + i + " cities");
    }

    @Override
    public String getInformationAboutCommand() {
        return "remove_lower:\tdeletes all elements from the collection that are less than the given one";
    }

    @Override
    public boolean needsArgument() {
        return false;
    }

    @Override
    public String toString() {
        return "remove_lower";
    }

}
