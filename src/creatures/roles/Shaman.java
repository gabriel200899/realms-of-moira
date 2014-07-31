package creatures.roles;

import java.util.ArrayList;
import java.util.Collections;

import creatures.Creature;

public class Shaman extends Creature {

	public Shaman(int race) {
		setRole("Shaman");
		setNativeHealth(100);
		setNativeMana(200);
		setRace(race);
		ArrayList<String> skills = new ArrayList<String>();
		Collections.addAll(skills, 
				"1. [Attack]",
				"2. [Heal]",
				"3. [Regrowth]",
				"4. [Purify]",
				"5. [Poison]",
				"6. [Block]");
		ArrayList<String> skillsInfo = new ArrayList<String>();
		Collections.addAll(skillsInfo,
				"[15 DMG][-- MP]", 
				"[20 HP / 80 %][20 MP]",
				"[5 HoT / 80 %][Stack 4][20 MP]",
				"[Remove All Debuffs / 60 %][60 MP]",
				"[10 DoT / 60 %][Stack 2][20 MP]", 
				"[+10 Def][1 Turn]" );
		ArrayList<String> skillsArray = new ArrayList<String>();
		Collections.addAll(skillsArray,
				"attack", 
				"heal",
				"regrowth",
				"purify",
				"poison", 
				"block");
		ArrayList<Integer> skillsMana = new ArrayList<Integer>();
		Collections.addAll(skillsMana, 0, 20, 20, 60, 20, 0);
		setSkills(skills);
		setSkillsInfo(skillsInfo);
		setSkillsArray(skillsArray);
		setSkillsMana(skillsMana);
	}

	@Override
	public void skill1(Creature target) {
		if (this.evaluateHit(80)) {
			this.setMana(this.getMana() - this.getSkillsMana()[1]);
			this.setHealth(this.getHealth() + 20);
			System.out.println("Heal!");
		} else
			System.out.println("Miss!");
	}

	@Override
	public void skill2(Creature target) {
		if (this.evaluateHit(80)) {
			this.setMana(this.getMana() - this.getSkillsMana()[2]);
			this.setRegrowth(this.getRegrowth() + 1);
			System.out.println("Heal!");
		} else
			System.out.println("Miss!");
	}

	@Override
	public void skill3(Creature target) {
		if (this.evaluateHit(60)) {
			this.setMana(this.getMana() - this.getSkillsMana()[3]);
			this.setWeakness(0);
			this.setAgony(0);
			this.setBleed(0);
			this.setPoison(0);
			this.setCurse(0);
			System.out.println("Heal!");
		} else
			System.out.println("Miss!");
	}

	@Override
	public void skill4(Creature target) {
		if (this.evaluateHit(60)) {
			this.setMana(this.getMana() - this.getSkillsMana()[4]);
			target.setPoison(target.getPoison() + 1);
			System.out.println("Hit!");
		} else
			System.out.println("Miss!");
	}

}
