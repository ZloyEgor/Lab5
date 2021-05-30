package commands;

import app.Application;
import classes.City;

/**
 * Command that displays all elements of the collection
 */
public class ShowCommand extends Command{

    public ShowCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        if(!application.getCollection().getCollectionVector().isEmpty()) {
            for (City city : application.getCollection().getCollectionVector()) {
                System.out.println(city.toString());
                System.out.print("\n");
            }
        } else
            System.out.println("Collection is empty, nothing to show");
    }

    @Override
    public String getInformationAboutCommand() {
        return "show:\tdisplays all elements of the collection";
    }

    @Override
    public boolean needsArgument() {
        return false;
    }

    @Override
    public String toString() {
        return "show";
    }
}
