package CombatFiles;

/**
 * Gun class; holds unique GunAbilities for use in combat by the user.
 */
public class Gun {

    // Variables
    String abilityName;
    int abilityBaseDMG, abilityCost;
    boolean needsTarget;

    GunAbility a1, a2, a3, a4;

    CombatGUI ui;

    /**
     * Constructor for a gun that requires an 4 abilities.
     * 
     * @param a1 ability 1
     * @param a2 ability 2
     * @param a3 ability 3
     * @param a4 ability 4
     */
    public Gun(GunAbility a1, GunAbility a2, GunAbility a3, GunAbility a4) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
    }

    /**
     * Chooses a target for the abilities.
     */
    public void chooseTarget() {
        ui.targetToggle();
    }

    /**
     * Method that uses the ability.
     */
    public void useAbility() {
        System.out.println("This is where you use the ability.");
    }
}
