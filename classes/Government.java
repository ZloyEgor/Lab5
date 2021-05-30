package classes;

/**
 * Enum that contains types of government
 */

public enum Government {

    CORPORATOCRACY("corporatocracy"),
    OLIGARCHY("oligarchy"),
    ETHNOCRACY("etnocracy");

    /**
     * @param description String representation of government type
     */
    private final String description;

    Government(String description){
        this.description = description;
    }


    public String getDescription(){
        return description;
    }
}



