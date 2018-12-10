package game;

import java.util.Random;
import java.util.Scanner;

public class Game_Driver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Setting set = new Setting();
		Player player = new Player();
		Enemy enemy = new Enemy();
		String playerInput;
		boolean fighting = false;
		set.die();
		Random rand = new Random();

		String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assasin" };
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;

		boolean running = true;

		System.out.println("Welcome to the game!");

		GAME: while (running) {
			System.out.println("Welcome to " + set.getSetting() + ".");

			System.out.println("There is a man. What do you want to do?");
			playerInput = s.nextLine();

			if (playerInput.equalsIgnoreCase("attack")) {
				fighting = true;
				System.out.println("------------------------------------------------------------------");
				int enemyHealth = rand.nextInt(maxEnemyHealth);
				String enemyType = enemies[rand.nextInt(enemies.length)];
				System.out.println("\t# " + enemyType + " has appeared! #\n");
				fighting = true;
				while (fighting == true) { // begin fight loop
											// ---------------------------------------------------------------------

					System.out.println("\tYour HP: " + player.getHealth());
					System.out.println("\t" + enemyType + "'s HP: " + enemyHealth);
					System.out.println("\n\tWhat would you like to do?");
					System.out.println("\t1. Attack");
					System.out.println("\t2. Drink health potion");
					System.out.println("\t3. Run!");
					String input = s.nextLine();

					if (input.equals("1")) { // attack
						int damageDealt = rand.nextInt(enemy.getAttackDamage());
						int damageTaken = rand.nextInt(enemyAttackDamage);

						enemyHealth -= damageDealt;
						player.damageTaken(damageTaken);

						System.out.println("\t> You strike the " + enemyType + " for " + damageDealt + " damage.");
						System.out.println("\t> You recieve " + damageTaken + " in retaliation!");

						if (player.getHealth() < 1) { // dies
							System.out.println("\t> You have taken too much damage, you are too weak to go on.");
							fighting = false;
						} else if (enemyHealth <= 0) {
							System.out.println("\t Your enemy has been defeated.");
							fighting = false;
						}
					} else if (input.equals("2")) { // health potion
						if (player.getnumHealthPotions() > 0) {

							player.usePotion();

							System.out.println("\t> You drink a health potion, healing yourself for "
									+ player.getHealthPotionAmount() + "." + "\n\t> You now have " + player.getHealth()
									+ " HP." + "\n\t> You have " + player.getnumHealthPotions()
									+ " health potions left.\n");

						} else { // out of health potions

							System.out.println(
									"\t> You have no health potions left. Defeat enemies for a chance to get more!");

						}
					} else if (input.equals("3")) { // runs away

						System.out.println("\tYou run away from the " + enemyType + "!");
						continue GAME;

					} else { // invalid command

						System.out.println("\tInvalid command.");

					}
				} // end fight loop --------------------------------------------------

				fighting = false;
				if (player.getHealth() < 1) { // player dies ends game
					System.out.println("You limp out of the dungeon, weak from battle.");
					break;
				} // player wins fight

				System.out.println("------------------------------------------------------------------");
				System.out.println(" # " + enemyType + " was defeated! # ");
				System.out.println(" # You have " + player.getHealth() + " HP left. # ");
				if (rand.nextInt(100) < player.gethealthPotionDropChance()) {
					player.increasenumHealthPotions();
					System.out.println(" # The " + enemyType + " dropped a health potion! # ");
					System.out.println(" # You now have " + player.getnumHealthPotions() + " health potion(s). # ");
				}
				System.out.println("------------------------------------------------------------------");
				System.out.println("You continue on.");

				//while (!input.equals("1") && !input.equals("2")) {
					//System.out.println("Invalid command!");
					//input = s.nextLine();
				
				System.out.println(
						"You look around and see a house, and a swimming pool. Where do you want to go next?");
				String userInput = s.nextLine();
				if (userInput.equalsIgnoreCase("go to house")) {
					System.out.println("You go to the house.");
				} else if (userInput.equalsIgnoreCase("go to swimming pool")) {
					System.out.println("You go to the swimming pool.");
				}
				
				}

			}
		

		
		
		
		System.out.println("###########################");
		System.out.println("#    THANKS FOR PLAYING   #");
		System.out.println("###########################");

	}

}
