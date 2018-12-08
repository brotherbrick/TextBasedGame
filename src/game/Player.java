package game;

import java.util.Scanner;
import java.util.Random;

public class Player extends Character{
	Scanner s = new Scanner(System.in);
	Random rand = new Random();
	private String playername;
	private int healthPotionDropChance;
	private int healthPotionHealAmount;
	private int numHealthPotions;
	
	
	public static boolean hit;

	private int hitchance;

	
	public Player() {
		super(100);
		numHealthPotions = 3;
		healthPotionDropChance = 50;
	}
	
	public void usePotion() {
		super.increaseHealth(30);
		numHealthPotions--;
		
	}
	
	
	
	
	
	
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
	
	
	
	public String getPlayername() {
		return playername;
	}

	public boolean getHit() {
		return hit;
	}
	

	public String getHealthPotionAmount() {
		
		return "30";
	}

	public int getnumHealthPotions() {
		// TODO Auto-generated method stub
		return numHealthPotions;
	}

	public int gethealthPotionDropChance() {
		// TODO Auto-generated method stub
		return healthPotionDropChance;
	}

	public void increasenumHealthPotions() {
		
		numHealthPotions++;
		
	}
	
	
}
