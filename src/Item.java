/*
 * 
 */

import java.util.ArrayList;

public abstract class Item {
    protected double AD;
    protected double attackSpeed;
    protected double critChance;
    protected double critDamage;
    protected double flatArPen;
    protected double percentArPen;
    protected double flatMagicPen;
    protected double percentMagicPen;
    protected double gold;
    protected double lifeSteal;
    protected double MS;
    protected double AP;
    protected double CDR;
    protected ItemSet itemSet; //A reference to the ItemSet that this Item is part of

    public Item(ItemSet itemSet) {
        this.itemSet = itemSet;
    }

    public ArrayList<Double> getStats() {
        ArrayList<Double> stats = new ArrayList<Double>();
        stats.add(AD);
        stats.add(attackSpeed);
        stats.add(critChance);
        stats.add(critDamage);
        stats.add(flatArPen);
        stats.add(percentArPen);
        stats.add(flatMagicPen);
        stats.add(percentMagicPen);
        stats.add(gold);
        stats.add(lifeSteal);
        stats.add(MS);
        stats.add(AP);
        stats.add(CDR);
        stats.add(0.0);
        return stats;
    }

    public void statPassive() {
    }

    private static final String name = "Invalid Item (Abstract Class)";
    @Override
    public String toString() {
        return name;
    }
}

