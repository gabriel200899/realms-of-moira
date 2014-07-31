package creatures;

import java.util.ArrayList;

public class Creature {

	private String name, role, race;
	
	// TODO: make skill a class, so we only use one ArrayList.
	private ArrayList<String> skills = new ArrayList<String>();
	private ArrayList<String> skillsInfo = new ArrayList<String>();
	private ArrayList<String> skillsArray = new ArrayList<String>();
	private ArrayList<Integer> skillsMana = new ArrayList<Integer>();

	// We add a kill counter
	private KillCounter;
	
	private int level = 1;
	private int experience = 0;
	private int gold = 0;
	
	private int healthRegen;
	private int healthCurrent;
	private int healthMaximum;
	private int manaRegen;
	private int manaCurrent;
	private int manaMaximum;

	private int attackCurrent = 0;
	private int attackDefault = 0;
	private int defenseCurrent = 0;
	private int defenseDefault = 0;

	private int regrowthStack = 0;
	private int regrowthPower = 5;
	private int regrowthMaximum = 4;
	
	private int weaknessStack = 0;
	private int weaknessPower = 5;
	private int weaknessMaximum = 4;
	
	private int agonyStack = 0;
	private int agonyPower = 5;
	private int agonyMaximum = 4;
	
	private int curseStack = 0;
	private int cursePower = 5;
	private int curseMaximum = 4;
	
	private int bleedStack = 0;
	private int bleedPower = 10;
	private int bleedMaximum = 2;
	
	private int poisonStack = 0;
	private int poisonPower = 10;
	private int poisonMaximum = 2;
	
	private int stunStack = 0;
	private boolean alive = true;
	private boolean blocking = false;

	public void attack(Creature it) {
		it.instantDamage(10);
	}

	public void block() {
		this.setBlocking(true);
	}

	public void skill1(Creature it) {
	}

	public void skill2(Creature it) {
	}

	public void skill3(Creature it) {
	}

	public void skill4(Creature it) {
	}

	public void skill5(Creature it) {
	}

	public void skill6(Creature it) {
	}

	public int evaluatePeriodicDamage() {
		int periodicDamage = 0;
		periodicDamage -= this.agonyPower * this.agonyStack;
		periodicDamage -= this.bleedPower * this.bleedStack;
		periodicDamage -= this.poisonPower * this.poisonStack;
		periodicDamage -= this.cursePower * this.curseStack;
		return periodicDamage;
	}

	public int evaluatePeriodicHealing() {
		int periodicHealing = 0;
		periodicHealing += this.regrowthPower * this.regrowthStack;
		return periodicHealing;
	}

	public void evaluateHealth() {
		this.healthCurrent += this.evaluatePeriodicHealing();
		this.healthCurrent -= this.evaluatePeriodicDamage();
		if (this.healthCurrent < 10) {
			this.healthCurrent = 10;
		} else if (this.healthCurrent > this.healthMaximum) {
			this.healthCurrent = this.healthMaximum;
		}
	}

	public void evaluateMana() {
		this.manaCurrent += this.manaRegen;
		if (this.manaCurrent > this.manaMaximum) {
			this.manaCurrent = this.manaMaximum;
		}
	}

	public void evaluateAttack() {
		int attack = this.attackDefault;
		attack -= 5 * this.weaknessStack;
		this.setAttack(attack);
	}

	public void evaluateDefense() {
		int defense = this.defenseDefault;
		defense -= this.weaknessPower * this.weaknessStack;
		this.setDefense(defense);
	}

	public void evaluateLevel() {
		if (this.getExperience() >= this.getLevel() * this.getLevel() * 100) {
			this.setLevel(this.getLevel() + 1);
			System.out.println("You leveled up!");
			System.out.println("Now you are level " + this.level);
		}
	}

	public boolean evaluateHit(int probability) {
		if (Math.random() * 100 < probability)
			return true;
		else
			return false;
	}

	public void instantDamage(int damage) {
		damage -= this.defenseCurrent;
		if (damage > 0) {
			this.setHealth(this.getHealth() - damage);
		}
	}

	public void periodicDamage(int damage) {
		if (damage <= this.getHealth() - 10) {
			this.setHealth(this.getHealth() - damage);
		}
	}

	public void instantHealing(int healing) {
		if (this.healthCurrent + healing > this.healthMaximum) {
			this.healthCurrent = this.healthMaximum;
		} else {
			this.healthCurrent += healing;
		}
	}

	public void periodicHealing(int damage) {
		if (damage <= this.getHealth() - 10) {
			this.setHealth(this.getHealth() - damage);
		}
	}

	public int getAgony() {
		return agonyStack;
	}

	public int getAttack() {
		return attackCurrent;
	}

	public int getBleed() {
		return bleedStack;
	}

	public int getCurse() {
		return curseStack;
	}

	public int getDefense() {
		return defenseCurrent;
	}

	public int getExperience() {
		return experience;
	}

	public int getGold() {
		return gold;
	}

	public int getHealth() {
		return healthCurrent;
	}

	public int getLevel() {
		return level;
	}

	public int getMana() {
		return manaCurrent;
	}public int getMaximumRegrowth() {
		return 4;
	}

	public int getMaximumWeakness() {
		return 2;
	}

	public String getName() {
		return name;
	}

	public int getNativeAttack() {
		return attackDefault;
	}

	public int getNativeDefense() {
		return defenseDefault;
	}

	public int getNativeHealth() {
		return healthMaximum;
	}

	public int getNativeMana() {
		return manaMaximum;
	}

	public int getPoison() {
		return poisonStack;
	}

	public String getRace() {
		return race;
	}

	public int getRegenHealth() {
		return healthRegen;
	}

	public int getRegrowth() {
		return regrowthStack;
	}

	public String getRole() {
		return role;
	}

	public String[] getSkills() {
		String[] array = new String[skills.size()];
		for (int n = 0; n < skills.size(); n++) {
			array[n] = skills.get(n);
		}
		return array;
	}

	public String[] getSkillsArray() {
		String[] array = new String[skillsArray.size()];
		for (int n = 0; n < skillsArray.size(); n++) {
			array[n] = skillsArray.get(n);
		}
		return array;
	}

	public String[] getSkillsInfo() {
		String[] array = new String[skillsInfo.size()];
		for (int n = 0; n < skillsInfo.size(); n++) {
			array[n] = skillsInfo.get(n);
		}
		return array;
	}

	public int[] getSkillsMana() {
		int[] array = new int[skillsMana.size()];
		for (int n = 0; n < skillsMana.size(); n++) {
			array[n] = skillsMana.get(n);
		}
		return array;
	}

	public int getStun() {
		return stunStack;
	}

	public int getWeakness() {
		return weaknessStack;
	}

	public boolean isAlive() {
		return alive;
	}

	public boolean isBlocking() {
		return blocking;
	}

	public void nextSkill(Creature it) {
	}

	public void setAgony(int agony) {
		if (agony > this.agonyMaximum)
			this.agonyStack = this.agonyMaximum;
		else
			this.agonyStack = agony;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void setAttack(int attack) {
		this.attackCurrent = attack;
	}

	public void setBleed(int bleed) {
		if (bleed > bleedMaximum)
			this.bleedStack = bleedMaximum;
		else
			this.bleedStack = bleed;
	}

	public void setBlocking(boolean blocking) {
		if (blocking)
			this.defenseDefault += 10;
		else
			this.defenseDefault -= 10;
		this.blocking = blocking;
	}

	public void setCurse(int curse) {
		if (curse > curseMaximum)
			this.curseStack = curseMaximum;
		else
			this.curseStack = curse;
	}

	public void setDefense(int defense) {
		this.defenseCurrent = defense;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public void setHealth(int health) {
		if (health <= 0) {
			this.healthCurrent = 0;
			this.alive = false;
		} else if (health > healthMaximum)
			this.healthCurrent = healthMaximum;
		else
			this.healthCurrent = health;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setMana(int mana) {
		if (mana < 0)
			this.manaCurrent = 0;
		if (mana > manaMaximum)
			this.manaCurrent = manaMaximum;
		else
			this.manaCurrent = mana;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNativeAttack(int nativeAttack) {
		this.attackDefault = nativeAttack;
		this.attackCurrent = this.attackDefault;
	}

	public void setNativeDefense(int nativeDefense) {
		this.defenseDefault = nativeDefense;
		this.defenseCurrent = this.defenseDefault;
	}

	public void setNativeHealth(int nativeHealth) {
		this.healthMaximum = nativeHealth;
		this.healthCurrent = nativeHealth;
	}

	public void setNativeMana(int nativeMana) {
		this.manaMaximum = nativeMana;
		this.manaCurrent = nativeMana;
	}

	public void setPoison(int poison) {
		if (poison > poisonMaximum)
			this.poisonStack = poisonMaximum;
		else
			this.poisonStack = poison;
	}

	public void setRace(int race) {
		if (race == 1) {
			this.setRace("Human");
			this.setNativeHealth(this.getNativeHealth() + 20);
			this.setNativeMana(this.getNativeMana() + 20);
		} else if (race == 2) {
			this.setRace("Orc");
			this.setNativeAttack(10);
		} else if (race == 3) {
			this.setRace("Dwarf");
			this.setNativeDefense(10);
		} else {
			this.setRace("Elf");
			this.setNativeMana(this.getNativeMana() + 60);
		}
	}

	public void setRace(String race) {
		this.race = race;
	}

	public void setRegenHealth(int regenHealth) {
		this.healthRegen = regenHealth;
	}

	public void setRegrowth(int regrowth) {
		if (regrowth > this.regrowthMaximum) {
			this.regrowthStack = this.regrowthMaximum;
		} else {
			this.regrowthStack = regrowth;
		}
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}

	public void setSkillsArray(ArrayList<String> skillsArray) {
		this.skillsArray = skillsArray;
	}

	public void setSkillsInfo(ArrayList<String> skillsInfo) {
		this.skillsInfo = skillsInfo;
	}

	public void setSkillsMana(ArrayList<Integer> skillsMana) {
		this.skillsMana = skillsMana;
	}

	public void setStun(int stun) {
		if (stun >= 0)
			this.stunStack = stun;
	}

	public void setWeakness(int weakness) {
		if (weakness > this.weaknessMaximum) {
			this.weaknessStack = this.weaknessMaximum;
		} else {
			this.weaknessStack = weakness;
		}
	}

	public void getDrops(Creature creature) {
		this.gold += creature.gold;
		System.out.println("You got " + creature.gold + " gold coins.");
		this.experience += creature.experience;
		System.out.println("You got " + creature.experience + " experience points.");
	}

}

class KillCounter {
	// Implement this.
}