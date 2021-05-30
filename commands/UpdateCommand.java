package commands;

import app.Application;
import app.CityBuilder;
import app.CreatingCityCommand;
import classes.City;

/**
 * Command that updates the value of the collection element whose id is equal to the given
 */
public class UpdateCommand extends Command implements CreatingCityCommand {

    public UpdateCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        long id;
        String inputString = application.getArgument();
        try{
            id = Long.parseLong(inputString);
            if(application.getCollection().getCollectionVector().stream().noneMatch(city -> city.getId() == id)){
                System.out.println("None of elements of the collection have this id value");
            }else{
                City cityToChange = null;
                for (City city: application.getCollection().getCollectionVector()){
                    if(city.getId() == id){
                        cityToChange = city;
                        break;
                    }
                }
                application.getCollection().getCollectionVector().removeElement(cityToChange);
                cityToChange = CityBuilder.buildCity(application.getScanner());
                cityToChange.setId(id);
                application.getCollection().addElement(cityToChange);
            }
        } catch (NumberFormatException e){
            System.out.println("Error: incorrect value of id");
        }
    }

    @Override
    public void executeInScript(City generatedCity) {
        long id;
        String inputString = application.getArgument();
        try{
            id = Long.parseLong(inputString);
            if(application.getCollection().getCollectionVector().stream().noneMatch(city -> city.getId() == id)){
                System.out.println("None of elements of the collection have this id value");
            }else{
                City cityToChange = null;
                for (City city: application.getCollection().getCollectionVector()){
                    if(city.getId() == id){
                        cityToChange = city;
                        break;
                    }
                }
                application.getCollection().getCollectionVector().removeElement(cityToChange);
                cityToChange = generatedCity;
                cityToChange.setId(id);
                application.getCollection().addElement(cityToChange);
            }
        } catch (NumberFormatException e){
            System.out.println("Error: incorrect value of id");
        }
    }

    @Override
    public String getInformationAboutCommand() {
        return "update id {element}:\tupdates the value of the collection element whose id is equal to the given";
    }

    @Override
    public boolean needsArgument() {
        return true;
    }

    @Override
    public String toString() {
        return "update";
    }

}
