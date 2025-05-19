import java.util.ArrayList;

/**
 * The {@code Inventory} class represents a player's inventory in the game.
 * It manages a collection of weapons and provides methods to add, remove, and access weapons.
 */
public class Inventory {

    private ArrayList<Weapon> weapons;
    private int index;

    /**
     * Constructs a new {@code Inventory} object.
     * Initializes an empty list of weapons and sets the index to 0.
     */
    public Inventory() {
        weapons = new ArrayList<>();
        index = 0;
    }

    /**
     * Returns the list of weapons in the inventory.
     *
     * @return an {@code ArrayList} containing the weapons in the inventory
     */
    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    /**
     * Sets the current index of the inventory.
     *
     * @param index the new index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Returns the current index of the inventory.
     *
     * @return the current index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Adds a weapon to the inventory.
     *
     * @param weapon the {@code Weapon} to add to the inventory
     */
    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    /**
     * Removes a weapon from the inventory.
     *
     * @param weapon the {@code Weapon} to remove from the inventory
     */
    public void removeWeapon(Weapon weapon) {
        weapons.remove(weapon);
    }
}