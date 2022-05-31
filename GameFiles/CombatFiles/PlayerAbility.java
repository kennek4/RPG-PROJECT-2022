package CombatFiles;

/**
 * Ability class that is used in the Gun class
 */
public class PlayerAbility {

    // Variables
    private String abilityName;
    private boolean needsTarget;
    private int abilityBaseDMG, abilityCost, numberOfActions, armourAmount, critChance;
    private int[] healRange;

    /**
     * Constructor for creating a new ability for a gun.
     * 
     * @param abilityName    the name of the ability.
     * @param needsTarget    if the ability requires a target to function.
     * @param abilityBaseDMG the base damage dealt for the ability.
     * @param abilityCost    the action cost of the ability.
     * @param critChance     the percent chance to crit the enemy.
     */
    public PlayerAbility(String abilityName, boolean needsTarget, int abilityBaseDMG, int abilityCost,
            int numberOfActions, int critChance) {

        this.abilityName = abilityName;
        this.needsTarget = needsTarget;
        this.abilityBaseDMG = abilityBaseDMG;
        this.abilityCost = abilityCost;
        this.numberOfActions = numberOfActions;
        this.critChance = critChance;

    }

    /**
     * A constructor for support skills
     * 
     * @param abilityName
     * @param healRange
     * @param armourAmount
     * @param abilityCost
     * @param turnLimit
     */
    public PlayerAbility(String abilityName, int[] healRange, int armourAmount, int abilityCost, int turnLimit) {
        this.abilityName = abilityName;
        this.healRange = healRange;
        this.armourAmount = armourAmount;
        this.abilityCost = abilityCost;
    }

    /**
     * Returns the dmg dealt by the ability, a method for ability damage
     * calculations.
     * 
     * @return abilityBaseDMG
     */
    public int useAbility() {
        return abilityBaseDMG;
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

    public int getCritChance() {
        return critChance;
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
