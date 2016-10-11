/*
 * 
 */
import java.util.ArrayList;

public class Reckoning extends Item {
    public Reckoning(ItemSet itemSet) {
        super(itemSet);
        gold = 0.0;
    }

    @Override
    public void statPassive() {
        itemSet.extraneousDamageMagic += (260.0 + 0.6 * itemSet.getStats().get(11) + 1.0 * itemSet.getStats().get(0)) / 6.0;
    }

    private static final String name = "Reckoning";
    @Override
    public String toString() {
        return name;
    }
}

