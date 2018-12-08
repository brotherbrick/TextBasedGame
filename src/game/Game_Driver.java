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
		set.die();
		Random rand = new Random();

		String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assasin" };
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;

		boolean running = true;

		System.out.println("Welcome to the game!");

		GAME: while (running) {
			System.out.println("------------------------------------------------------------------");

			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemyType = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemyType + " has appeared! #\n");

			while (enemyHealth > 0) { //begin fight loop ---------------------------------------------------------------------
				System.out.println("\tYour HP: " + player.getHealth());
				System.out.println("\t" + enemyType + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Run!");
				String input = s.nextLine();
				
				if (input.equals("1")) { //attack
					int damageDealt = rand.nextInt(enemy.getAttackDamage());
					int damageTaken = rand.nextInt(enemyAttackDamage);

					enemyHealth -= damageDealt;
					player.damageTaken(damageTaken);

					System.out.println("\t> You strike the " + enemyType + " for " + damageDealt + " damage.");
					System.out.println("\t> You recieve " + damageTaken + " in retaliation!");

					if (player.getHealth() < 1) { //dies
						System.out.println("\t> You have taken too much damage, you are too weak to go on.");
						break;
					}
					else { //not option
						System.out.println("\t> That is not an option.");
					}
				} else if (input.equals("2")) { //health potion
					if (player.getnumHealthPotions() > 0) {
						
						player.usePotion();
						
						System.out.println("\t> You drink a health potion, healing yourself for "
								+ player.getHealthPotionAmount() + "." + "\n\t> You now have " + player.getHealth() + " HP."
								+ "\n\t> You have " + player.getnumHealthPotions() + "health potions left.\n");
						
					} else { //out of health potions
						
						System.out.println(
								"\t> You have no health potions left. Defeat enemies for a chance to get more!");
						
					}
				} else if (input.equals("3")) { //runs away
					
					System.out.println("\tYou run away from the " + enemyType + "!");
					continue GAME;
					
				} else { //invalid command

					System.out.println("\tInvalid command.");

				}
			} //end fight loop --------------------------------------------------
			
			if(player.getHealth() < 1) { //player dies ends game
				System.out.println("You limp out of the dungeon, weka from battle.");
				break;
			} //player wins fight
			
			System.out.println("------------------------------------------------------------------");
			System.out.println(" # " + enemyType + " was defeated! # ");
			System.out.println(" # You have " + player.getHealth() + " HP left. # ");
			if(rand.nextInt(100) < player.gethealthPotionDropChance()) {
				player.increasenumHealthPotions();
				System.out.println(" # The " + enemyType + " dropped a health potion! # ");
				System.out.println(" # You now have " + player.getnumHealthPotions() + " health potion(s). # ");
			}
			System.out.println("------------------------------------------------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit dungeon.");
			
			String input = s.nextLine();
			
			while(!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid command!");
				input = s.nextLine();
			}
			
			if(input.equals("1")) { //restarts loop
				System.out.println("You continue on your adventure!");
			}
			else if(input.equals("2")) { //stops loop
				System.out.println("You exit the dungeon, successful from your adventures!");
				break;
				
			}
			
			
		}

		System.out.println("###########################");
		System.out.println("#    THANKS FOR PLAYING   #");
		System.out.println("###########################");
		
	}
	
	
	
}
