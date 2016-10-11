/*
 * Decompiled with CFR 0_115.
 */
public class PhantomDancer
extends Item {
    public PhantomDancer(ItemSet itemSet) {
        super(itemSet);
        this.attackSpeed = 45.0;
        this.critChance = 30.0;
        this.gold = 2550.0;
    }

    private static final String name = "Phantom Dancer";
    @Override
    public String toString() {
        return name;
    }
}

