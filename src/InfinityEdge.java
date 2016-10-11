/*
 * 
 */

import java.util.ArrayList;

public class InfinityEdge extends Item {
    public InfinityEdge(ItemSet itemSet) {
        super(itemSet);
        AD = 65.0;
        critChance = 20.0;
        gold = 3600.0;
    }

    @Override
    public void statPassive() {
        itemSet.getStats().set(3, itemSet.getStats().get(3) + 50.0);
    }

    private static final String name = "Infinity Edge";
    @Override
    public String toString() {
        return name;
    }
}

