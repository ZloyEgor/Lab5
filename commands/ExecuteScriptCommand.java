package commands;

import app.Application;
import app.FileWorker;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Command that reads and executes the script from the specified file
 */
public class ExecuteScriptCommand extends Command{
    static HashMap<String, Integer> callIteration;

    public ExecuteScriptCommand(Application application) {
        super(application);
        callIteration = new HashMap<>();
    }

    @Override
    public void execute() {
        String path = application.getArgument();
        //String path = "src\\data\\script.txt";
        if(!callIteration.containsKey(path)){
            callIteration.put(path, 0);
        } else {
            callIteration.put(path, callIteration.get(path) + 1);
        }
        int iterationLimit = 3;
        if(callIteration.get(path) < iterationLimit) {
            ArrayList<String[]> commandLines = FileWorker.getCommandsFromFile(path);
            application.getScriptHandler().execute(commandLines);
        }

    }

    @Override
    public String getInformationAboutCommand() {
        return "execute_script name:\tread and execute the script from the specified file.\n" +
                "The script contains commands in the same form in which the user enters them interactively";
    }

    @Override
    public boolean needsArgument() {
        return true;
    }

    @Override
    public String toString() {
        return "execute_script";
    }
}
