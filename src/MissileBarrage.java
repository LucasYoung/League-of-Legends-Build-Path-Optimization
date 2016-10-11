/*
 * 
 */
import java.util.ArrayList;

public class MissileBarrage extends Item {
    public MissileBarrage(ItemSet itemSet) {
        super(itemSet);
        gold = 0.0;
    }

    @Override
    public void statPassive() {
        itemSet.extraneousDamageMagic += (160.0 + 0.3 * itemSet.getStats().get(11) + 1.0 * itemSet.getStats().get(0)) / 2.0 + (80.0 + 0.15 * itemSet.getStats().get(11) + 0.5 * itemSet.getStats().get(0)) / 6.0;
        itemSet.extraneousDamagePhysical -= (itemSet.getStats().get(0) + itemSet.getStats().get(2) * itemSet.getStats().get(0) + itemSet.onHitPhysical) / 2.0;
        itemSet.extraneousDamageMagic -= itemSet.onHitMagic / 2.0;
    }

    private static final String name = "Missile Barrage";
    @Override
    public String toString() {
        return name;
    }
}

