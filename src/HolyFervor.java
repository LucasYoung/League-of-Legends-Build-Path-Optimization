/*
 * Decompiled with CFR 0_115.
 */
public class HolyFervor extends Item {
    public HolyFervor(ItemSet itemSet) {
        super(itemSet);
    }

    @Override
    public void statPassive() {
        this.itemSet.target.armor -= this.itemSet.target.armor * 0.09;
        this.itemSet.target.MR -= this.itemSet.target.MR * 0.09;
    }

    private static final String name = "Holy Fervor";
    @Override
    public String toString() {
        return name;
    }
}

