package creatures.roles;

import java.util.ArrayList;
import java.util.Collections;

import creatures.Creature;

public class Priest extends Creature {

	public Priest(int race) {
		setRole("Priest");
		setNativeHealth(100);
		setNativeMana(200);
		setRace(race);
		ArrayList<String> skills = new ArrayList<String>();
		Collections.addAll(skills, 
				"[1] [Attack]",
				"[2] [Lesser Heal]",
				"[3] [Greater Heal]",
				"[4] [Cleanse]",
				"[5] [Curse]",
				"[6] [Block]");
		ArrayList<String> skillsInfo = new ArrayList<String>();
		Collections.addAll(skillsInfo,
				"[15 DMG][-- MP][-- MP]",
				"[20 HP / 80 %][20 MP]", 
				"[60 HP / 40 %][60 MP]",
				"[Remove All Debuffs / 40 %][80 MP]",
				"[5 DoT / 80 %][Stack 4][20 MP]", 
				"[+10 Def][1 Turn][-- MP]");
		ArrayList<String> skillsArray = new ArrayList<String>();
		Collections.addAll(skillsArray,
				"attack", 
				"lesser", 
				"greater", 
				"cleanse",
				"curse", 
				"block");
		ArrayList<Integer> skillsMana = new ArrayList<Integer>();
		Collections.addAll(skillsMana, 0, 20, 60, 80, 20, 0);
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
			this.setHealth(this.getHealth() + 60);
			System.out.println("Heal!");
		} else
			System.out.println("Miss!");
	}

	@Override
	public void skill3(Creature target) {
		if (this.evaluateHit(40)) {
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
		if (this.evaluateHit(80)) {
			this.setMana(this.getMana() - this.getSkillsMana()[4]);
			target.setCurse(target.getCurse() + 1);
			System.out.println("Hit!");
		} else
			System.out.println("Miss!");
	}

}
