package game;

public class Enemy extends Character{

	public Enemy() {
		super(75);
	}
	String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assassin" };
	private int maxEnemyHealth = 75;
	private int enemyAttackDamage = 25;
	
	public int getAttackDamage() {
		return enemyAttackDamage;
	}
	
}
