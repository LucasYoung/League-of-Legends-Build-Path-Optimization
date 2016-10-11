/*
 * 
 */
import java.util.ArrayList;

public class PiercingLight extends Item {
    public PiercingLight(ItemSet itemSet) {
        super(itemSet);
        gold = 0.0;
    }

    @Override
    public void statPassive() {
        itemSet.extraneousDamagePhysical += (200.0 + 1.0 * itemSet.getStats().get(0)) / (5.0 * (1.0 - itemSet.getStats().get(12) / 100.0));
        itemSet.extraneousDamagePhysical += (0.6 * itemSet.getStats().get(0) + itemSet.getStats().get(2) / 100.0 * itemSet.getStats().get(0) * 0.5 + itemSet.onHitPhysical) / (5.0 * (1.0 - itemSet.getStats().get(12) / 100.0));
        itemSet.extraneousDamageMagic += itemSet.onHitMagic / (5.0 * (1.0 - itemSet.getStats().get(12) / 100.0));
    }

    private static final String name = "Piercing Light";
    @Override
    public String toString() {
        return name;
    }
}

