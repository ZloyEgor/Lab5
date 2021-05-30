package classes;

import exceptions.InvalidFieldException;
import exceptions.UnableToCreateCityException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 * Class of City
 */
public class City implements Comparable<City>{

    /**
     * @param id unique field of each City, generates automatically, must be > 0
     * @param name name can't be null and empty
     * @param coordinates field can't be null
     * @param creationDate field can't be null, generates automatically
     * @param area field value must be > 0
     * @param population field value must be > 0
     * @param metersAboutSeaLevel
     * @param carCode field value must be > 0, max value: 1000, can't be null
     * @param government field can't be null
     * @param standardOfLiving field can't be null
     * @param governor field can't be null
     * @param formatter represents creationDate in convenient way
     */
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int area; //Значение поля должно быть больше 0
    private long population; //Значение поля должно быть больше 0
    private final Float metersAboveSeaLevel;
    private Integer carCode; //Значение поля должно быть больше 0, Максимальное значение поля: 1000, Поле не может быть null
    private Government government; //Поле не может быть null
    private StandardOfLiving standardOfLiving; //Поле не может быть null
    private Human governor; //Поле может быть null

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    /**
     * @exception UnableToCreateCityException be thrown if some of arguments will be invalid
     */
    public City(String name, Coordinates coordinates, int area, long population, Float metersAboveSeaLevel, Integer carCode, Government government, StandardOfLiving standardOfLiving, Human governor){
        try{
            setName(name);
            setCoordinates(coordinates);
            setArea(area);
            setPopulation(population);
            this.metersAboveSeaLevel = metersAboveSeaLevel;
            setCarCode(carCode);
            setGovernment(government);
            setStandardOfLiving(standardOfLiving);
            setGovernor(governor);
            generateId();
            setCreationDate();
        }
        catch (InvalidFieldException e){
            throw new UnableToCreateCityException();
        }
    }

    /**
     * @exception UnableToCreateCityException be thrown if some of arguments will be invalid
     */
    public City(String id, String name, String x, String y, String timeCreated, String area, String population, String metersAboveSeaLevel, String carCode, String government, String standardOfLiving, String governorAge){
        try{
            this.id = Long.parseLong(id);
            setName(name);
            coordinates = new Coordinates(Long.parseLong(x), Double.parseDouble(y));
            setCoordinates(coordinates);
            creationDate = LocalDateTime.parse(timeCreated, formatter);
            setArea(Integer.parseInt(area));
            setPopulation(Long.parseLong(population));
            this.metersAboveSeaLevel = Float.parseFloat(metersAboveSeaLevel);
            setCarCode(Integer.parseInt(carCode));
            setGovernment(Government.valueOf(government.toUpperCase()));
            setStandardOfLiving(StandardOfLiving.valueOf(standardOfLiving.toUpperCase()));
            if(governorAge.trim().isEmpty()){
                governor = null;
            }else{
                governor = new Human(Long.parseLong(governorAge));
            }
        }
        catch(InvalidFieldException e){
            throw new UnableToCreateCityException();
        }
        catch(NumberFormatException e){
            throw new UnableToCreateCityException();
        }
        catch(DateTimeParseException e){
            throw new UnableToCreateCityException();
        }
        catch (IllegalArgumentException e){
            throw new UnableToCreateCityException();
        }
    }

    /**
     * @exception UnableToCreateCityException be thrown if some of arguments will be invalid
     */
    public City(String name, String x, String y, String area, String population, String metersAboveSeaLevel, String carCode, String government, String standardOfLiving, String governorAge){
        try{
            setName(name);
            coordinates = new Coordinates(Long.parseLong(x), Double.parseDouble(y));
            setCoordinates(coordinates);
            setArea(Integer.parseInt(area));
            setPopulation(Long.parseLong(population));
            this.metersAboveSeaLevel = Float.parseFloat(metersAboveSeaLevel);
            setCarCode(Integer.parseInt(carCode));
            setGovernment(Government.valueOf(government.toUpperCase()));
            setStandardOfLiving(StandardOfLiving.valueOf(standardOfLiving.toUpperCase()));
            if(governorAge.trim().isEmpty()){
                governor = null;
            }else{
                governor = new Human(Long.parseLong(governorAge));
            }
            generateId();
            setCreationDate();
        }


        catch(InvalidFieldException e){
            System.out.println(e.getMessage());
            throw new UnableToCreateCityException();
        }
        catch(NumberFormatException e){
            System.out.println("Number format exception");
            System.out.println(e.getMessage());
            throw new UnableToCreateCityException();
        }
        catch(DateTimeParseException e){
            System.out.println(e.getMessage());
            throw new UnableToCreateCityException();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw new UnableToCreateCityException();
        }
    }


    public void setCreationDate(){
        creationDate = LocalDateTime.now();
    }

    public void generateId() {
        id = Math.abs(name.hashCode()*carCode.hashCode()) % 1000;
    }

    public void setName(String name) {
        if(name != null && !name.trim().isEmpty())
            this.name = name;
        else
            throw new InvalidFieldException("Field \"name\" typed incorrectly!");
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setArea(int area) {
        if(area > 0)
            this.area = area;
        else
            throw new InvalidFieldException("Field \"area\" must be above zero!");
    }

    public void setPopulation(long population) {
        if(population > 0)
            this.population = population;
        else
            throw new InvalidFieldException("Field \"population\" must be above zero!");
    }

    public void setCarCode(Integer carCode) {
        if(carCode > 0 && carCode <= 1000 && carCode != null)
            this.carCode = carCode;
        else
            throw new InvalidFieldException("Field \"carCode\" is invalid!");
    }

    public void setGovernment(Government government) {
        if (government != null)
            this.government = government;
        else
            throw new InvalidFieldException("Field \"government\" can't be null");
    }

    public void setStandardOfLiving(StandardOfLiving standardOfLiving) {
        if (standardOfLiving != null)
            this.standardOfLiving = standardOfLiving;
        else
            throw new InvalidFieldException("Field \"standardOfLiving can't be null\"");
    }

    public void setGovernor(Human governor) {
        this.governor = governor;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getCreationDate() {
        return formatter.format(creationDate);
    }

    public int getArea() {
        return area;
    }

    public long getPopulation() {
        return population;
    }

    public Float getMetersAboveSeaLevel() {
        return metersAboveSeaLevel;
    }

    public Integer getCarCode() {
        return carCode;
    }

    public Government getGovernment() {
        return government;
    }

    public StandardOfLiving getStandardOfLiving() {
        return standardOfLiving;
    }

    public Human getGovernor() {
        return governor;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int compareTo(City o) {
        return (int)(this.id - o.id);
    }

    @Override
    public String toString() {
        return  "City:" +
                "\nid:\t\t\t\t\t\t" + id +
                "\nname:\t\t\t\t\t" + name +
                "\n" + coordinates.toString() +
                "\ncreationDate:\t\t\t" + formatter.format(creationDate) +
                "\narea:\t\t\t\t\t" + area +
                "\npopulation:\t\t\t\t" + population +
                "\nmetersAboveSeaLevel:\t" + metersAboveSeaLevel +
                "\ncarCode:\t\t\t\t" + carCode +
                "\ngovernment:\t\t\t\t" + government.getDescription() +
                "\nstandardOfLiving:\t\t" + standardOfLiving.getDescription() +
                "\nGovernor:\n" + (governor == null? "absent" : governor.toString());
    }
}
