/*
 * 
 */
import java.util.ArrayList;

public class EssenceReaver extends Item {
    public EssenceReaver(ItemSet itemSet) {
        super(itemSet);
        AD = 65.0;
        critChance = 20.0;
        gold = 3600.0;
    }

    @Override
    public void statPassive() {
        itemSet.getStats().set(12, itemSet.getStats().get(12) + 10.0);
        if (itemSet.getStats().get(2) >= 50.0) {
            itemSet.getStats().set(12, itemSet.getStats().get(12) + 20.0);
        } else if (itemSet.getStats().get(2) >= 40.0) {
            itemSet.getStats().set(12, itemSet.getStats().get(12) + 10.0);
        } else if (itemSet.getStats().get(2) >= 10.0) {
            itemSet.getStats().set(12, itemSet.getStats().get(12) + 3.0);
        }
    }

    private static final String name = "Essence Reaver";
    @Override
    public String toString() {
        return name;
    }
}

