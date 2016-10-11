/*
 * 
 */
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class OptimizeDPS {
    public static void main(String[] args) {
        String champion = "Kayle";
        double minLifeSteal = 0.0;
        double minMS = 45.0;
        double minCDR = 0.0;
        if (champion.equals("Kayle")) {
            minCDR = 40.0;
        }
        int level = 18;
        int outputQuantity = 10;
        double attacksPerSecond = 0.0;
        double damagePerAttack = 0.0;
        double armorMultiplier = 0.0;
        double MRMultiplier = 0.0;
        double onHitPhysical = 0.0;
        double onHitMagic = 0.0;
        int targetCounter = 0;
        while (targetCounter < 10) {
            ArrayList<Double> maxDPS = new ArrayList<Double>();
            maxDPS.add(9.9999999999E10);
            int i = 0;
            while (i < outputQuantity) {
                maxDPS.add(0.0);
                ++i;
            }
            ArrayList<ArrayList<Integer>> maxDPSSet = new ArrayList<ArrayList<Integer>>();
            int i2 = 0;
            while (i2 < outputQuantity + 1) {
                maxDPSSet.add(new ArrayList());
                ++i2;
            }
            System.out.println("The top 10 greatest DPS/gold ratios for a target with " + (40 + targetCounter * 20) + " armor and " + 40 + " magic resistance:");
            System.out.println();
            i2 = 3;
            while (i2 <= 20) {
                int j = i2;
                while (j <= 20) {
                    int k = j;
                    while (k <= 20) {
                        int l = k;
                        while (l <= 20) {
                            int m = l;
                            while (m <= 20) {
                                ArrayList<Integer> list = new ArrayList<Integer>();
                                list.add(i2);
                                list.add(j);
                                list.add(k);
                                list.add(l);
                                list.add(m);
                                if (champion.equals("Kayle")) {
                                    list.add(1);
                                    list.add(0);
                                    list.add(2);
                                    list.add(-7);
                                }
                                if (champion.equals("Lucian")) {
                                    list.add(-1);
                                    list.add(-2);
                                    list.add(-7);
                                }
                                if (champion.equals("Vayne")) {
                                    list.add(-3);
                                    list.add(-4);
                                    list.add(-5);
                                    list.add(-7);
                                }
                                if (champion.equals("Corki")) {
                                    list.add(-6);
                                    list.add(11);
                                }
                                ItemSet itemSet = new ItemSet(list, new Target(40 + targetCounter * 20, 80.0, 2000.0, 500.0), champion);
                                if (champion.equals("Kayle")) {
                                    itemSet.getStats().add(51.004 + 2.8 * (double)(level - 1));
                                }
                                if (champion.equals("Lucian")) {
                                    itemSet.getStats().add(57.46 + 2.41 * (double)(level - 1));
                                }
                                if (champion.equals("Vayne")) {
                                    itemSet.getStats().add(92.5);
                                }
                                if (champion.equals("Corki")) {
                                    itemSet.getStats().add(107.5);
                                }
                                if (champion.equals("Kayle")) {
                                    itemSet.getStats().add(2.2 * (double)(level - 1) + 4.0 + 24.28);
                                }
                                if (champion.equals("Lucian")) {
                                    itemSet.getStats().add(3.3 * (double)(level - 1) + 4.0 + 19.23);
                                }
                                if (champion.equals("Vayne")) {
                                    itemSet.getStats().add((double)(4 * (level - 1) + 4) + 19.23);
                                }
                                if (champion.equals("Corki")) {
                                    itemSet.getStats().add(2.3 * (double)(level - 1) + 4.0 + 19.23);
                                }
                                itemSet.getStats().add(0.0);
                                itemSet.getStats().add(200.0);
                                itemSet.getStats().add(0.0);
                                if (champion.equals("Lucian") || champion.equals("Vayne")) {
                                    itemSet.getStats().add(0.0);
                                }
                                itemSet.getStats().add(0.0);
                                if (champion.equals("Kayle")) {
                                    itemSet.getStats().add(7.0);
                                }
                                if (champion.equals("Corki")) {
                                    itemSet.getStats().add(0.0);
                                }
                                itemSet.getStats().add(0.0);
                                itemSet.getStats().add(0.0);
                                itemSet.getStats().add(0.0);
                                itemSet.getStats().add(0.0);
                                itemSet.getStats().add(0.0);
                                if (champion.equals("Kayle")) {
                                    itemSet.getStats().add(20.0);
                                } else {
                                    itemSet.getStats().add(0.0);
                                }
                                itemSet.getStats().add(Double.valueOf(level));
                                double DPS = itemSet.calculateDPS();
                                DPS /= itemSet.getStats().get(8);
                                int x = 1;
                                while (x < maxDPS.size()) {
                                    if (DPS > (Double)maxDPS.get(x) && DPS < (Double)maxDPS.get(x - 1) && itemSet.getStats().get(9) >= minLifeSteal && itemSet.getStats().get(10) >= minMS && itemSet.feralCount <= 2 && itemSet.guinsooCount <= 2 && itemSet.getStats().get(12) >= minCDR) {
                                        int y = maxDPS.size() - 1;
                                        while (y > x) {
                                            maxDPS.set(y, (Double)maxDPS.get(y - 1));
                                            maxDPSSet.set(y, (ArrayList)maxDPSSet.get(y - 1));
                                            --y;
                                        }
                                        maxDPS.set(x, DPS);
                                        maxDPSSet.set(x, itemSet.getIds());
                                    }
                                    ++x;
                                }
                                ++m;
                            }
                            ++l;
                        }
                        ++k;
                    }
                    ++j;
                }
                ++i2;
            }
            i2 = 1;
            while (i2 < maxDPSSet.size()) {
                System.out.print(String.valueOf(i2) + ". " + new ItemSet((ArrayList)maxDPSSet.get(i2), new Target(1.0, 1.0, 1.0, 1.0), champion).convertIdsToItems((ArrayList)maxDPSSet.get(i2)));
                System.out.println(" " + new DecimalFormat("#.#####").format(maxDPS.get(i2)) + " DPS per 1 gold");
                ++i2;
            }
            System.out.println("\n");
            ++targetCounter;
        }
    }
}

