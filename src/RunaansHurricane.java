/*
 * 
 */
import java.util.ArrayList;

public class RunaansHurricane extends Item {
    public RunaansHurricane(ItemSet itemSet) {
        super(itemSet);
        attackSpeed = 40.0;
        critChance = 30.0;
        gold = 2600.0;
    }

    @Override
    public void statPassive() {
        itemSet.onHitPhysical += 15.0;
        itemSet.onHitPhysical = itemSet.onHitPhysical * 2.0 + 1.0 * (0.25 * itemSet.getStats().get(0)) + itemSet.getStats().get(0) * critChance * critDamage;
        itemSet.onHitMagic *= 2.0;
    }

    private static final String name = "Runaan's Hurricane";
    @Override
    public String toString() {
        return name;
    }
}

