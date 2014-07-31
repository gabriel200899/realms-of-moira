package creatures.foes;

import creatures.Creature;

public class Bat extends Creature {

	public Bat(int level) {
		setRole("Bat");
		setRace("Monster");
		setLevel(level);
		setNativeHealth(20 + 10 * level);
		setNativeMana(40 + 10 * level);
		setGold(10 + 10 * level);
		setExperience(30 + 10 * level);
	}

	@Override
	public void skill1(Creature target) {
		if (this.evaluateHit(80)) {
			this.setMana(this.getMana() - 20);
			int damage = 20 + this.getAttack() - target.getDefense();
			if (damage > 0) {
				target.setHealth(target.getHealth() - damage);
			}
			System.out.println("Bat bit you.");
		} else {
			System.out.println("Bat tried to bite you but it missed.");
		}
	}

	@Override
	public void skill2(Creature target) {
		if (this.evaluateHit(80)) {
			int damage = 10 + this.getAttack() - target.getDefense();
			if (damage > 0) {
				target.setHealth(target.getHealth() - damage);
			}
			System.out.println("Bat scratched you.");
		} else {
			System.out.println("Bat tried to scratch you but it missed.");
		}
	}

	@Override
	public void nextSkill(Creature target) {
		if (this.getMana() >= 20) {
			skill1(target);
		} else {
			skill2(target);
		}
	}

}
