package core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import creatures.Creature;
import duel.DuelEngine;
import dungeon.DungeonEngine;

public class Data {

	// Stores the SimpleDateFormat used when printing the time.
	private final static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS dd/MM/yyyy");

	// TODO: make this a single string. Faster is better.
	public static String info[] = {
		"                Realms of Moira",
		"Authors:        Bernardo Sulzbach",
		"Source Code:    mafagafogigante/realms-of-moira",
		"Contact:        mafagafogigante@gmail.com"};
	
	static Scanner input = new Scanner(System.in);
	public static String[] availableClasses = { "1. [Mage]", "2. [Rogue]",
			"3. [Shaman]", "4. [Priest]" };
	public static String[] availableClassesInfo = { "[Damage Dealer]",
			"[Damage Dealer]", "[Healer]", "[Healer]" };
	public static String[] availableClassesArray = { "mage", "rogue", "shaman",
			"priest" };
	public static String[] availableRaces = { "1. [Human]", "2. [Orc]",
			"3. [Dwarf]", "4. [Elf]" };
	public static String[] availableRacesInfo = { "[Balanced]", "[Offensive]",
			"[Defensive]", "[Healer]" };
	public static String[] availableRacesArray = { "human", "orc", "dwarf",
			"elf" };

	public static void info() {
		for (String string : info) System.out.println(string);
	}

	public static void start() {
		System.out.println("Main menu");
		System.out.println("[1] Duel");
		System.out.println("[2] Dungeon Crawl");
		System.out.println("[3] Exit");
		System.out.print("Input: ");
		String[] array = { "duel", "dungeon", "quit" };
		int givenInt = getInput(3, array);
		if (givenInt == 1)
			DuelEngine.start();
		else if (givenInt == 2)
			DungeonEngine.start();
		else
			System.exit(0);
	}

	public static void printArray(String[] left, String[] right) {
		for (int i = 0; i < left.length; i++) {
			System.out.print(left[i]);
			for (int n = 0; n < 79 - left[i].length() - right[i].length(); n++)
				System.out.print(".");
			System.out.println(right[i]);
		}
	}

	public static int getInput(int max, String[] array) {
		while (true) {
			if (input.hasNextLine()) {
				if (input.hasNextInt()) {
					int givenInt = input.nextInt();
					if (givenInt > 0 && givenInt <= max)
						return givenInt;
				} else if (input.hasNext()) {
					String givenString = input.next().toLowerCase();
					givenString = givenString.replaceAll("\\s", "").replaceAll("\\W", "");
					// Checks if the user issued a valid command.
					if (commandCheck(givenString)) {
						// We do not say that we have an invalid input.
						System.out.print("Input: ");
						input.nextLine();
						continue;
					}
					for (int i = 0; i < array.length; i++) {
						if (array[i].equals(givenString))
							return (i + 1);
					}
				}
			}
			System.out.print("Invalid input. Try again.\nInput: ");
			input.nextLine();
		}
	}

	public static String getPlayerName(String question) {
		while (true) {
			System.out.print(question);
			if (input.hasNext()) {
				String givenString = input.next();
				// Checks if the user issued a valid command.
				if (commandCheck(givenString))
					continue;
				if (givenString.length() > 4)
					return givenString;
				else
					System.out.println("Name must be at least five characters long.");
			} else {
				System.out.println("Invalid input. Try again.");
			}
		}
	}

	public static int getPlayerRole(String question) {
		System.out.println(question);
		Data.printArray(Data.availableClasses, Data.availableClassesInfo);
		System.out.print("Input: ");
		return Data.getInput(4, Data.availableClassesArray);
	}

	public static int getPlayerRace(String question) {
		System.out.println(question);
		Data.printArray(Data.availableRaces, Data.availableRacesInfo);
		System.out.print("Input: ");
		return Data.getInput(4, Data.availableRacesArray);
	}

	public static void refresh(ArrayList<Creature> inUse) {
		System.out.println();
		System.out.printf("\t[1][%s][%s]", inUse.get(0).getRole(), inUse.get(0)
				.getRace());
		for (int n = 0; n < 25 - inUse.get(0).getRole().length()
				- inUse.get(0).getRace().length(); n++)
			System.out.print(" ");
		System.out.printf("[2][%s][%s]\n\n", inUse.get(1).getRole(),
				inUse.get(1).getRace());

		System.out.print("\t[GENERAL]                       [GENERAL]\n");

		System.out.printf("\tHealth:      %d", inUse.get(0).getHealth());
		for (int n = 0; n < 19
				- String.valueOf(inUse.get(0).getHealth()).length()
				- String.valueOf(inUse.get(1).getHealth()).length(); n++)
			System.out.print(" ");
		System.out.printf("\tHealth:      %d\n", inUse.get(1).getHealth());

		System.out.printf("\tMana:        %d", inUse.get(0).getMana());
		for (int n = 0; n < 19
				- String.valueOf(inUse.get(0).getMana()).length()
				- String.valueOf(inUse.get(1).getMana()).length(); n++)
			System.out.print(" ");
		System.out.printf("\tMana:        %d\n", inUse.get(1).getMana());

		System.out.printf("\tAttack:      %d", inUse.get(0).getAttack());
		for (int n = 0; n < 19
				- String.valueOf(inUse.get(0).getAttack()).length()
				- String.valueOf(inUse.get(1).getAttack()).length(); n++)
			System.out.print(" ");
		System.out.printf("\tAttack:      %d\n", inUse.get(1).getAttack());

		System.out.printf("\tDefense:     %d", inUse.get(0).getDefense());
		for (int n = 0; n < 19
				- String.valueOf(inUse.get(0).getDefense()).length()
				- String.valueOf(inUse.get(1).getDefense()).length(); n++)
			System.out.print(" ");
		System.out.printf("\tDefense:     %d\n", inUse.get(1).getDefense());

		System.out.printf("\tStun:        %d", inUse.get(0).getStun());
		for (int n = 0; n < 19
				- String.valueOf(inUse.get(0).getStun()).length()
				- String.valueOf(inUse.get(1).getStun()).length(); n++)
			System.out.print(" ");
		System.out.printf("\tStun:        %d\n\n", inUse.get(1).getStun());

		System.out.print("\t[STACKS]                        [STACKS]\n");

		System.out.printf("\tRegrowth:    %d", inUse.get(0).getRegrowth());
		for (int n = 0; n < 19
				- String.valueOf(inUse.get(0).getRegrowth()).length()
				- String.valueOf(inUse.get(1).getRegrowth()).length(); n++)
			System.out.print(" ");
		System.out.printf("\tRegrowth:    %d\n", inUse.get(1).getRegrowth());

		System.out.printf("\tWeakness:    %d", inUse.get(0).getWeakness());
		for (int n = 0; n < 19
				- String.valueOf(inUse.get(0).getWeakness()).length()
				- String.valueOf(inUse.get(1).getWeakness()).length(); n++)
			System.out.print(" ");
		System.out.printf("\tWeakness:    %d\n", inUse.get(1).getWeakness());

		System.out.printf("\tAgony:       %d", inUse.get(0).getAgony());
		for (int n = 0; n < 19
				- String.valueOf(inUse.get(0).getAgony()).length()
				- String.valueOf(inUse.get(1).getAgony()).length(); n++)
			System.out.print(" ");
		System.out.printf("\tAgony:       %d\n", inUse.get(1).getAgony());

		System.out.printf("\tBleed:       %d", inUse.get(0).getBleed());
		for (int n = 0; n < 19
				- String.valueOf(inUse.get(0).getBleed()).length()
				- String.valueOf(inUse.get(1).getBleed()).length(); n++)
			System.out.print(" ");
		System.out.printf("\tBleed:       %d\n", inUse.get(1).getBleed());

		System.out.printf("\tPoison:      %d", inUse.get(0).getPoison());
		for (int n = 0; n < 19
				- String.valueOf(inUse.get(0).getPoison()).length()
				- String.valueOf(inUse.get(1).getPoison()).length(); n++)
			System.out.print(" ");
		System.out.printf("\tPoison:      %d\n", inUse.get(1).getPoison());

		System.out.printf("\tCurse:       %d", inUse.get(0).getCurse());
		for (int n = 0; n < 19
				- String.valueOf(inUse.get(0).getCurse()).length()
				- String.valueOf(inUse.get(1).getCurse()).length(); n++)
			System.out.print(" ");
		System.out.printf("\tCurse:       %d\n\n", inUse.get(1).getCurse());
	}

	private static boolean commandCheck(String givenString) {
		String string = givenString.replaceAll("\\s", "").replaceAll("\\W", "");
		// "exit" - exits the application
		// "quit" - exits the application
		if (string.equals("exit") || string.equals("quit")) {
			System.exit(0);
			return false;
		}
		// "time" - prints the current time
		else if (string.equals("time")) {
			System.out.println(dateFormat.format(new Date()));
			return true;
		}
		else {
			return false;
		}
	}
}
