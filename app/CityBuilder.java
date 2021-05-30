package app;

import classes.*;
import exceptions.UnableToCreateCityException;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Scanner;

/**
 * Class that allows to build {@link City} objects from user input or script
 */
public class CityBuilder {

    /**
     * @brief building City by user input
     * @param scanner scanner that handles user input
     * @return built City
     */
    public static City buildCity(Scanner scanner){

        String inputString;
        boolean fieldMatch = false;

        //Gets name of the city
        String name = null;
        while(!fieldMatch){
            System.out.println("Enter name of the city:");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Error: name mustn't be null, enter name again");
                continue;
            }
            fieldMatch = true;
        }

        //Gets coordinates of the city
        fieldMatch = false;
        Long x = null;
        double y = 0;
        while(!fieldMatch){
            System.out.println("Enter two arguments separated by \",\" or \" \": coordinate x (long) " +
                    "and coordinate y (double)");
            String line = scanner.nextLine();
            String[] strs = line.trim().split("[\\s,]+");
            if(strs.length != 2){
                continue;
            }
            //Checking x argument
            try{
                if(strs[0].isEmpty()){
                    System.out.println("Error: argument x mustn't be null");
                    continue;
                }
                x = Long.parseLong(strs[0]);
            } catch (NumberFormatException e){
                System.out.println("Error: argument x typed incorrectly");
                continue;
            }
            //Checking y argument
            try{
                y = Double.parseDouble(strs[1]);
            }catch (NumberFormatException e){
                System.out.println("Error: argument y typed incorrectly");
                continue;
            }
            fieldMatch = true;
        }

        //Gets area of the city
        fieldMatch = false;
        int area = 0;
        while(!fieldMatch){
            System.out.println("Enter area (int) of the city.");
            inputString = scanner.nextLine().trim();
            try {
                area = Integer.parseInt(inputString);
            } catch (NumberFormatException e){
                continue;
            }
            if (area <= 0){
                System.out.println("Error: area must be above zero");
                continue;
            }
            fieldMatch = true;
        }

        //Gets population of the city
        fieldMatch = false;
        long population = 0;
        while(!fieldMatch){
            System.out.println("Enter population (long) of the city.");
            inputString = scanner.nextLine().trim();
            try {
                population = Long.parseLong(inputString);
            } catch (NumberFormatException e){
                System.out.println("Error: incorrect value");
                continue;
            }
            if (population <= 0){
                System.out.println("Error: population must be above zero");
                continue;
            }
            fieldMatch = true;
        }

        fieldMatch = false;
        Float metersAboveSeaLevel = null;
        while(!fieldMatch){
            System.out.println("Enter meters above sea level (Float) of the city.");
            inputString = scanner.nextLine().trim();
            try{
                metersAboveSeaLevel = Float.parseFloat(inputString);
            } catch (NumberFormatException e){
                System.out.println("Error: incorrect value");
                continue;
            }
            fieldMatch = true;
        }

        fieldMatch = false;
        Integer carCode = null;
        while(!fieldMatch){
            System.out.println("Enter car code (Integer) of the city.");
            inputString = scanner.nextLine().trim();
            try{
                carCode = Integer.parseInt(inputString);
            } catch (NumberFormatException e){
                System.out.println("Error: incorrect value");
                continue;
            }
            if(carCode <= 0 || carCode > 1000){
                System.out.println("Error: car code must be above 0, max value: 1000");
                continue;
            }
            fieldMatch = true;
        }

        fieldMatch = false;
        Government government = null;
        while(!fieldMatch){
            System.out.println("Enter type of government, available options:");
            for(Government gov: EnumSet.allOf(Government.class)){
                System.out.println(gov.getDescription());
            }
            String str = scanner.nextLine().trim();
            try{
                government = Government.valueOf(str.toUpperCase());
            } catch (IllegalArgumentException e){
                System.out.println("Error: incorrect value");
                continue;
            }
            fieldMatch = true;
        }

        fieldMatch = false;
        StandardOfLiving standardOfLiving = null;
        while(!fieldMatch){
            System.out.println("Enter standard of living, available options:");
            for(StandardOfLiving std: EnumSet.allOf(StandardOfLiving.class)){
                System.out.println(std.getDescription());
            }
            String str = scanner.nextLine().trim();
            try{
                standardOfLiving = StandardOfLiving.valueOf(str.toUpperCase());
            } catch (IllegalArgumentException e){
                System.out.println("Error: incorrect value");
                continue;
            }
            fieldMatch = true;
        }

        fieldMatch = false;
        Human governor = null;
        long age = 0;
        while (!fieldMatch){
            System.out.println("Enter age of the governor, if governor is absent, leave an empty line");
            inputString = scanner.nextLine().trim();
            if (inputString.isEmpty()){
                break;
            }
            else {
                try{
                    age = Long.parseLong(inputString);
                } catch (NumberFormatException e){
                    System.out.println("Error: incorrect value");
                    continue;
                }
                if (age > 0)
                    fieldMatch = true;
                else
                    System.out.println("Error: age must be above zero");
            }
        }
        if(fieldMatch)
            governor = new Human(age);

        return new City(name, new Coordinates(x, y), area, population, metersAboveSeaLevel,
                carCode, government, standardOfLiving, governor);
    }

    /**
     * building city when script is executing
     * @param lines - lines of commands from script file
     * @return built City
     * @throws UnableToCreateCityException be thrown if arguments in script are invalid
     */
    public static City buildCityInScript(ArrayList<String[]> lines) throws UnableToCreateCityException{
        City city = null;
        try {
            String name = lines.get(0)[0];
            String x = lines.get(1)[0];
            String y = lines.get(1)[1];
            String area = lines.get(2)[0];
            String population = lines.get(3)[0];
            String metersAboveSeaLevel = lines.get(4)[0];
            String carCode = lines.get(5)[0];
            String government = lines.get(6)[0];
            String standardOfLiving = lines.get(7)[0];
            String governor = lines.get(8)[0];

            city = new City(name, x, y, area, population, metersAboveSeaLevel, carCode, government, standardOfLiving, governor);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Unable to build city: wrong arguments");
        }
        return city;
    }
}
