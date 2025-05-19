/**
 * The {@code Boss} class represents a special type of enemy in the game.
 * It extends the {@code Enemy} class and includes additional attributes and behavior
 * specific to bosses, such as a health multiplier.
 */
public class Boss extends Enemy {
    private String name;
    private int health;
    private String rarity;
    private int multiplyer;

    /**
     * Constructs a new {@code Boss} with the specified name, health, rarity, and multiplier.
     * The boss's health is calculated by multiplying the base health by the multiplier.
     *
     * @param name       the name of the boss
     * @param health     the base health of the boss
     * @param rarity     the rarity of the boss
     * @param multiplyer the multiplier applied to the boss's health
     */
    public Boss(String name, int health, String rarity, int multiplyer) {
        super(name, health * multiplyer, rarity);
        this.multiplyer = multiplyer;
    }

    /**
     * Returns the multiplier applied to the boss's health.
     *
     * @return the health multiplier
     */
    public int getMultiplyer() {
        return multiplyer;
    }

    /**
     * Returns a string representation of the boss, including its name, rarity, and health.
     *
     * @return a string representation of the boss
     */
    @Override
    public String toString() {
        return name + " (" + rarity + ") - Health: " + health;
    }
}