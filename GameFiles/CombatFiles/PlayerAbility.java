package CombatFiles;

import java.util.Random;

/**
 * Ability class that is used in the Gun class
 */
public class PlayerAbility {

    // Variables
    private String abilityName;
    private boolean needsTarget;
    private int abilityBaseDMG, abilityCost, numberOfActions, turnLimit, armourAmount;
    private double acc;
    private int[] healRange;

    /**
     * Constructor for creating a new ability for a gun.
     * 
     * @param abilityName    the name of the ability.
     * @param needsTarget    if the ability requires a target to function.
     * @param abilityBaseDMG the base damage dealt for the ability.
     * @param abilityCost    the action cost of the ability.
     * @param turnLimit      the number of times the ability can be used in one turn.
     */
    public PlayerAbility(String abilityName, boolean needsTarget, int abilityBaseDMG, int abilityCost,
            int numberOfActions, double acc, int turnLimit) {
        this.abilityName = abilityName;
        this.needsTarget = needsTarget;
        this.abilityBaseDMG = abilityBaseDMG;
        this.abilityCost = abilityCost;
        this.numberOfActions = numberOfActions;
        this.turnLimit = turnLimit;
        this.acc = acc;
    }

    /**
     * Constructor for creating player abilites outside of the gun.
     * 
     * @param abilityName
     * @param healAmount
     * @param armourAmount
     * @param abilityCost
     */
    public PlayerAbility(String abilityName, int[] healRange, int armourAmount, int abilityCost) {
        this.abilityName = abilityName;
        this.healRange = healRange;
        this.armourAmount = armourAmount;
        this.abilityCost = abilityCost;
    }

    /**
     * Returns the dmg dealt by the ability, a method for ability damage
     * calculations.
     * 
     * @return abilityBaseDMG * numberOfActions
     */
    public int useAbility() {
        Random r = new Random();
        int actualShots = 0;

        // If there are multiple actions.
        if (numberOfActions > 1) {
            // Calculating how many bullets hit.
            for (int i = 0; i < numberOfActions; i++) {
                if (!((r.nextDouble() * 100) > acc)) {
                    actualShots++;
                }
            }

            // Returns dmg after accuracy calculations
            return abilityBaseDMG * actualShots;
        } else {
            return abilityBaseDMG;
        }
    }

    /**
     * A method to return the armour value.
     * 
     * @return armourAmount
     */
    public int getArmourAmount() {
        return armourAmount;
    }

    /**
     * A method that returns an array of length 2 that contains the bounds for
     * player healing.
     * 
     * @return healrange
     */
    public int[] getHealRange() {
        return healRange;
    }

    /**
     * A method to return the needsTarget boolean.
     * 
     * @return needsTarget
     */
    public boolean needsTarget() {
        return needsTarget;
    }

    /**
     * A method to return the name of the ability.
     * 
     * @return abilityName
     */
    public String getAbilityName() {
        return abilityName;
    }

    /**
     * A method to return the cost of the ability.
     * 
     * @return abilityCost
     */
    public int getAbilityCost() {
        return abilityCost;
    }

    /**
     * A method to return the base damage of the ability.
     * 
     * @return abilityDMG
     */
    public int getBaseDMG() {
        return abilityBaseDMG;
    }

    /**
     * A method to return the number of actions this abiltiy performs when callled.
     * 
     * @return numberOfActions
     */
    public int getNumberOfActions() {
        return numberOfActions;
    }
}
