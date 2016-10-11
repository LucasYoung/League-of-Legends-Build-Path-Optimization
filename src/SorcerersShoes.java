/*
 * 
 */
import java.util.ArrayList;

public class SorcerersShoes extends Item {
    public SorcerersShoes(ItemSet itemSet) {
        super(itemSet);
        gold = 1100.0;
        MS = 45.0;
        ++itemSet.feralCount;
    }

    @Override
    public void statPassive() {
        itemSet.getStats().set(6, itemSet.getStats().get(6) + 15.0);
    }

    private static final String name = "Sorcerer's Shoes";
    @Override
    public String toString() {
        return name;
    }
}

