/*
 * 
 */
import java.util.ArrayList;

public class BladeOfTheRuinedKing extends Item {
    public BladeOfTheRuinedKing(ItemSet itemSet) {
        super(itemSet);
        AD = 25.0;
        attackSpeed = 40.0;
        gold = 3400.0;
    }

    @Override
    public void statPassive() {
        itemSet.onHitPhysical = 0.06 * itemSet.target.currentHealth;
        itemSet.getStats().set(9, itemSet.getStats().get(9) + 10.0);
    }

    private static final String name = "Blade of the Ruined King";
    @Override
    public String toString() {
        return name;
    }
}

