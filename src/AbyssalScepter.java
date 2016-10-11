/*
 * 
 */

import java.util.ArrayList;

public class AbyssalScepter extends Item {
    public AbyssalScepter(ItemSet itemSet) {
        super(itemSet);
        AP = 60.0;
        gold = 2750.0;
    }

    @Override
    public void statPassive() {
        itemSet.getStats().set(6, itemSet.getStats().get(6) + 25.0);
        itemSet.getStats().set(12, itemSet.getStats().get(12) + 10.0);
    }

    private static final String name = "Abyssal Scepter";
    @Override
    public String toString() {
        return name;
    }
}

