/*
 * 
 */
import java.util.ArrayList;

public class RabadonsDeathcap extends Item {
    public RabadonsDeathcap(ItemSet itemSet) {
        super(itemSet);
        AP = 120.0;
        gold = 3800.0;
    }

    @Override
    public void statPassive() {
        itemSet.getStats().set(11, itemSet.getStats().get(11) * 1.35);
    }

    private static final String name = "Rabadon's Deathcap";
    @Override
    public String toString() {
        return name;
    }
}

