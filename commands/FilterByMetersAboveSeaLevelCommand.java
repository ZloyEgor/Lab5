package commands;

import app.Application;
import classes.City;

import java.util.ArrayList;

/**
 * Command that display elements, the value of the metersAboveSeaLevel field of which is equal to the given one
 */
public class FilterByMetersAboveSeaLevelCommand extends Command{

    public FilterByMetersAboveSeaLevelCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        Float metersAboveSeaLevel;
        ArrayList<City> cities = new ArrayList<>();
        String inputString = application.getArgument();
        try{
            metersAboveSeaLevel = Float.parseFloat(inputString);
            for(City city: application.getCollection().getCollectionVector()){
                if (city.getMetersAboveSeaLevel().equals(metersAboveSeaLevel)){
                    cities.add(city);
                }

            }
            if(cities.isEmpty())
                System.out.println("Elements with this metersAboveSeaLevel value is not found");
            else
                for(City city: cities)
                    System.out.println(city.toString());

        } catch (NumberFormatException e){
            System.out.println("Error: incorrect value of metersAboveSeaLevel");
        }
    }

    @Override
    public String getInformationAboutCommand() {
        return "filter_by_meters_above_sea_level metersAboveSeaLevel:\tdisplay elements, the value of the metersAboveSeaLevel field of which is equal to the given one";
    }

    @Override
    public boolean needsArgument() {
        return true;
    }

    @Override
    public String toString() {
        return "filter_by_meters_above_sea_level";
    }
}
