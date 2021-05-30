package commands;

import app.Application;

/**
 * Abstract class of commands
 */
public abstract class Command {

    /**
     * @param application link to {@link Application} class object
     */
    protected Application application;

    public Command(Application application){
        this.application = application;
    }

    /**
     * execution of command
     */
    public abstract void execute();

    /**
     * @return information for {@link HelpCommand} command
     */
    public abstract String getInformationAboutCommand();

    /**
     * @return does it need an argument?
     */
    public abstract boolean needsArgument();


}
