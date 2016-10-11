/*
 * 
 */
import java.util.ArrayList;

public class RelentlessPursuit extends Item {
    public RelentlessPursuit(ItemSet itemSet) {
        super(itemSet);
        gold = 0.0;
    }

    @Override
    public void statPassive() {
        double cooldown = 14.0;
        cooldown *= (1.0 - itemSet.getStats().get(12)) / 100.0;
        cooldown -= 4.0;
        itemSet.extraneousDamagePhysical += (0.6 * itemSet.getStats().get(0) + itemSet.getStats().get(2) / 100.0 * itemSet.getStats().get(0) * 0.5 + itemSet.onHitPhysical) / (5.0 * (1.0 - itemSet.getStats().get(12) / 100.0));
        itemSet.extraneousDamageMagic += itemSet.onHitMagic / (5.0 * (1.0 - itemSet.getStats().get(12) / 100.0));
    }

    private static final String name = "Relentless Pursuit";
    @Override
    public String toString() {
        return name;
    }
}

