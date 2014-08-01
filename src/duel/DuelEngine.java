package duel;

import java.util.ArrayList;

import core.Data;
import creatures.Creature;
import creatures.roles.Mage;
import creatures.roles.Priest;
import creatures.roles.Rogue;
import creatures.roles.Shaman;

public class DuelEngine {

	public static ArrayList<Creature> inUse = new ArrayList<Creature>();

	public static void build(int[][] selected) {
		for (int i = 0; i < selected.length; i++) {
			if (selected[i][0] == 1)
				inUse.add(new Mage(selected[i][1]));
			else if (selected[i][0] == 2)
				inUse.add(new Rogue(selected[i][1]));
			else if (selected[i][0] == 3)
				inUse.add(new Shaman(selected[i][1]));
			else
				inUse.add(i, new Priest(selected[i][1]));
		}
	}

	public static void create() {

		int firstRole = Data.getPlayerRole("Select the first character's class:");

		System.out.println("Select first character's race:");
		Data.printArray(Data.availableRaces, Data.availableRacesInfo);
		System.out.print("Input: ");
		int firstRace = Data.getInput(4, Data.availableRacesArray, null);

		int secondRole = Data.getPlayerRole("Select the second character's class:");

		System.out.println("Select second character's race:");
		Data.printArray(Data.availableRaces, Data.availableRacesInfo);
		System.out.print("Input: ");
		int secondRace = Data.getInput(4, Data.availableRacesArray, null);

		int[] firstCharacter = { firstRole, firstRace };
		int[] secondCharacter = { secondRole, secondRace };
		int[][] allCharacters = { firstCharacter, secondCharacter };
		build(allCharacters);
	}

	public static void endGame() {
		if (inUse.get(0).isAlive()) {
			System.out.printf("%s is dead! %s wins!\n", inUse.get(1).getRole(),	inUse.get(0).getRole());
			inUse.get(0).addKill(inUse.get(1).getRole());
			inUse.get(0).evaluateLevel();
		} else {
			System.out.printf("%s is dead! %s wins!\n", inUse.get(0).getRole(), inUse.get(1).getRole());
			inUse.get(0).addKill(inUse.get(1).getRole());
			inUse.get(1).evaluateLevel();
		}
	}

	private static void endTurn(Creature creature) {
		if (creature.isAlive()) {
			creature.evaluateHealth();
			creature.evaluateMana();
			creature.setStun(creature.getStun() - 1);
		}
		for (Creature player : inUse) {
			player.evaluateAttack();
			player.evaluateDefense();
		}
	}

	public static void start() {
		create();
		startGame();
		inUse.clear();
	}

	public static void startGame() {
		while (inUse.get(0).isAlive() && inUse.get(1).isAlive()) {
			startTurn(inUse.get(0));
			if (inUse.get(0).isAlive() && inUse.get(1).isAlive()) {
				startTurn(inUse.get(1));
			}
		}
		endGame();
	}

	public static void startTurn(Creature player) {
		if (player.isBlocking()) {
			player.setBlocking(false);
			player.evaluateDefense();
		}
		Data.refresh(inUse);
		if (player.getStun() == 0) {
			int enemy;
			if (inUse.indexOf(player) == 0)
				enemy = 1;
			else
				enemy = 0;
			System.out.println(player.getRole() + " playing.");
			Data.printArray(player.getSkills(), player.getSkillsInfo());
			int skill = -1;
			while (skill == -1) {
				System.out.print("Skill: ");
				skill = Data.getInput(6, player.getSkillsArray(), player);
				if (player.getSkillsMana()[skill - 1] <= player.getMana())
					break;
				else
					System.out.println("Not enough mana.");
			}
			if (skill == 1)
				player.attack(inUse.get(enemy));
			else if (skill == 2)
				player.skill1(inUse.get(enemy));
			else if (skill == 3)
				player.skill2(inUse.get(enemy));
			else if (skill == 4)
				player.skill3(inUse.get(enemy));
			else if (skill == 5)
				player.skill4(inUse.get(enemy));
			else
				player.block();
		}
		endTurn(player);
	}
}