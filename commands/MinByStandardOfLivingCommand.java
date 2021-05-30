package commands;

import app.Application;
import classes.City;

/**
 * Command that displays the object with the lowest standard of living
 */
public class MinByStandardOfLivingCommand extends Command{

    public MinByStandardOfLivingCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        int minLevel = 6;
        City cityWithMinLevel = null;
        for(City city : application.getCollection().getCollectionVector()){
            if(city.getStandardOfLiving().getLevel() < minLevel){
                cityWithMinLevel = city;
                minLevel = city.getStandardOfLiving().getLevel();
            }
        }
        try {
            System.out.println("City with the lowest standard of living:");
            System.out.println(cityWithMinLevel.toString());
        } catch (NullPointerException e){
            System.out.println("Unable to display object, collection is empty");
        }
    }

    @Override
    public String getInformationAboutCommand() {
        return "min_by_standard_of_living:\tdisplays the object with the lowest standard of living";
    }

    @Override
    public boolean needsArgument() {
        return false;
    }

    @Override
    public String toString() {
        return "min_by_standard_of_living";
    }
}
