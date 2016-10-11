/*
 * 
 */
import java.util.ArrayList;

public class RighteousFury
extends Item {
    public RighteousFury(ItemSet itemSet) {
        super(itemSet);
        gold = 0.0;
    }

    @Override
    public void statPassive() {
        itemSet.onHitMagic += 0.3 * itemSet.getStats().get(11) + 60.0;
    }

    private static final String name = "Righteous Fury";
    @Override
    public String toString() {
        return name;
    }
}

