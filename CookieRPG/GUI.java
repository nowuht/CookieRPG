import java.awt.event.ActionEvent;
import javax.swing.*;
public class GUI
{
    
    /**
     * Generates a random integer between the specified minimum and maximum values, inclusive.
     *
     * @param min the minimum value of the random number (inclusive)
     * @param max the maximum value of the random number (inclusive)
     * @return a random integer between min and max, inclusive
     */
    public static int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    
    public static void main(String[] args) {
        
        JTextField textField = new JTextField(20);
        JButton submitButton = new JButton("FIGHT");
        JPanel panel = new JPanel();
        
        panel.add(new JLabel("WHATS IS YOUR NAME?"));
        panel.add(textField);
        panel.add(submitButton);
        
        JFrame inputFrame = new JFrame("Enter Name");
        inputFrame.add(panel);
        inputFrame.setSize(1280, 720);
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputFrame.setVisible(true);
        
        submitButton.addActionListener((ActionEvent e) -> {
            if (textField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(inputFrame, "Please enter a name.");
            return;
            } else {
            String playerName = textField.getText();
            inputFrame.dispose();
            Player player = new Player(playerName);
            
            JFrame gameFrame = new JFrame("RPGClicker");
            JLabel welcomeLabel = new JLabel("Hello " + playerName + "! Click the square to attack!");
            JLabel enemyHealth = new JLabel(player.getEnemy().getName() + " (" + player.getEnemy().getRarity() + ") Health: " + player.getEnemy().getHealth());
            JButton attackButton = new JButton();
            JLabel currentWeapon = new JLabel("Current Weapon: " + player.getWeapon().toString());
            JLabel inventoryLabel = new JLabel("> " + player.getInventory().getWeapons().toString());
            JButton indexUpButton = new JButton("Up");
            JButton indexDownButton = new JButton("Down");
            JButton selectWeaponButton = new JButton("Select Weapon");

            
            attackButton.setBackground(java.awt.Color.RED);
            attackButton.setBounds(540, 310, 50, 50); // Centered in a 1280x720 frame
            attackButton.addActionListener((ActionEvent attackEvent) -> {
                player.attack();
                currentWeapon.setText("Current Weapon: " + player.getWeapon().toString());
                enemyHealth.setText(player.getEnemy().toString());
                if (player.getEnemy().getHealth() <= 0) {
                    player.setEnemyCount(player.getEnemyCount() + 1); // Incrementing the enemy count
                    Weapon newWeapon = player.newWeapon(); // Creating a new weapon using the newWeapon method
                    player.getInventory().addWeapon(newWeapon); // Adding the weapon to the player's inventory
                    if (player.getEnemyCount() == player.getMaxEnemyCount()) {
                        player.setEnemy(player.newBoss());
                    } else if (player.getEnemyCount() > player.getMaxEnemyCount()) {
                        gameFrame.dispose();
                        JOptionPane.showMessageDialog(gameFrame, "You defeated all enemies! Nice Job!");
                    } else {
                        player.setEnemy(player.newEnemy());
                        JOptionPane.showMessageDialog(gameFrame, "You defeated the enemy! You received a new weapon: " + newWeapon.toString());
                        enemyHealth.setText(player.getEnemy().getName() + " (" + player.getEnemy().getRarity() + ") Health: " + player.getEnemy().getHealth());
                    }
                }
                StringBuilder inventoryText = new StringBuilder("<html>");
                    for (int i = 0; i < player.getInventory().getWeapons().size(); i++) {
                        if (i == player.getInventory().getIndex()) {
                            inventoryText.append("> " + player.getInventory().getWeapons().get(i).toString()).append("<br>");
                        } else {
                            inventoryText.append(player.getInventory().getWeapons().get(i).toString()).append("<br>");
                        }
                    }
                inventoryText.append("</html>");
                inventoryLabel.setText(inventoryText.toString());
                attackButton.setBounds(randomNumber(400, 1000), randomNumber(100, 480), 50, 50); // Resetting the button position
            });

            JPanel gamePanel = new JPanel(null); // Using null layout for absolute positioning
            gamePanel.add(welcomeLabel);
            gamePanel.add(attackButton);
            gamePanel.add(enemyHealth);
            gamePanel.add(inventoryLabel);
            gamePanel.add(currentWeapon);
            gamePanel.add(indexUpButton);
            gamePanel.add(indexDownButton);
            gamePanel.add(selectWeaponButton);
            
            indexUpButton.setBounds(50, 500, 100, 30); // Positioning the index up button
            indexUpButton.addActionListener((ActionEvent indexUpEvent) -> {
                player.getInventory().setIndex(player.getInventory().getIndex() - 1);
                if (player.getInventory().getIndex() < 0) {
                            player.getInventory().setIndex(player.getInventory().getWeapons().size() - 1); // Reset index if it exceeds the size
                }
                StringBuilder inventoryText = new StringBuilder("<html>");
                    for (int i = 0; i < player.getInventory().getWeapons().size(); i++) {
                        if (i == player.getInventory().getIndex()) {
                            inventoryText.append("> " + player.getInventory().getWeapons().get(i).toString()).append("<br>");
                        } else {
                            inventoryText.append(player.getInventory().getWeapons().get(i).toString()).append("<br>");
                        }
                    }
                inventoryText.append("</html>");
                inventoryLabel.setText(inventoryText.toString());
            });
            indexDownButton.setBounds(150, 500, 100, 30); // Positioning the index down button
            indexDownButton.addActionListener((ActionEvent indexDownEvent) -> {
                player.getInventory().setIndex(player.getInventory().getIndex() + 1);
                if (player.getInventory().getIndex() >= player.getInventory().getWeapons().size()) {
                            player.getInventory().setIndex(0); // Reset index if it exceeds the size
                }
                StringBuilder inventoryText = new StringBuilder("<html>");
                    for (int i = 0; i < player.getInventory().getWeapons().size(); i++) {
                        if (i == player.getInventory().getIndex()) {
                            inventoryText.append("> " + player.getInventory().getWeapons().get(i).toString()).append("<br>");
                        } else {
                            inventoryText.append(player.getInventory().getWeapons().get(i).toString()).append("<br>");
                        }
                    }
                inventoryText.append("</html>");
                inventoryLabel.setText(inventoryText.toString());
            });
            selectWeaponButton.setBackground(java.awt.Color.CYAN); // Setting the button color to light blue
            selectWeaponButton.setBounds(50, 530, 200, 30); // Positioning the select weapon button
            selectWeaponButton.addActionListener((ActionEvent selectWeaponEvent) -> {
                if (player.getInventory().getWeapons().size() > 0) {
                    Weapon selectedWeapon = player.getInventory().getWeapons().get(player.getInventory().getIndex());
                    player.setWeapon(selectedWeapon);
                    currentWeapon.setText("Current Weapon: " + player.getWeapon().toString());
                }
            });
            
            currentWeapon.setBounds(440, 550, 500, 30); // Positioning the current weapon label towards the bottom left
            inventoryLabel.setBounds(50, 0, 500, 500); // Positioning the inventory label
            welcomeLabel.setBounds(540, 60, 300, 30); // Positioning the welcome label
            enemyHealth.setBounds(540, 580, 300, 30); // Positioning the enemy health label
            gameFrame.add(gamePanel);
            gameFrame.setSize(1280, 720);
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameFrame.setVisible(true);
            }
        });
    }
    
}

