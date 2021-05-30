package commands;

import app.Application;

/**
 * Command that ends the program
 */
public class ExitCommand extends Command{
    public ExitCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        System.out.println("Exit the program...");
    }

    @Override
    public String getInformationAboutCommand() {
        return "exit:\tends the program (without saving to file)";
    }

    @Override
    public boolean needsArgument() {
        return false;
    }

    @Override
    public String toString() {
        return "exit";
    }
}
