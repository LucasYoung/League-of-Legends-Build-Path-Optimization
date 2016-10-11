SUMMARY OF PROGRAM

League of Legends is a competitive multiplayer game in which a player controls a champion.
An important aspect of playing the game is choosing items to buy for the champion with limited gold.
These items can modify a champion's stats, abilities, or have another unique effect.
The purpose of this program is to find the optimal set of items in terms of maximizing the damage that a champion deals with limited gold.

This cannot be determined mathematically because:
1. The items and abilities have unique effects that have very specific interactions with each other
2. The optimal set of items is subjective to some degree because items can provide utility- important in-game effects that have no bearing on damage (e.g. how fast the champion moves) 

Computation solves these problems by:
1. Representing these interactions through code and then simulating the game
2. Allowing the user to choose the items, but presenting the user with the optimal choice in terms of maximizing damage

There are two programs within this project that solve the optimization problem:
OptimizeBuildPath:
This program presents the items in order of descending damage/gold ratio and prompts the user to choose one.
Then, it calculates which items yield the greatest damage/gold ratio again based on the items that the user has already chosen.
This is meant for the user to arbitrate which items are optimal while choosing a possible comination of items

Optimizedamage:
This program runs through every possible combination of items (20 C 6) and presents the top 10 greatest sets of items in terms of damage/gold ratio.
There is no user arbitration involved in this program.

Concepts demonstrated in this project:
Multidimensional Arrays
Parallel Arrays
Optimization by guess-and-check
Encapsulation
Polymorphism
Abstraction

The program must acount for the following that factor into a calculation of damage per second:
-The champion's stats (e.g. Attack Damage)
-The effects of champion abilities and cooldowns (e.g. Lightslinger)
-The target's stats (e.g. Armor, Magic Resistance, and Health)
-The passive effects of items (e.g. The Black Cleaver)
-The champion's masteries (e.g. Fervor)

BRIEF DOCUMENTATION

ItemSet: Contains an array of items and the methods that calculate 

Item: The parent class for every item. In the child item classes, the method statPassive() simulates the unique effects of each item

The stats that items provide are placed in arrays so that they can efficiently be added to the champion's overall stats with a for-loop.
These are the indexes for stats that are used:
0. Attack Damage (AD)- the amount of damage that a single attack does
1. Attack Speed (attackSpeed)- a stat that effects the rate at which the champion attacks
2. Percentage likelihood of a critical hit (critChance)
3. Damage modifier of a critical hit (critDamage)
4. Flat armor penetration (flatArPen)- the flat amount of armor that is ignored upon damage calculation 
5. Percentage armor penetration (percentArPen)- a percentage of armor that is ignored upon damage calculation
6. Flat magic penetration (flatMagicPen)- the flat amount of magic resistance that is ignored upon damage calculation 
7. Percentage magic penetration (percentMagicPen)- a percentage amount of magic resistance that is ignored upon damage calculation
8. Price (gold)- the price of the item
9. Lifesteal (lifeSteal)- a percentage of damage dealt upon an attack restored as health to the champion
10. Movement Speed (MS)- A stat that affects how fast the champion moves
11. Ability Power (AP)- A stat that can affect the amount of damage that a champion's abilities yields
12. Cooldown Reduction (CDR)- A percentage that modifies the cooldown time of a champion's abilities
13. Champion level

BANNED ID numbers:
Because certain items are unavailable at different stages of the game, some ID numbers are not iterated through at different points in the calculation.

Item Set Standards: 
The program checks to make sure that the ItemSet is viable and possible within the game. 
For example, it is impossible to make use of multiple Guinsoo's Rageblade items, therefore an ItemSet with a guinsooCount>1 will not be returned.

GLOSSARY
DPS-Damage per second

