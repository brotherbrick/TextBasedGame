package game;

import java.util.Scanner;
import java.util.Random;

public class Player {
	Scanner s = new Scanner(System.in);
	Random rand = new Random();
	public static String playername;
	public static int playerhp;
	public static int maxhp;
	public static int mana;
	public static int maxmana;
	public static int playerdmg;
	public static int playerLevel;
	public static int xp;
	public static boolean hit;

	private int hitchance;
	
	public void setPlayername() {
		playername = s.nextLine();
	}
	
	public void hitdie() {
		int hitdie = rand.nextInt(5);
		if (hitdie >= 2) {
			hit = true;
		} else {
			hit = false;
		}
	}
	
	public static int playerdmg(int Level) {
		
		playerdmg = 10 * Level;
		return playerdmg;
		
	}
	
	public String getPlayername() {
		return playername;
	}

	public boolean getHit() {
		return hit;
	}
	//test
	
	
}
