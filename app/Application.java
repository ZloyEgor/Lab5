package app;

import commands.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class of Application, this class runs whole program
 * @see Collection
 * @see ConsoleHandler
 * @see ScriptHandler
 */
public class Application {

    /**
     * @param collection collection of {@link classes.City} objects
     * @param scanner scanner that allows to get user's commands
     * @param consoleHandler processes user's input
     * @param scriptHandler processes script files
     * @param commands HashMap that contains {@link Command} heir objects
     * @param argument argument which can be taken by user's input and handed to execute command
     */
    private Collection collection;
    private Scanner scanner;
    private ConsoleHandler consoleHandler;
    private ScriptHandler scriptHandler;
    private final HashMap<String, Command> commands;
    private String argument;


    public Application(){
        collection = new Collection();
        scanner = new Scanner(System.in);
        consoleHandler = new ConsoleHandler(this);
        scriptHandler = new ScriptHandler(this);
    }

    public Application(Collection collection, Scanner scanner){
        this.collection = collection;
        this.scanner = scanner;
        consoleHandler = new ConsoleHandler(this);
        scriptHandler = new ScriptHandler(this);

    }
    {
        commands = new HashMap<>();

        AddCommand addCommand = new AddCommand(this);
        AddIfMinCommand addIfMinCommand = new AddIfMinCommand(this);
        ClearCommand clearCommand = new ClearCommand(this);
        ExecuteScriptCommand executeScriptCommand = new ExecuteScriptCommand(this);
        ExitCommand exitCommand = new ExitCommand(this);
        FilterByMetersAboveSeaLevelCommand filterByMetersAboveSeaLevelCommand =
                new FilterByMetersAboveSeaLevelCommand(this);
        GroupCountingByIdCommand groupCountingByIdCommand = new GroupCountingByIdCommand(this);
        HelpCommand helpCommand = new HelpCommand(this);
        InfoCommand infoCommand = new InfoCommand(this);
        MinByStandardOfLivingCommand minByStandardOfLivingCommand = new MinByStandardOfLivingCommand(this);
        RemoveByIdCommand removeByIdCommand = new RemoveByIdCommand(this);
        RemoveFirstCommand removeFirstCommand = new RemoveFirstCommand(this);
        RemoveLowerCommand removeLowerCommand = new RemoveLowerCommand(this);
        SaveCommand saveCommand = new SaveCommand(this);
        ShowCommand showCommand = new ShowCommand(this);
        UpdateCommand updateCommand = new UpdateCommand(this);

        commands.put(addCommand.toString(), addCommand);
        commands.put(addIfMinCommand.toString(), addIfMinCommand);
        commands.put(clearCommand.toString(), clearCommand);
        commands.put(executeScriptCommand.toString(), executeScriptCommand);
        commands.put(exitCommand.toString(), exitCommand);
        commands.put(filterByMetersAboveSeaLevelCommand.toString(), filterByMetersAboveSeaLevelCommand);
        commands.put(groupCountingByIdCommand.toString(), groupCountingByIdCommand);
        commands.put(helpCommand.toString(), helpCommand);
        commands.put(infoCommand.toString(), infoCommand);
        commands.put(minByStandardOfLivingCommand.toString(), minByStandardOfLivingCommand);
        commands.put(removeByIdCommand.toString(), removeByIdCommand);
        commands.put(removeFirstCommand.toString(), removeFirstCommand);
        commands.put(removeLowerCommand.toString(), removeLowerCommand);
        commands.put(saveCommand.toString(), saveCommand);
        commands.put(showCommand.toString(), showCommand);
        commands.put(updateCommand.toString(), updateCommand);
    }

    public Collection getCollection() {
        return collection;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public ConsoleHandler getConsoleHandler() {
        return consoleHandler;
    }

    public ScriptHandler getScriptHandler() {
        return scriptHandler;
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }
}
