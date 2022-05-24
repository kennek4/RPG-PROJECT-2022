package CombatFiles;

import java.util.HashMap;

/**
 * Gun class; holds unique GunAbilities for use in combat by the user.
 */
public class Gun {

    // Variables
    String abilityName;
    int abilityBaseDMG, abilityCost;
    boolean needsTarget;

    PlayerAbility a1, a2, a3, a4;
    HashMap<Integer, PlayerAbility> abilityID;

    /**
     * Constructor for a gun that requires an 4 abilities.
     * 
     * @param a1 ability 1
     * @param a2 ability 2
     * @param a3 ability 3
     * @param a4 ability 4
     */
    public Gun(PlayerAbility a1, PlayerAbility a2, PlayerAbility a3, PlayerAbility a4) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;

        abilityID = new HashMap<>() {
            {
                put(0, a1);
                put(1, a2);
                put(2, a3);
                put(3, a4);
            }
        };
    }

}
