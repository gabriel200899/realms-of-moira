package dungeon;

import creatures.foes.Bat;
import creatures.foes.Wolf;

// TODO: reduce the amount of print calls. This will make the code significantly faster.
// This applies to the whole project.

final class Encounters {

	// A string with 79 '=' used as a separator.
	static final String blankLine = "================================================================================";
	static final String encounter1Dialog = "You are in a dark cave.\n"
			+ "You hear something flying in your direction.\n"
			+ "The dim light that enters the cave reveals a bat.\n"
			+ "Kill it to earn experience points and gold.";
	// TODO: create encounter2dialog.
	
	static void encounter1() {
		System.out.println(blankLine);
//		System.out.println("You are in a dark cave.");
//		System.out.println("You hear something flying in your direction.");
//		System.out.println("The dim light that enters the cave reveals a bat.");
//		System.out.println("Kill it to earn experience points and gold.");
		System.out.println(encounter1Dialog);
		System.out.println(blankLine);
		DungeonEngine.inUse.add(new Bat(1));
		DungeonEngine.startBattle();
		System.out.println("strings.");
	}

	static void encounter2() {
		System.out.println(blankLine);
		System.out.println("As you walk into the darkness you hear a wolf.");
		System.out.println("It starts running in your direction.");
		System.out.println("Kill it to earn experience points and gold.");
		System.out.println(blankLine);
		DungeonEngine.inUse.add(new Wolf(1));
		DungeonEngine.startBattle();
		System.out.println("You defeated the wolf. Great.");
	}
}
