package commands;

import app.Application;

/**
 * Command that clears collection
 */
public class ClearCommand extends Command{

    public ClearCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        application.getCollection().getCollectionVector().clear();
        System.out.println("Collection cleared");
    }

    @Override
    public String getInformationAboutCommand() {
        return "clear:\tclears collection";
    }

    @Override
    public boolean needsArgument() {
        return false;
    }

    @Override
    public String toString() {
        return "clear";
    }
}
