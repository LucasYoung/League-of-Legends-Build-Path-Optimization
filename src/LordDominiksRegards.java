/*
 * 
 */

import java.util.ArrayList;

public class LordDominiksRegards extends Item {
    public LordDominiksRegards(ItemSet itemSet) {
        super(itemSet);
        AD = 40.0;
        gold = 2700.0;
    }

    @Override
    public void statPassive() {
        itemSet.getStats().set(5, itemSet.getStats().get(5) + 45.0);
    }

    private static final String name = "Lord Dominik's Regards";
    @Override
    public String toString() {
        return name;
    }
}

