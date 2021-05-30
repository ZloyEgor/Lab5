package app;

import commands.*;

import java.util.HashMap;

/**
 * class that executes commands of user input
 */
public class ConsoleHandler {

    /**
     * @param commands HashMap that contains {@link Command} heir objects
     * @param application  link to {@link Application} class object
     * @param needToFinish if true, quits
     */
    private final HashMap<String, Command> commands;
    private final Application application;
    private boolean needToFinish;

    public ConsoleHandler(Application application){
        this.application = application;
        needToFinish = false;
        commands = application.getCommands();

    }

    public void handleInput(){

        while(!needToFinish){
            String line = application.getScanner().nextLine();
            String[] args = line.trim().split("\\s+");

            if(commands.containsKey(args[0])){
                if(!commands.get(args[0]).needsArgument()){
                    if(args.length == 1)
                        commands.get(args[0]).execute();
                    else {
                        System.out.println("This command doesn't need arguments");
                    }
                } else {
                    if(args.length == 2){
                        application.setArgument(args[1]);
                        commands.get(args[0]).execute();
                    }
                    else if(args.length == 1){
                        application.setArgument("");
                        commands.get(args[0]).execute();
                    }
                    else {
                        System.out.println("This command needs only one argument");
                    }
                }
                if(commands.get(args[0]).getClass() == ExitCommand.class) {
                    needToFinish = true;
                }
            } else
                System.out.println("No such command found, type help to see available commands");

        }
    }

}
