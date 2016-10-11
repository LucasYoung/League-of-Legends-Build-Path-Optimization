/*
 * Decompiled with CFR 0_115.
 */
public class BerserkersGreaves
extends Item {
    public BerserkersGreaves(ItemSet itemSet) {
        super(itemSet);
        this.attackSpeed = 35.0;
        this.gold = 1100.0;
        this.MS = 45.0;
        ++itemSet.feralCount;
    }

    @Override
    public void statPassive() {
    }

    private static final String name = "Berserker Greaves";
    @Override
    public String toString() {
        return name;
    }
}

