/*
 * 
 */
import java.util.ArrayList;

public class LichBane extends Item {
    public LichBane(ItemSet itemSet) {
        super(itemSet);
        AP = 80.0;
        gold = 3200.0;
    }

    @Override
    public void statPassive() {
        itemSet.extraneousDamageMagic += 0.5 * itemSet.getStats().get(11) / 2.5;
        itemSet.extraneousDamagePhysical -= 10.4;
        itemSet.getStats().set(12, itemSet.getStats().get(12) + 10.0);
    }

    private static final String name = "Lich Bane";
    @Override
    public String toString() {
        return name;
    }
}

