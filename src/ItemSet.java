/*
 * 
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class ItemSet {
    private ArrayList<Item> list;
    public ArrayList<Item> getList() {return list;}
    
    private ArrayList<Integer> ids;
    public ArrayList<Integer> getIds() {return ids;}
    
    private ArrayList<Double> stats;
    public ArrayList<Double> getStats() {return stats;}
    
    public Target target;
    public double onHitPhysical = 0.0;
    public double onHitMagic = 0.0;
    public double onHitTrue = 0.0;
    public double extraneousDamageMagic;
    public double extraneousDamagePhysical;
    public double attacksPerSecond;
    public double damagePerAttack;
    public double armorMultiplier;
    public double MRMultiplier;
    public int feralCount;
    public int guinsooCount;
    public String champion;

    public ArrayList<Item> convertIdsToItems(ArrayList<Integer> idInputList) {
        ArrayList<Item> output = new ArrayList<Item>();
        int i = 0;
        while (i < idInputList.size()) {
            switch (idInputList.get(i)) {
                case -7: {
                    output.add(new Fervor(this));
                    break;
                }
                case -5: {
                    output.add(new FinalHour(this));
                    break;
                }
                case 19: {
                    output.add(new EssenceReaver(this));
                    break;
                }
                case 18: {
                    output.add(new TheBlackCleaver(this));
                    break;
                }
                case 0: {
                    output.add(new HolyFervor(this));
                    break;
                }
                case 12: {
                    output.add(new InfinityEdge(this));
                    break;
                }
                case 15: {
                    output.add(new PhantomDancer(this));
                    break;
                }
                case 3: {
                    output.add(new LordDominiksRegards(this));
                    break;
                }
                case 4: {
                    output.add(new BladeOfTheRuinedKing(this));
                    break;
                }
                case 5: {
                    output.add(new YoumuusGhostblade(this));
                    break;
                }
                case 6: {
                    output.add(new IonianBoots(this));
                    break;
                }
                case 17: {
                    output.add(new BerserkersGreaves(this));
                    break;
                }
                case 20: {
                    output.add(new SorcerersShoes(this));
                    break;
                }
                case 7: {
                    output.add(new WitsEnd(this));
                    break;
                }
                case 8: {
                    output.add(new RabadonsDeathcap(this));
                    break;
                }
                case 9: {
                    output.add(new VoidStaff(this));
                    break;
                }
                case 10: {
                    output.add(new LichBane(this));
                    break;
                }
                case 11: {
                    output.add(new TrinityForce(this));
                    break;
                }
                case 1: {
                    output.add(new RighteousFury(this));
                    break;
                }
                case 14: {
                    output.add(new NashorsTooth(this));
                    break;
                }
                case 13: {
                    output.add(new GuinsoosRageblade(this));
                    break;
                }
                case 2: {
                    output.add(new Reckoning(this));
                    break;
                }
                case -1: {
                    output.add(new PiercingLight(this));
                    break;
                }
                case -2: {
                    output.add(new RelentlessPursuit(this));
                    break;
                }
                case 16: {
                    output.add(new RunaansHurricane(this));
                    break;
                }
                case -3: {
                    output.add(new SilverBolts(this));
                    break;
                }
                case -4: {
                    output.add(new Tumble(this));
                    break;
                }
                case -6: {
                    output.add(new MissileBarrage(this));
                }
            }
            ++i;
        }
        return output;
    }

    public ItemSet(ArrayList<Integer> ids, Target target, String champion) {
        this.ids = ids;
        this.target = target;
        this.champion = champion;
        this.feralCount = 0;
        this.guinsooCount = 0;
        this.stats = new ArrayList();
        this.list = this.convertIdsToItems(ids);
    }

    public ArrayList<Double> calculateStats() {
        int i = 0;
        while (i < this.list.size()) {
            double value = 0.0;
            int j = 0;
            while (j < this.stats.size()) {
                value = 0.0;
                this.stats.set(j, this.stats.get(j) + (value += this.list.get(i).getStats().get(j)));
                ++j;
            }
            ++i;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        set.addAll(this.ids);
        ArrayList<Integer> uniqueIds = new ArrayList<Integer>(set);
        Collections.sort(uniqueIds);
        ArrayList<Item> uniqueItems = this.convertIdsToItems(uniqueIds);
        int i2 = 0;
        while (i2 < uniqueItems.size()) {
            uniqueItems.get(i2).statPassive();
            ++i2;
        }
        return this.stats;
    }

    public double calculateDPS() {
        this.stats = this.calculateStats();
        if (this.champion.equals("Kayle") || this.champion.equals("Lucian")) {
            this.attacksPerSecond = 0.638 * (100.0 + this.stats.get(1)) / 100.0;
        }
        if (this.champion.equals("Vayne")) {
            this.attacksPerSecond = 0.658 * (100.0 + this.stats.get(1)) / 100.0;
        }
        if (this.champion.equals("Corki")) {
            this.attacksPerSecond = 0.625 * (100.0 + this.stats.get(1)) / 100.0;
        }
        if (this.attacksPerSecond > 2.5) {
            this.attacksPerSecond = 2.5;
        }
        this.damagePerAttack = (1.0 - this.stats.get(2) / 100.0) * this.stats.get(0) + this.stats.get(2) / 100.0 * this.stats.get(0) * (this.stats.get(3) / 100.0);
        this.armorMultiplier = 100.0 / (100.0 + this.target.armor - this.stats.get(4) - this.target.armor * this.stats.get(5) / 100.0);
        this.MRMultiplier = 100.0 / (100.0 + this.target.MR - this.stats.get(6) - this.target.MR * this.stats.get(7) / 100.0);
        double DPS = this.attacksPerSecond * ((this.damagePerAttack + this.onHitPhysical) * this.armorMultiplier + this.onHitMagic * this.MRMultiplier + this.onHitTrue) + this.extraneousDamagePhysical * this.armorMultiplier + this.extraneousDamageMagic * this.MRMultiplier;
        return DPS;
    }
}

