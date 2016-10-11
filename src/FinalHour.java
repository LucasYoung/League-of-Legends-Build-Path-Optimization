/*
 * 
 */
import java.util.ArrayList;

public class FinalHour extends Item {
    public FinalHour(ItemSet itemSet) {
        super(itemSet);
        gold = 0.0;
    }

    @Override
    public void statPassive() {
        if (itemSet.getStats().get(13) >= 6.0) {
            itemSet.getStats().set(0, itemSet.getStats().get(0) + 30.0);
        }
        if (itemSet.getStats().get(13) >= 11.0) {
            itemSet.getStats().set(0, itemSet.getStats().get(0) + 50.0);
        }
        if (itemSet.getStats().get(13) >= 16.0) {
            itemSet.getStats().set(0, itemSet.getStats().get(0) + 70.0);
        }
    }

    private static final String name = "Final Hour";
    @Override
    public String toString() {
        return name;
    }
}

