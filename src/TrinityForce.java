/*
 * 
 */

import java.util.ArrayList;

public class TrinityForce extends Item {
    public TrinityForce(ItemSet itemSet) {
        super(itemSet);
        AD = 25.0;
        attackSpeed = 40.0;
        gold = 3733.0;
    }

    @Override
    public void statPassive() {
        itemSet.extraneousDamagePhysical += 24.75;
        itemSet.getStats().set(12, itemSet.getStats().get(12) + 20.0);
    }

    private static final String name = "Trinity Force";
    @Override
    public String toString() {
        return name;
    }
}

