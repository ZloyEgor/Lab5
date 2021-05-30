package classes;

import exceptions.InvalidFieldException;

/**
 * Class of human
 */
public class Human {

    /**
     * @param age age of human
     */
    private long age; //Значение поля должно быть больше 0

    public Human(long age){
        setAge(age);
    }

    /**
     * @brief setter of age, age must be greater than zero
     * @param age - value that will be set as age of human
     * @exception InvalidFieldException be thrown if age <= 0
     */
    public void setAge(long age) {
        if (age > 0)
            this.age = age;
        else
            throw new InvalidFieldException("Field \"age\" must be above zero!");
    }

    public long getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "age:\t\t\t\t\t" + age;
    }
}
