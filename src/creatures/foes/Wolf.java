package creatures.foes;

import creatures.Creature;

public class Wolf extends Creature {

	public Wolf(int level) {
		setRole("Wolf");
		setRace("Monster");
		setLevel(level);
		setNativeHealth(40 + 10 * level);
		setNativeMana(60 + 10 * level);
		setGold(20 + 20 * level);
		setExperience(40 + 20 * level);
	}

	@Override
	public void skill1(Creature target) {
		if (this.evaluateHit(80)) {
			this.setMana(this.getMana() - 30);
			int damage = 40 + this.getAttack() - target.getDefense();
			if (damage > 0) {
				target.setHealth(target.getHealth() - damage);
			}
			System.out.println("Wolf bit you.");
		} else {
			System.out.println("Wolf tried to bite you but it missed.");
		}
	}

	@Override
	public void skill2(Creature target) {
		if (this.evaluateHit(80)) {
			int damage = 10 + this.getAttack() - target.getDefense();
			if (damage > 0) {
				target.setHealth(target.getHealth() - damage);
			}
			System.out.println("Wolf scratched you.");
		} else {
			System.out.println("Wolf tried to scratch you but it missed.");
		}
	}

	@Override
	public void nextSkill(Creature target) {
		if (this.getMana() >= 30) {
			skill1(target);
		} else {
			skill2(target);
		}
	}

}
