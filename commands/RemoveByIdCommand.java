package commands;

import app.Application;
import classes.City;

/**
 * Command that removes element with specified id from the collection
 */
public class RemoveByIdCommand extends Command{
    public RemoveByIdCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        long id;
        boolean deleted = false;
        String inputString = application.getArgument();
        try{
            id = Long.parseLong(inputString);
            for(City city: application.getCollection().getCollectionVector()){
                if (city.getId() == id){
                    application.getCollection().removeElement(city);
                    deleted = true;
                }

            }
            if(!deleted)
                System.out.println("Element with this id is not found");
        } catch (NumberFormatException e){
            System.out.println("Error: incorrect value of id");
        }
    }

    @Override
    public String getInformationAboutCommand() {
        return "remove_by_id id:\tremoves element with specified id from the collection";
    }

    @Override
    public boolean needsArgument() {
        return true;
    }

    @Override
    public String toString() {
        return "remove_by_id";
    }

}
