import app.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collection collection;
        try {
            collection = CollectionHandler.convertFromLines(FileWorker.getCollectionDataFromFile(args[0]));
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Path not specified");
            collection = CollectionHandler.convertFromLines(FileWorker.getCollectionDataFromFile(""));
        }

        Application application = new Application(collection, scanner);
        application.getConsoleHandler().handleInput();
    }
}

