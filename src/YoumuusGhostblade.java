/*
 * 
 */

import java.util.ArrayList;

public class YoumuusGhostblade extends Item {
    public YoumuusGhostblade(ItemSet itemSet) {
        super(itemSet);
        AD = 65.0;
        attackSpeed = 20.0;
        gold = 3200.0;
    }

    @Override
    public void statPassive() {
        itemSet.getStats().set(4, itemSet.getStats().get(4) + 20.0);
        itemSet.getStats().set(12, itemSet.getStats().get(12) + 10.0);
    }

    private static final String name = "Youmuu's Ghostblade";
    @Override
    public String toString() {
        return name;
    }
}

