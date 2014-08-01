package dungeon;

import java.util.ArrayList;

import core.Data;
import creatures.Creature;
import creatures.roles.Mage;
import creatures.roles.Priest;
import creatures.roles.Rogue;
import creatures.roles.Shaman;

public class DungeonEngine {

	static int[] playerSelection;
	static ArrayList<Creature> inUse = new ArrayList<Creature>();

	public static void start() {
		create();
		build(playerSelection);
		startPlot();
	}

	private static void create() {
		System.out.println("Give your hero a name.");
		Data.getPlayerName("Name: ");
		int heroRole = Data.getPlayerRole("Select a class.");
		int heroRace = Data.getPlayerRace("Select a race.");
		playerSelection = new int[] { heroRole, heroRace };
	}

	private static void build(int[] selected) {
		if (selected[0] == 1)
			inUse.add(new Mage(selected[1]));
		if (selected[0] == 2)
			inUse.add(new Rogue(selected[1]));
		if (selected[0] == 3)
			inUse.add(new Shaman(selected[1]));
		if (selected[0] == 4)
			inUse.add(new Priest(selected[1]));
	}

	// TODO: make an actual plot.
	private static void startPlot() {
		for (int n = 0; n < 100; n++) {
			Encounters.encounter1();
			Encounters.encounter2();
		}
		inUse.remove(0);
	}

	static void startBattle() {
		while (inUse.get(0).isAlive() && inUse.get(1).isAlive()) {
			playerTurn();
			if (inUse.get(0).isAlive() && inUse.get(1).isAlive()) {
				computerTurn();
			}
		}
		endBattle();
	}

	private static void playerTurn() {
		if (inUse.get(0).isBlocking()) {
			inUse.get(0).setBlocking(false);
			inUse.get(0).evaluateDefense();
		}
		Data.refresh(inUse);
		if (inUse.get(0).getStun() == 0) {
			System.out.println("Your turn.");
			Data.printArray(inUse.get(0).getSkills(), inUse.get(0).getSkillsInfo());
			int skill = -1;
			while (skill == -1) {
				System.out.print("Skill: ");
				skill = Data.getInput(6, inUse.get(0).getSkillsArray(), inUse.get(0));
				if (inUse.get(0).getSkillsMana()[skill - 1] <= inUse.get(0).getMana())
					break;
				else
					System.out.println("Not enough mana.");
			}
			if (skill == 1)
				inUse.get(0).attack(inUse.get(1));
			else if (skill == 2)
				inUse.get(0).skill1(inUse.get(1));
			else if (skill == 3)
				inUse.get(0).skill2(inUse.get(1));
			else if (skill == 4)
				inUse.get(0).skill3(inUse.get(1));
			else if (skill == 5)
				inUse.get(0).skill4(inUse.get(1));
			else if (skill == 6)
				inUse.get(0).skill5(inUse.get(1));
			else if (skill == 7)
				inUse.get(0).skill6(inUse.get(1));
			else
				inUse.get(0).block();
		}
		endTurn(inUse.get(0));
	}

	private static void computerTurn() {
		if (inUse.get(1).getStun() == 0) {
			inUse.get(1).nextSkill(inUse.get(0));
		}
		endTurn(inUse.get(1));
	}

	private static void endTurn(Creature creature) {
		if (inUse.get(0).isAlive()) {
			creature.evaluateHealth();
			creature.evaluateMana();
		}
		for (Creature it : inUse) {
			it.evaluateAttack();
			it.evaluateDefense();
		}
	}

	private static void endBattle() {
		inUse.get(0).getDrops(inUse.get(1));
		inUse.get(0).addKill(inUse.get(1).getRole());
		inUse.get(0).evaluateLevel();
		inUse.remove(1);
	}

}
