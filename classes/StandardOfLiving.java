package classes;

/**
 * Enum that contains standards of living
 */
public enum StandardOfLiving {
    ULTRA_HIGH("ultra_high",5),
    VERY_HIGH("very_high",4),
    LOW("low",3),
    ULTRA_LOW("ultra_low", 2),
    NIGHTMARE("nightmare", 1);

    /**
     * @param description String representation of standard of living
     * @param level integer which represents quality of living
     */
    private final String description;
    private final int level;

    StandardOfLiving(String description, int level){
        this.description = description;
        this.level = level;
    }

    public String getDescription(){
        return description;
    }

    public int getLevel(){
        return level;
    }
}
