import javax.swing.JOptionPane;
public class Player {
    private String name;
    private Weapon weapon;
    private Enemy enemy;
    private Inventory inventory;
    private int enemyCount;
    private int maxEnemyCount;

    public Player(String name) {
        this.name = name;
        this.weapon = new Weapon("Starter Sword", 10, 25, "COMMON");
        this.enemy = newEnemy();
        this.inventory = new Inventory();
        this.inventory.addWeapon(weapon);
        this.enemyCount = 0;
        this.maxEnemyCount = (int) (Math.random() * 4) + 6;
    }

    public Inventory getInventory() {
        return inventory;
    }
    
    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public int getEnemyCount() {
        return enemyCount;
    }

    public int getMaxEnemyCount() {
        return maxEnemyCount;
    }

    public void setEnemyCount(int enemyCount) {
        this.enemyCount = enemyCount;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void attack() {
        enemy.takeDamage(weapon.getAttackPower());
        weapon.durabilityDecrement();
        if (weapon.getDurability() <= 0) {
            JOptionPane.showMessageDialog(null, "Your weapon broke!");
            inventory.removeWeapon(weapon);
            weapon = inventory.getWeapons().get(0);
        }
    }

    public static Enemy newEnemy() {
        String[] names = {"Goblin", "Orc", "Troll", "Skeleton", "Zombie"};
        String[] rarities = {"COMMON", "UNCOMMON", "RARE", "EPIC", "LEGENDARY"};
        
        int randomNameIndex = (int) (Math.random() * names.length);
        int randomRarityIndex = (int) (Math.random() * 100) + 1;

        String name = names[randomNameIndex];
        String rarity = null;
        int health = 100;

        if (randomRarityIndex <= 50) {
            rarity = rarities[0];
            health = 100 + (int) (Math.random() * 25);
        } else if (randomRarityIndex <= 75) {
            rarity = rarities[1];
            health = 125 + (int) (Math.random() * 25);
        } else if (randomRarityIndex <= 88) {
            rarity = rarities[2];
            health = 150 + (int) (Math.random() * 25);
        } else if (randomRarityIndex <= 95) {
            rarity = rarities[3];
            health = 175 + (int) (Math.random() * 25);
        } else {
            rarity = rarities[4];
            health = 200 + (int) (Math.random() * 25);
        }
        
        return new Enemy(name, health, rarity);
    }

    public static Boss newBoss() {
        return new Boss("Boss", 225 + (int) (Math.random() * 25), "BOSS", 2 + (int) (Math.random() * 2));
    }

    public Weapon newWeapon() {
        String[] names = {"Longsword", "Mace", "Warhammer", "Halberd", "Flail", "Morningstar", "Battleaxe", "Claymore", "Rapier", "Scimitar"};

        int randomNameIndex = (int) (Math.random() * names.length);

        String name = names[randomNameIndex];
        String rarity = enemy.getRarity();
        int attackPower = 0;
        if (rarity.equals("COMMON")) {
            attackPower = 15 + (int) (Math.random() * 10);
        } else if (rarity.equals("UNCOMMON")) {
            attackPower = 25 + (int) (Math.random() * 10);
        } else if (rarity.equals("RARE")) {
            attackPower = 35 + (int) (Math.random() * 10);
        } else if (rarity.equals("EPIC")) {
            attackPower = 45 + (int) (Math.random() * 10);
        } else {
            attackPower = 55 + (int) (Math.random() * 15);
        }

        int durability = 10 + (int) (Math.random() * 10);

        return new Weapon(name, attackPower, durability, rarity);
    }
}
