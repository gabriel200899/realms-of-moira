package creatures.roles;

import java.util.ArrayList;
import java.util.Collections;

import creatures.Creature;

public class Mage extends Creature {

	public Mage(int race) {
		setRole("Mage");
		setNativeHealth(150);
		setNativeMana(150);
		setRace(race);
		ArrayList<String> skills = new ArrayList<String>();
		Collections.addAll(skills, 
				"1. [Attack]",
				"2. [Fireball]",
				"3. [Fireblast]",
				"4. [Weakness]", 
				"5. [Agony]", 
				"6. [Block]");
		ArrayList<String> skillsInfo = new ArrayList<String>();
		Collections.addAll(skillsInfo,
				"[15 DMG][-- MP]", 
				"[20 DMG / 80 %][20 MP]",
				"[40 DMG / 60 %][60 MP]",
				"[-5 Att / -5 Def / 80 %][Stack 2][20 MP]",
				"[5 DoT / 80 %][Stack 4][20 MP]",
				"[+10 Def][1 Turn][-- MP]" );
		ArrayList<String> skillsArray = new ArrayList<String>();
		Collections.addAll(skillsArray,
				"attack", 
				"fireball", 
				"fireblast", 
				"weakness",
				"agony",  
				"block");
		ArrayList<Integer> skillsMana = new ArrayList<Integer>();
		Collections.addAll(skillsMana, 0, 20, 60, 20, 20, 0);
		setSkills(skills);
		setSkillsInfo(skillsInfo);
		setSkillsArray(skillsArray);
		setSkillsMana(skillsMana);
	}

	@Override
	public void skill1(Creature target) {
		if (this.evaluateHit(80)) {
            this.setMana(this.getMana() - this.getSkillsMana()[1]);
			target.instantDamage(20 + this.getAttack());
			System.out.println("Hit!");
		} else
			System.out.println("Miss!");
	}

	@Override
	public void skill2(Creature target) {
		if (this.evaluateHit(60)) {
            this.setMana(this.getMana() - this.getSkillsMana()[2]);
			target.instantDamage(40 + this.getAttack());
			System.out.println("Hit!");
		} else
			System.out.println("Miss!");
	}

	@Override
	public void skill3(Creature target) {
		if (this.evaluateHit(80)) {
            this.setMana(this.getMana() - this.getSkillsMana()[3]);
			target.setWeakness(target.getWeakness() + 1);
			System.out.println("Hit!");
		} else
			System.out.println("Miss!");
	}

	@Override
	public void skill4(Creature target) {
		if (this.evaluateHit(80)) {
            this.setMana(this.getMana() - this.getSkillsMana()[4]);
			target.setAgony(target.getAgony() + 1);
			System.out.println("Hit!");
		} else
			System.out.println("Miss!");
	}

}
