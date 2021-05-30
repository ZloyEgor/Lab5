package app;

import classes.City;

/**
 * Interface-marker that allows to mark Commands which creates new Cities and those realisation in script differs from default realisation
 * @see City
 * @see CityBuilder
 */
public interface CreatingCityCommand {
    /**
     * when script is running, new city gets as argument
     * @param generatedCity - city that generated by {@link CityBuilder}
     */
    void executeInScript(City generatedCity);
}