package creatures;

// This class is a WIP. In the future, all skills will be Skill objects.
public class Skill {

	private String name;
	
	private int damage = 0;
	private int healing = 0;

	private int healthCost = 0;
	private int manaCost = 0;

	// True if the skill can kill another creature.
	private boolean deadly = true;

	public Skill(String name)
	{
		
	}	

	public String getName() {
		return name;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}

	public int getManaCost() {
		return manaCost;
	}

	public int getHealthCost() {
		return healthCost;
	}

	public void setHealthCost(int healthCost) {
		this.healthCost = healthCost;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealing() {
		return healing;
	}

	public void setHealing(int healing) {
		this.healing = healing;
	}

	public boolean isDeadly() {
		return deadly;
	}
	
}
