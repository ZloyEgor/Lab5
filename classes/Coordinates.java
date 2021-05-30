package classes;

import exceptions.InvalidFieldException;

/**
 * Class of coordinates of @class City
 */
public class Coordinates {

    /**
     * @param x - x coordinate, can't be null
     * @param y - y coordinate
     */
    private Long x; //Поле не может быть null
    private double y;

    public Coordinates(Long x, double y){
        setX(x);
        this.y = y;
    }


    public void setX(Long x) {
        if (x != null)
            this.x = x;
        else
            throw new InvalidFieldException("Поле Long не может быть null!");
    }

    public Long getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return  "Coordinates:" +
                "\nx:\t\t\t\t\t\t" + x +
                "\ny:\t\t\t\t\t\t" + y;
    }
}