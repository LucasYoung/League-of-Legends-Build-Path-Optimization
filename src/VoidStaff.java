/*
 *
 */
import java.util.ArrayList;

public class VoidStaff extends Item {
    public VoidStaff(ItemSet itemSet) {
        super(itemSet);
        AP = 80.0;
        gold = 2650.0;
    }

    @Override
    public void statPassive() {
        itemSet.getStats().set(7, itemSet.getStats().get(7) + 35.0);
    }

    private static final String name = "Void Staff";
    @Override
    public String toString() {
        return name;
    }
}

