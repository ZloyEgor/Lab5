package commands;

import app.Application;

/**
 * Command that displays information about the collection
 */
public class InfoCommand extends Command{

    public InfoCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        System.out.println(application.getCollection().getCollectionInfo());
    }

    @Override
    public String getInformationAboutCommand() {
        return "info:\tdisplays information about the collection";
    }

    @Override
    public boolean needsArgument() {
        return false;
    }

    @Override
    public String toString() {
        return "info";
    }
}
