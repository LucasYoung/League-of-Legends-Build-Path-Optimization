/*
 * 
 */
import java.util.ArrayList;

public class WitsEnd extends Item {
    public WitsEnd(ItemSet itemSet) {
        super(itemSet);
        attackSpeed = 40.0;
        gold = 2500.0;
    }

    @Override
    public void statPassive() {
        itemSet.onHitMagic += 40.0;
        itemSet.getStats().set(6, itemSet.getStats().get(6) + 0.638 * (100.0 + itemSet.getStats().get(1)) / 100.0 * 2.5 * 5.0);
    }

    private static final String name = "Wit's End";
    @Override
    public String toString() {
        return name;
    }
}

