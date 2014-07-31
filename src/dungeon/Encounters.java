package dungeon;

import creatures.foes.Bat;
import creatures.foes.Wolf;

final class Encounters {

	static void line() {
		for (int i = 0; i < 79; i++) {
			System.out.print("=");
		}
		System.out.println();
	}

	static void encounter1() {
		line();
		System.out.println("You arrived a dark cave.");
		System.out.println("You hear something flying in your direction.");
		System.out.println("The dim light that enters the cave reveals a bat.");
		System.out.println("Kill it to earn experience points and gold.");
		line();
		DungeonEngine.inUse.add(new Bat(1));
		DungeonEngine.startBattle();
		System.out.println("You defeated the bat. Good.");
	}

	static void encounter2() {
		line();
		System.out.println("As you walk into the darkness you hear a wolf.");
		System.out.println("It starts running in your direction.");
		System.out.println("Kill it to earn experience points and gold.");
		line();
		DungeonEngine.inUse.add(new Wolf(1));
		DungeonEngine.startBattle();
		System.out.println("You defeated the wolf. Good.");
	}
}
