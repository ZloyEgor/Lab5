package app;

import classes.City;
import commands.Command;
import commands.ExitCommand;
import exceptions.UnableToCreateCityException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that executes commands written in script file
 * @see commands.ExecuteScriptCommand
 */
public class ScriptHandler {

    /**
     * @param commands HashMap that contains {@link Command} heir objects
     * @param application link to {@link Application} class object
     */
    private final HashMap<String, Command> commands;
    private final Application application;

    public ScriptHandler(Application application) {
        this.application = application;
        commands = application.getCommands();
    }

    /**
     * method that executes script commands
     * @param commandLines lines of command those can be handed by {@link FileWorker}
     */
    public void execute(ArrayList<String[]> commandLines){

        int counterOfSkipIterations = 0;
        for(String[] args : commandLines){
            if(counterOfSkipIterations > 0){
                counterOfSkipIterations--;
                continue;
            }

            if(commands.containsKey(args[0])){
                if(!commands.get(args[0]).needsArgument() && !(commands.get(args[0]) instanceof CreatingCityCommand)){
                    commands.get(args[0]).execute();
                } else if(!commands.get(args[0]).needsArgument() && commands.get(args[0]) instanceof CreatingCityCommand){
                    try {
                        City city = CityBuilder.buildCityInScript(new ArrayList<>(commandLines.subList(commandLines.indexOf(args) + 1, commandLines.indexOf(args) + 10)));
                        ((CreatingCityCommand)commands.get(args[0])).executeInScript(city);
                        counterOfSkipIterations = 9;
                    } catch (UnableToCreateCityException e){
                        continue;
                    }
                }

                else {
                    if(args.length > 1 && !((commands.get(args[0]) instanceof CreatingCityCommand))){
                        application.setArgument(args[1]);
                        commands.get(args[0]).execute();
                    }
                    else if(args.length > 1 && commands.get(args[0]) instanceof CreatingCityCommand){
                        try{
                            City city = CityBuilder.buildCityInScript(new ArrayList<>(commandLines.subList(commandLines.indexOf(args) + 1, commandLines.indexOf(args) + 10)));
                            ((CreatingCityCommand)commands.get(args[0])).executeInScript(city);

                        } catch (UnableToCreateCityException e){
                            System.err.println("City building failed");
                            continue;
                        }
                    }
                }
                if(commands.get(args[0]).getClass() == ExitCommand.class) {
                    break;
                }
            }
        }
    }
}
