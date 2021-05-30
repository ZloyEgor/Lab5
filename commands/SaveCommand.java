package commands;

import app.Application;
import app.CollectionHandler;
import app.FileWorker;

/**
 * Command that saves collection to the output file
 */
public class SaveCommand extends Command{

    public SaveCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        String path = application.getArgument();
        FileWorker.writeFileFromCollection(CollectionHandler.getLinesFromCollection(application.getCollection()), path);
    }

    @Override
    public String getInformationAboutCommand() {
        return "save:\tsaves collection to the output file";
    }

    @Override
    public boolean needsArgument() {
        return true;
    }

    @Override
    public String toString() {
        return "save";
    }
}
