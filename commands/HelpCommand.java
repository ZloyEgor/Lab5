package commands;

import app.Application;

/**
 * Command that displays available commands
 */
public class HelpCommand extends Command{

    public HelpCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        for(Command command: application.getCommands().values()){
            System.out.println(command.getInformationAboutCommand());
        }
    }

    @Override
    public String getInformationAboutCommand() {
        return "help:\tdisplay help for available commands";
    }

    @Override
    public boolean needsArgument() {
        return false;
    }

    @Override
    public String toString() {
        return "help";
    }
}
