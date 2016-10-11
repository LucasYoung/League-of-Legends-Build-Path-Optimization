/*
 * 
 */

import java.util.ArrayList;

public class IonianBoots extends Item {
    public IonianBoots(ItemSet itemSet) {
        super(itemSet);
        gold = 900.0;
        MS = 45.0;
        ++itemSet.feralCount;
    }

    @Override
    public void statPassive() {
        itemSet.getStats().set(12, itemSet.getStats().get(12) + 10.0);
    }

    private static final String name = "Ionian Boots of Lucidity";
    @Override
    public String toString() {
        return name;
    }
}

