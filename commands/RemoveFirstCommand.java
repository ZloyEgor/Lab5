package commands;

import app.Application;

/**
 * Command that removes first element from the collection
 */
public class RemoveFirstCommand extends Command{

    public RemoveFirstCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        application.getCollection().getCollectionVector().remove(0);
        System.out.println("First element removed from the collection");
    }

    @Override
    public String getInformationAboutCommand() {
        return "remove_first:\tremoves first element from the collection";
    }

    @Override
    public boolean needsArgument() {
        return false;
    }

    @Override
    public String toString() {
        return "remove_first";
    }
}
