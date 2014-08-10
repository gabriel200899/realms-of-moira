package dungeon;

import creatures.foes.Bat;
import creatures.foes.Wolf;


final class Encounters {

    // A string with 78 '=', used as a separator.
    private static final String BLANK_LINE = "===============================================================================";
    private static final String ENCOUNTER_1_DIALOG = "You are in a dark cave.\nYou hear something flying in your direction.\nThe dim light that enters the cave reveals a bat.\nKill it to earn experience points and gold.";
    private static final String ENCOUNTER_2_DIALOG = "As you walk into the darkness you hear a wolf.\nIt starts to run in your direction.\nKill it to earn experience points and gold.";
    
    static void encounter1() {
        System.out.println(BLANK_LINE);
        System.out.println(ENCOUNTER_1_DIALOG);
        System.out.println(BLANK_LINE);
        DungeonEngine.inUse.add(new Bat(1));
        DungeonEngine.startBattle();
        System.out.println("You killed the bat. Good.");
    }

    static void encounter2() {
        System.out.println(BLANK_LINE);
        System.out.println(ENCOUNTER_2_DIALOG);
        System.out.println(BLANK_LINE);
        DungeonEngine.inUse.add(new Wolf(1));
        DungeonEngine.startBattle();
        System.out.println("You defeated the wolf. Great.");
    }
}
