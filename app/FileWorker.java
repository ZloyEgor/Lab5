package app;

import java.io.*;
import java.util.ArrayList;

/**
 * Class that can read and write files
 * @see CollectionHandler
 */
public class FileWorker {

    /**
     * reads file that contains information about collection elements
     * @param path path of file
     * @return ArrayList<String[]> that can be handled by {@link CollectionHandler}
     */
    public static ArrayList<String[]> getCollectionDataFromFile(String path){

        String localFilePath = "src\\main\\java\\data\\input.csv";

        ArrayList<String[]> lines = new ArrayList<>();
        String thisLine;


        try{

            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(localFilePath));
            try{
                bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
            } catch (FileNotFoundException | SecurityException e){
                System.out.println("File on specified path is not found or inaccessible\n" +
                        "Default file will be loaded.");
            }

            DataInputStream myInput = new DataInputStream(bufferedInputStream);

            while((thisLine = myInput.readLine()) != null && !thisLine.isEmpty()){
                String arr[] = thisLine.replace(",,", ", ,").split(",");
                lines.add(arr);
            }
            myInput.close();
        }
        catch (FileNotFoundException | SecurityException e){
            System.out.println("Error: default file is not found. Collection is empty");
        }
        catch (IOException e){
            System.out.println("Error: something went wrong");
        }

        return lines;
    }

    /**
     * writes file that contain information about collection
     * @param lines can be handed by {@link CollectionHandler}
     */

    public static void writeFileFromCollection(ArrayList<String[]> lines, String path){
        try{
            BufferedOutputStream stream;
            if(path.trim().isEmpty())
                stream = new BufferedOutputStream(new FileOutputStream("src\\data\\output.csv"));
            else {
                File file = new File(path);
                if(!file.exists()){
                    System.out.println(file.createNewFile()? "File created successfully" : "File not created");
                }
                stream = new BufferedOutputStream(new FileOutputStream(file));
            }
            for(String[] line : lines){
                for (String s : line) {
                    stream.write(s.getBytes());
                    stream.write(",".getBytes());
                }
                stream.write(System.lineSeparator().getBytes());
            }
            stream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * reads script file
     * @param path path of file
     * @return ArrayList<String[]> that can be handled by {@link ScriptHandler}
     */
    public static ArrayList<String[]> getCommandsFromFile(String path){
        ArrayList<String[]> commands = new ArrayList<>();
        String thisLine;

        try{
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
            DataInputStream myInput = new DataInputStream(bufferedInputStream);

            while((thisLine = myInput.readLine()) != null){
                String args[] = thisLine.split("[\\s,]+");
                commands.add(args);
            }

        } catch (FileNotFoundException | SecurityException e) {
            System.out.println("File on specified path is not found or inaccessible");

        } catch (IOException e) {
            System.out.println("Error: reading specified file failed");
        }
        return commands;
    }
}
