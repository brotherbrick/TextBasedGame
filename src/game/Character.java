package game;

public class Character {
	private int health;
	private int attackDamage;
	public void damageTaken(int damage) {
		health -= damage;
	}
	
	public void increaseHealth(int health) {
		this.health += health;
	}
	
	public Character(int health) {
		this.health = health;
		
	}
	
	public int getHealth() {
		return this.health;
	}
	
	
}


