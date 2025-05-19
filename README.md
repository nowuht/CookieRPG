# CookieRPG

CookieRPG is a simple RPG-style game where players battle enemies, collect weapons, and progress through challenges. The game features inventory management, weapon durability, and enemy encounters.

## Features

- **Player Management**: Create and manage a player character with a name, weapon, inventory, and stats.
- **Weapon System**: Collect and equip weapons with varying attack power, durability, and rarity.
- **Enemy Encounters**: Fight enemies with different health and rarity levels.
- **Boss Battles**: Encounter powerful bosses with unique stats.
- **Inventory System**: Manage a collection of weapons, add new ones, and remove broken ones.

## Project Structure

```
Boss.java         - Represents boss enemies in the game.
Enemy.java        - Represents regular enemies with health and rarity.
GUI.java          - Handles the graphical user interface for the game.
Inventory.java    - Manages the player's inventory of weapons.
Player.java       - Represents the player and core gameplay mechanics.
README.md         - Documentation for the project.
Weapon.java       - Represents weapons with attack power, durability, and rarity.
```

## Key Classes

### Weapon
The `Weapon` class represents a weapon with attributes such as:
- Name
- Attack power
- Durability
- Rarity

### Inventory
The `Inventory` class manages the player's collection of weapons, providing methods to:
- Add weapons
- Remove weapons
- Access the list of weapons

### Player
The `Player` class represents the player character and includes methods for:
- Attacking enemies
- Generating new enemies and bosses
- Managing the player's inventory
- Equipping and managing weapons

### Enemy
The `Enemy` class represents enemies with:
- Name
- Health
- Rarity

### Boss
The `Boss` class represents a special type of enemy with additional attributes and behavior, such as a health multiplier. Bosses are more challenging enemies with higher stats.

### GUI
The `GUI` class provides a graphical interface for the game, allowing players to interact with the game world.

## How to Run

1. Compile all `.java` files in the project:
   javac *.java
   
2. Run the `GUI` class to start the game:
   java GUI

## Gameplay

1. **Start the Game**: Launch the game through the GUI.
2. **Battle Enemies**: Use your equipped weapon to attack enemies. Weapons have durability and will break after a certain number of uses.
3. **Collect Weapons**: Defeat enemies to collect new weapons with varying stats.
4. **Face Bosses**: Progress through the game to encounter powerful bosses.
5. **Manage Inventory**: Equip and manage your weapons to optimize your performance in battles.

## Future Improvements

- Add more enemy types and bosses.
- Introduce additional weapon attributes (e.g., special effects).
- Implement a leveling system for the player.
- Expand the GUI with more interactive elements.

---
