/*
 *
 */
import java.util.ArrayList;

public class SilverBolts extends Item {
    public SilverBolts(ItemSet itemSet) {
        super(itemSet);
        gold = 0.0;
    }

    @Override
    public void statPassive() {
        itemSet.onHitTrue = itemSet.getStats().get(13) >= 13.0 ? (itemSet.guinsooCount > 0 ? (itemSet.onHitTrue += itemSet.target.maxHealth * 0.12 / 2.0) : (itemSet.onHitTrue += itemSet.target.maxHealth * 0.12 / 3.0)) : (itemSet.guinsooCount > 0 ? (itemSet.onHitTrue += itemSet.target.maxHealth * 0.06 / 2.0) : (itemSet.onHitTrue += itemSet.target.maxHealth * 0.06 / 3.0));
    }

    private static final String name = "Silver Bolts";
    @Override
    public String toString() {
        return name;
    }
}

