/*
 * 
 */

import java.util.ArrayList;

public class Tumble extends Item {
    public Tumble(ItemSet itemSet) {
        super(itemSet);
        gold = 0.0;
    }

    @Override
    public void statPassive() {
        itemSet.onHitPhysical += 0.5 * itemSet.getStats().get(0) / 2.0;
    }

    private static final String name = "Tumble";
    @Override
    public String toString() {
        return name;
    }
}

