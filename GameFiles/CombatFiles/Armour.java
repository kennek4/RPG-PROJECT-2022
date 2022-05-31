package CombatFiles;

/**
 * Armour class, emulates a piece of armour by storing data.
 */
public class Armour {

    public int armourClass, armourAmount;

    /**
     * Constructor for the Armour class which holds values that emulate a piece of
     * combat armour.
     * 
     * @param armourClass
     * @param armourAmount
     */
    public Armour(int armourClass, int armourAmount) {
        this.armourClass = armourClass;
        this.armourAmount = armourAmount;
    }
}
