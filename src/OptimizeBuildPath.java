/*
 * 
 */

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;

public class OptimizeBuildPath {
	
	//Constants that change how the program runs but are too abstruse to be decided by the user
    static final String champion = "Lucian";
    static final double minLifeSteal = 0.0;
    static final int outputQuantity = 18;
    
    //Default values in text boxes
    static int armor = 40;
    static int mr = 40;
	
    /*
     * This method 
     * 1. Creates a new ItemSet that consists of the current item set with an additional temporary item
     * 2. Calculates the DPS/gold ratio of the ItemSet using itemSet.calculateDPS()
     * 3. Stores the calculation in an array
     * 4. Stores the itemSet's IDs in a two-dimensional array that is parallel to the array in (3)
     * 5. Sorts both arrays by greatest DPS/gold ratio
     * 6. Repeats 1-6 for a different item
     */
    public static void addItem(ArrayList<ArrayList<Integer>> maxDPSSet, ArrayList<Double> maxDPS, String champion, int armor, int mr, int level, double minMS, double minLifeSteal, double minCDR, ArrayList<Integer> bannedItems) {
        ArrayList originalDPSSet = (ArrayList)maxDPSSet.get(1).clone();
        int i = 3;
        while (i <= 20) { //Iteration through item IDs
            if (!bannedItems.contains(i)) { //This if statement skips banned ID numbers (See README for explanation of banned IDs)
            	
            	//1. Creating a new ItemSet with the additional temporary item
                ArrayList list = (ArrayList)originalDPSSet.clone();
                list.add(i);
                ItemSet itemSet = new ItemSet(list, new Target(armor, mr, 2000.0, 1000.0), champion);
                
                //Adding stats to the itemSet
                switch(champion){
                	case "Kayle":
	                    itemSet.getStats().add(51.004 + 2.8 * (double)(level - 1));
	                    itemSet.getStats().add(2.2 * (double)(level - 1) + 4.0 + 24.28);
	                    break;
                	case "Lucian":
	                    itemSet.getStats().add(57.46 + 2.41 * (double)(level - 1));
	                    itemSet.getStats().add(3.3 * (double)(level - 1) + 4.0 + 19.23);
	                    break;
                	case "Vayne":
	                    itemSet.getStats().add(92.5);
	                    itemSet.getStats().add((double)(4 * (level - 1) + 4) + 19.23);
	                    break;
                	case "Corki":
	                    itemSet.getStats().add(107.5);
	                    itemSet.getStats().add(2.3 * (double)(level - 1) + 4.0 + 19.23);
	                    break;
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
                itemSet.getStats().add((double)level);
                
                double DPS = itemSet.calculateDPS(); //2. Calculates the DPS of the ItemSet using itemSet.calculateDPS()
                
                DPS /= itemSet.getStats().get(8); //3. Changes DPS to DPS/gold ratio
                //5. Sorts both arrays by greatest DPS/gold ratio
                int x = 1;
                while (x < maxDPS.size()) {
                    if (DPS > maxDPS.get(x) && DPS < maxDPS.get(x - 1) && itemSet.getStats().get(9) >= minLifeSteal && itemSet.getStats().get(10) >= minMS && itemSet.feralCount <= 2 && itemSet.guinsooCount <= 2 && itemSet.getStats().get(12) >= minCDR) {
                    	//This if statement checks if the itemSet meets ItemSet Standards (see standards in README)
                        int y = maxDPS.size() - 1;
                        while (y > x) {
                            maxDPS.set(y, maxDPS.get(y - 1)); 
                            maxDPSSet.set(y, maxDPSSet.get(y - 1));
                            --y;
                        }
                        maxDPS.set(x, DPS);
                        maxDPSSet.set(x, itemSet.getIds()); //4. Stores the itemSet's IDs in a two-dimensional array that is parallel to the array in (3)
                    }
                    ++x;
                }
            }
            ++i;
        }
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, champion+" Optimal Build Calculator based on maximizing DPS/gold ratio by Lucas Young\nChoose which items you prefer using the drop-down menus.\nThe items that yield the highest DPS/gold ratio will be towards the top.\nThese items can be substituted for lower DPS/gold ratio items if you believe that they offer enough utility for the trade-off to be worthwile.\nArmor and magic resistance are adjusted throughout the calculations as the target may change throughout the duration of the game.\nRunes, masteries, champion abilities, champion level, and item passives are accounted for.");
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
        System.out.println();
        ArrayList<Integer> bannedItems = new ArrayList<Integer>();
        int setIndex = 1;
        while (setIndex < maxDPSSet.size()) {
            if (champion.equals("Kayle")) {
                ((ArrayList)maxDPSSet.get(setIndex)).add(1);
                ((ArrayList)maxDPSSet.get(setIndex)).add(0);
                ((ArrayList)maxDPSSet.get(setIndex)).add(2);
                ((ArrayList)maxDPSSet.get(setIndex)).add(-7);
            }
            if (champion.equals("Lucian")) {
                ((ArrayList)maxDPSSet.get(setIndex)).add(-1);
                ((ArrayList)maxDPSSet.get(setIndex)).add(-2);
                ((ArrayList)maxDPSSet.get(setIndex)).add(-7);
                bannedItems.add(16);
                bannedItems.add(13);
            }
            if (champion.equals("Vayne")) {
                ((ArrayList)maxDPSSet.get(setIndex)).add(-3);
                ((ArrayList)maxDPSSet.get(setIndex)).add(-4);
                ((ArrayList)maxDPSSet.get(setIndex)).add(-5);
                ((ArrayList)maxDPSSet.get(setIndex)).add(-7);
                bannedItems.add(16);
            }
            if (champion.equals("Corki")) {
                ((ArrayList)maxDPSSet.get(setIndex)).add(-6);
                ((ArrayList)maxDPSSet.get(setIndex)).add(11);
            }
            ++setIndex;
        }
        int level = 9;
        double minMS = 0.0;
        armor = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the armor of your target(s)?", "40"));
        mr = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the magic resistance of your target(s)?", "40"));
        double minCDR = 0.0;
        ArrayList<Integer> ban = new ArrayList<Integer>();
        ban.add(6);
        ban.add(17);
        ban.add(20);
        ban.addAll(bannedItems);
        OptimizeBuildPath.addItem(maxDPSSet, maxDPS, champion, armor, mr, level, minMS, minLifeSteal, minCDR, ban);
        int i3 = 1;
        while (i3 < maxDPSSet.size()) {
            if (maxDPSSet.get(i3).size() < maxDPSSet.get(1).size()) {
                maxDPSSet.set(i3, maxDPSSet.get(1));
            }
            ++i3;
        }
        Object[] options = new String[maxDPSSet.size() - 1];
        int i4 = 0;
        while (i4 < options.length) {
            options[i4] = String.valueOf(i4 + 1) + ". " + new ItemSet(maxDPSSet.get((int)(i4 + 1)), (Target)new Target((double)1.0, (double)1.0, (double)1.0, (double)1.0), (String)champion).getList().get(maxDPSSet.get(i4 + 1).size() - 1).toString();
            ++i4;
        }
        String choice = (String)JOptionPane.showInputDialog(null, "Choose an item", "First Item Choice", 3, null, options, options[0]);
        int choiceInt = Integer.parseInt(choice.substring(0, choice.indexOf(".")));
        level = 13;
        minMS = 45.0;
        armor = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the armor of your target(s)?", "40"));
        mr = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the magic resistance of your target(s)?", "40"));
        int i5 = 1;
        while (i5 < maxDPSSet.size()) {
            maxDPSSet.set(i5, maxDPSSet.get(choiceInt));
            maxDPS.set(i5, 0.0);
            ++i5;
        }
        OptimizeBuildPath.addItem(maxDPSSet, maxDPS, champion, armor, mr, level, minMS, minLifeSteal, minCDR, bannedItems);
        i5 = 1;
        while (i5 < maxDPSSet.size()) {
            if (maxDPSSet.get(i5).size() < maxDPSSet.get(1).size()) {
                maxDPSSet.set(i5, maxDPSSet.get(1));
            }
            ++i5;
        }
        options = new String[maxDPSSet.size() - 1];
        i5 = 0;
        while (i5 < options.length) {
            options[i5] = String.valueOf(i5 + 1) + ". " + new ItemSet(maxDPSSet.get((int)(i5 + 1)), (Target)new Target((double)1.0, (double)1.0, (double)1.0, (double)1.0), (String)champion).getList().get(maxDPSSet.get(i5 + 1).size() - 1).toString();
            ++i5;
        }
        choice = (String)JOptionPane.showInputDialog(null, "Choose an item", "Second Item Choice", 3, null, options, options[0]);
        choiceInt = Integer.parseInt(choice.substring(0, choice.indexOf(".")));
        level = 15;
        armor = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the armor of your target(s)?", "60"));
        mr = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the magic resistance of your target(s)?", "60"));
        i5 = 1;
        while (i5 < maxDPSSet.size()) {
            maxDPSSet.set(i5, maxDPSSet.get(choiceInt));
            maxDPS.set(i5, 0.0);
            ++i5;
        }
        OptimizeBuildPath.addItem(maxDPSSet, maxDPS, champion, armor, mr, level, minMS, minLifeSteal, minCDR, bannedItems);
        i5 = 1;
        while (i5 < maxDPSSet.size()) {
            if (maxDPSSet.get(i5).size() < maxDPSSet.get(1).size()) {
                maxDPSSet.set(i5, maxDPSSet.get(1));
            }
            ++i5;
        }
        options = new String[maxDPSSet.size() - 1];
        i5 = 0;
        while (i5 < options.length) {
            options[i5] = String.valueOf(i5 + 1) + ". " + new ItemSet(maxDPSSet.get((int)(i5 + 1)), (Target)new Target((double)1.0, (double)1.0, (double)1.0, (double)1.0), (String)champion).getList().get(maxDPSSet.get(i5 + 1).size() - 1).toString();
            ++i5;
        }
        choice = (String)JOptionPane.showInputDialog(null, "Choose an item", "Third Item Choice", 3, null, options, options[0]);
        choiceInt = Integer.parseInt(choice.substring(0, choice.indexOf(".")));
        level = 16;
        armor = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the armor of your target(s)?", "100"));
        mr = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the magic resistance of your target(s)?", "80"));
        if (champion.equals("Kayle")) {
            minCDR = 40.0;
        }
        i5 = 1;
        while (i5 < maxDPSSet.size()) {
            maxDPSSet.set(i5, maxDPSSet.get(choiceInt));
            maxDPS.set(i5, 0.0);
            ++i5;
        }
        OptimizeBuildPath.addItem(maxDPSSet, maxDPS, champion, armor, mr, level, minMS, minLifeSteal, minCDR, bannedItems);
        i5 = 1;
        while (i5 < maxDPSSet.size()) {
            if (maxDPSSet.get(i5).size() < maxDPSSet.get(1).size()) {
                maxDPSSet.set(i5, maxDPSSet.get(1));
            }
            ++i5;
        }
        options = new String[maxDPSSet.size() - 1];
        i5 = 0;
        while (i5 < options.length) {
            options[i5] = String.valueOf(i5 + 1) + ". " + new ItemSet(maxDPSSet.get((int)(i5 + 1)), (Target)new Target((double)1.0, (double)1.0, (double)1.0, (double)1.0), (String)champion).getList().get(maxDPSSet.get(i5 + 1).size() - 1).toString();
            ++i5;
        }
        choice = (String)JOptionPane.showInputDialog(null, "Choose an item", "Fourth Item Choice", 3, null, options, options[0]);
        choiceInt = Integer.parseInt(choice.substring(0, choice.indexOf(".")));
        level = 17;
        armor = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the armor of your target(s)?", "120"));
        mr = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the magic resistance of your target(s)?", "80"));
        if (champion.equals("Kayle")) {
            minCDR = 40.0;
        }
        i5 = 1;
        while (i5 < maxDPSSet.size()) {
            maxDPSSet.set(i5, maxDPSSet.get(choiceInt));
            maxDPS.set(i5, 0.0);
            ++i5;
        }
        OptimizeBuildPath.addItem(maxDPSSet, maxDPS, champion, armor, mr, level, minMS, minLifeSteal, minCDR, bannedItems);
        i5 = 1;
        while (i5 < maxDPSSet.size()) {
            if (maxDPSSet.get(i5).size() < maxDPSSet.get(1).size()) {
                maxDPSSet.set(i5, maxDPSSet.get(1));
            }
            ++i5;
        }
        options = new String[maxDPSSet.size() - 1];
        i5 = 0;
        while (i5 < options.length) {
            options[i5] = String.valueOf(i5 + 1) + ". " + new ItemSet(maxDPSSet.get((int)(i5 + 1)), (Target)new Target((double)1.0, (double)1.0, (double)1.0, (double)1.0), (String)champion).getList().get(maxDPSSet.get(i5 + 1).size() - 1).toString();
            ++i5;
        }
        choice = (String)JOptionPane.showInputDialog(null, "Choose an item", "Fifth Item Choice", 3, null, options, options[0]);
        choiceInt = Integer.parseInt(choice.substring(0, choice.indexOf(".")));
        level = 18;
        armor = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the armor of your target(s)?", "120"));
        mr = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the magic resistance of your target(s)?", "80"));
        i5 = 1;
        while (i5 < maxDPSSet.size()) {
            maxDPSSet.set(i5, maxDPSSet.get(choiceInt));
            maxDPS.set(i5, 0.0);
            ++i5;
        }
        OptimizeBuildPath.addItem(maxDPSSet, maxDPS, champion, armor, mr, level, minMS, minLifeSteal, minCDR, bannedItems);
        i5 = 1;
        while (i5 < maxDPSSet.size()) {
            if (maxDPSSet.get(i5).size() < maxDPSSet.get(1).size()) {
                maxDPSSet.set(i5, maxDPSSet.get(1));
            }
            ++i5;
        }
        options = new String[maxDPSSet.size() - 1];
        i5 = 0;
        while (i5 < options.length) {
            options[i5] = String.valueOf(i5 + 1) + ". " + new ItemSet(maxDPSSet.get((int)(i5 + 1)), (Target)new Target((double)1.0, (double)1.0, (double)1.0, (double)1.0), (String)champion).getList().get(maxDPSSet.get(i5 + 1).size() - 1).toString();
            ++i5;
        }
        choice = (String)JOptionPane.showInputDialog(null, "Choose an item", "Sixth Item Choice", 3, null, options, options[0]);
        choiceInt = Integer.parseInt(choice.substring(0, choice.indexOf(".")));
        JOptionPane.showMessageDialog(null, new ItemSet(maxDPSSet.get(choiceInt), new Target(1.0, 1.0, 1.0, 1.0), champion).convertIdsToItems(maxDPSSet.get(choiceInt)) + " " + new DecimalFormat("#.#####").format(maxDPS.get(choiceInt)) + " DPS per 1 gold", "Build complete.", 1);
    }
}

