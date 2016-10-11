/*
 * 
 */
import java.util.ArrayList;

public class NashorsTooth extends Item {
    public NashorsTooth(ItemSet itemSet) {
        super(itemSet);
        attackSpeed = 50.0;
        AP = 80.0;
        gold = 3000.0;
    }

    @Override
    public void statPassive() {
        itemSet.onHitMagic += 0.15 * itemSet.getStats().get(11) + 15.0;
        itemSet.getStats().set(12, itemSet.getStats().get(12) + 20.0);
    }

    private static final String name = "Nashor's Tooth";
    @Override
    public String toString() {
        return name;
    }
}

