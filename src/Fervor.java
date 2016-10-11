/*
 * 
 */
import java.util.ArrayList;

public class Fervor extends Item {
    public Fervor(ItemSet itemSet) {
        super(itemSet);
        gold = 0.0;
    }

    @Override
    public void statPassive() {
        itemSet.onHitPhysical += (0.13 + 0.77 * itemSet.getStats().get(13)) * 6.0;
    }

    private static final String name = "Fervor";
    @Override
    public String toString() {
        return name;
    }
}

