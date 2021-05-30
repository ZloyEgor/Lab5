package commands;

import app.Application;
import classes.City;

import java.util.HashMap;

/**
 * Command that groups elements of the collection by the value of id, and displays the number of elements in each group
 */
public class GroupCountingByIdCommand extends Command{

    public GroupCountingByIdCommand(Application application) {
        super(application);
    }

    @Override
    public void execute() {
        HashMap<Long, Integer> groups = new HashMap<>();
        for(City city: application.getCollection().getCollectionVector()){
            if(!groups.containsKey(city.getId())){
                groups.put(city.getId(), 1);
            } else {
                groups.put(city.getId(), groups.get(city.getId()) + 1);
            }
        }

        if(!groups.isEmpty()) {
            System.out.println("Groups sorted by id (\"id\": quantity):");
            for (Long key : groups.keySet()) {
                System.out.println(key + ":\t" + groups.get(key));
            }
        } else {
            System.out.println("Collection is empty, nothing to show");
        }

    }

    @Override
    public String getInformationAboutCommand() {
        return "group_counting_by_id:\tgroups elements of the collection by the value of id, and displays the number of elements in each group";
    }

    @Override
    public boolean needsArgument() {
        return false;
    }

    @Override
    public String toString() {
        return "group_counting_by_id";
    }
}
