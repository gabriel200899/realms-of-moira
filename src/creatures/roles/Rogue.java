package creatures.roles;

import java.util.ArrayList;
import java.util.Collections;

import creatures.Creature;

public class Rogue extends Creature {

	public Rogue(int race) {
		setRole("Rogue");
		setNativeHealth(150);
		setNativeMana(150);
		setRace(race);
		ArrayList<String> skills = new ArrayList<String>();
		Collections.addAll(skills, 
				"1. [Attack]",
				"2. [Stab]",
				"3. [Backstab]",
				"4. [Sap]",
				"5. [Bleed]",
				"6. [Block]");
		ArrayList<String> skillsInfo = new ArrayList<String>();
		Collections.addAll(skillsInfo,
				"[15 DMG][-- MP]",
				"[20 DMG / 80 %][20 MP]",
				"[40 DMG / 60 %][60 MP]",
				"[2 Stun / 60 %][40 MP]",
				"[10 DoT / 40 %][Stack 2][40 MP]",
				"[+10 Def][1 Turn][-- MP]" );
		ArrayList<String> skillsArray = new ArrayList<String>();
		Collections.addAll(skillsArray,
				"attack",
				"stab",
				"backstab",
				"sap",
				"bleed",
				"block");
		ArrayList<Integer> skillsMana = new ArrayList<Integer>();
		Collections.addAll(skillsMana, 0, 20, 60, 40, 40, 0);
		setSkills(skills);
		setSkillsInfo(skillsInfo);
		setSkillsArray(skillsArray);
		setSkillsMana(skillsMana);
	}

	@Override
	public void skill1(Creature target) {
		if (this.evaluateHit(80)) {
			int damage = 20 + this.getAttack() - target.getDefense();
			if (damage < 0)
				damage = 0;
			target.setHealth(target.getHealth() - damage);
            this.setMana(this.getMana() - this.getSkillsMana()[1]);
			System.out.println("Hit!");
		} else
			System.out.println("Miss!");
	}

	@Override
	public void skill2(Creature target) {
		if (this.evaluateHit(60)) {
			int damage = 40 + this.getAttack() - target.getDefense();
			if (damage < 0)
				damage = 0;
			target.setHealth(target.getHealth() - damage);
            this.setMana(this.getMana() - this.getSkillsMana()[2]);
			System.out.println("Hit!");
		} else
			System.out.println("Miss!");
	}

	@Override
	public void skill3(Creature target) {
		if (this.evaluateHit(60)) {
			target.setStun(target.getStun() + 2);
            this.setMana(this.getMana() - this.getSkillsMana()[3]);
			System.out.println("Hit!");
		} else
			System.out.println("Miss!");
	}

	@Override
	public void skill4(Creature target) {
		if (this.evaluateHit(40)) {
			target.setBleed(target.getBleed() + 1);
            this.setMana(this.getMana() - this.getSkillsMana()[4]);
			System.out.println("Hit!");
		} else
			System.out.println("Miss!");
	}

}
