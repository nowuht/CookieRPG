/**
 * The {@code Enemy} class represents an enemy in the game. 
 * It contains attributes such as the enemy's name, health, and rarity.
 * The class provides methods to access these attributes, apply damage, 
 * and represent the enemy as a string.
 */
public class Enemy {
    private String name;
    private int health;
    private String rarity;

    /**
     * Constructs a new {@code Enemy} with the specified name, health, and rarity.
     *
     * @param name   the name of the enemy
     * @param health the health of the enemy
     * @param rarity the rarity of the enemy
     */
    public Enemy(String name, int health, String rarity) {
        this.name = name;
        this.health = health;
        this.rarity = rarity;
    }

    /**
     * Returns the name of the enemy.
     *
     * @return the name of the enemy
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current health of the enemy.
     *
     * @return the health of the enemy
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns the rarity of the enemy.
     *
     * @return the rarity of the enemy
     */
    public String getRarity() {
        return rarity;
    }

    /**
     * Reduces the enemy's health by the specified damage amount. 
     * If the health drops below 0, it is set to 0.
     *
     * @param damage the amount of damage to apply to the enemy
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    /**
     * Returns a string representation of the enemy, including its name, rarity, and health.
     *
     * @return a string representation of the enemy
     */
    public String toString() {
        return name + " (" + rarity + ") - Health: " + health;
    }
}