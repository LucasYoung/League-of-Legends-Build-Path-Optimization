/*
 * Decompiled with CFR 0_115.
 */
public class GuinsoosRageblade extends Item {
    public GuinsoosRageblade(ItemSet itemSet) {
        super(itemSet);
        this.AD = 35.0;
        this.AP = 50.0;
        this.attackSpeed = 48.0;
        this.AD = 53.0;
        this.AP = 74.0;
        ++itemSet.guinsooCount;
        this.gold = 3600.0;
    }

    @Override
    public void statPassive() {
        this.itemSet.onHitMagic += 15.0;
        this.itemSet.onHitMagic *= 1.5;
        this.itemSet.onHitPhysical *= 1.5;
    }

    private static final String name = "Guinsoo's Rageblade";
    @Override
    public String toString() {
        return name;
    }
}

