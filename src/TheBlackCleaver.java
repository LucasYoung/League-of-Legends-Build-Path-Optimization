/*
 * 
 */
import java.util.ArrayList;

public class TheBlackCleaver extends Item {
    public TheBlackCleaver(ItemSet itemSet) {
        super(itemSet);
        AD = 50.0;
        gold = 3150.0;
    }

    @Override
    public void statPassive() {
        itemSet.target.armor -= itemSet.target.armor * 0.15;
        itemSet.getStats().set(12, itemSet.getStats().get(12) + 20.0);
    }

    private static final String name = "The Black Cleaver";
    @Override
    public String toString() {
        return name;
    }
}

