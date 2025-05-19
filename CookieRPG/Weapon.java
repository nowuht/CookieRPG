/**
 * The {@code Weapon} class represents a weapon with attributes such as name, attack power,
 * durability, and rarity. It provides methods to access these attributes and manage the weapon's durability.
 */
public class Weapon {
    private String name;
    private int attackPower;
    private int durability;
    private String rarity;

    /**
     * Constructs a new {@code Weapon} with the specified attributes.
     *
     * @param name        the name of the weapon
     * @param attackPower the attack power of the weapon
     * @param durability  the durability of the weapon
     * @param rarity      the rarity of the weapon
     */
    public Weapon(String name, int attackPower, int durability, String rarity) {
        this.name = name;
        this.attackPower = attackPower;
        this.durability = durability;
        this.rarity = rarity;
    }

    /**
     * Returns the name of the weapon.
     *
     * @return the name of the weapon
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the attack power of the weapon.
     *
     * @return the attack power of the weapon
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Returns the current durability of the weapon.
     *
     * @return the durability of the weapon
     */
    public int getDurability() {
        return durability;
    }

    /**
     * Returns the rarity of the weapon.
     *
     * @return the rarity of the weapon
     */
    public String getRarity() {
        return rarity;
    }

    /**
     * Decrements the durability of the weapon by 1. If the durability becomes less than 0,
     * it is set to 0.
     */
    public void durabilityDecrement() {
        durability--;
        if (durability < 0) {
            durability = 0;
        }
    }

    /**
     * Returns a string representation of the weapon, including its name, rarity, attack power,
     * and durability.
     *
     * @return a string representation of the weapon
     */
    public String toString() {
        return name + " (" + rarity + ") - Damage: " + attackPower + ", Durability: " + durability;
    }
}