package CombatFiles;

import java.util.Random;

/**
 * Ability class that is used in the Gun class
 */
public class GunAbility {

    // Variables
    private String abilityName;
    private boolean needsTarget;
    private int abilityBaseDMG, abilityCost, numberOfActions;
    private double acc;

    /**
     * Constructor for creating a new ability for a gun.
     * 
     * @param abilityName    the name of the ability.
     * @param needsTarget    if the ability requires a target to function
     * @param abilityBaseDMG the base damage dealt for the ability
     * @param abilityCost    the action cost of the ability.
     */
    public GunAbility(String abilityName, boolean needsTarget, int abilityBaseDMG, int abilityCost,
            int numberOfActions, double acc) {
        this.abilityName = abilityName;
        this.needsTarget = needsTarget;
        this.abilityBaseDMG = abilityBaseDMG;
        this.abilityCost = abilityCost;
        this.numberOfActions = numberOfActions;
        this.acc = acc;
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
