package game;

import java.util.Random;
import java.util.Scanner;
public class Game_Driver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Setting set = new Setting();
		Player player = new Player();
		String playerInput;
		set.die();
		
		System.out.println("You are in a " + set.getSetting() + " where there is a man, what do you want to do?");
		playerInput = s.nextLine();
		
		switch (playerInput) {
		case "Attack": 
		case "attack":
			player.hitdie();
			player.getHit();
			if (player.getHit() == false) {
				System.out.println("You missed and got your ass beaten.");
			}
			else {
				System.out.println("You punch him square in the face.");
			}
			break;
		case "Greet":
			System.out.println("Man: 'Hello.'");
			break;
		default: System.out.println("Try something else.");
		}
		
	
	}
}
