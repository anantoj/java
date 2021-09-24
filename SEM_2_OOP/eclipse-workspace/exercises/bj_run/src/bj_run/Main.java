package bj_run;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Main {
	static Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	ArrayList<Runner> arr = new ArrayList<>();

	int hareCount = 0;
	int turtleCount = 0;

	public Main() {
		int menu = 0;
		do {
			menu = getMenu();
			switch (menu) {
				case 1:
					addRunner();
					break;
				case 2:
					joinRun();
					break;
				case 3:
					viewStanding();
					break;
				default:
					break;
			}
		} while (menu != 4);
	}

	public void addRunner() {
		String type = "";
		do {
			System.out.print("Which animal will you rooting for [hare | turtle]? ");
			type = scan.nextLine();
		} while (!type.equals("hare") && !type.equals("turtle"));
		String name = "";
		do {
			System.out.print("What's the name [5 - 15 characters]? ");
			name = scan.nextLine();
		} while (name.length() < 5 || name.length() > 15);
		if (type.equals("hare")) {
			int runSpeed = rand.nextInt(50) + 25;
			Hare h = new Hare(name, runSpeed);
			arr.add(h);
		}
		else{
			int runSpeed = rand.nextInt(50) + 25;
			Turtle t = new Turtle(name, runSpeed);
			arr.add(t);
		}
		System.out.println("Another runner has joined the race!!");
		return;
	}

	public void joinRun() {
		if (arr.isEmpty()) {
			System.out.println("There are currently no runners..");
			return;
		}

		ArrayList<Runner> standings = arr;

		for (Runner runner : standings) {
			runner.setDistance(0);
		}

		int d = rand.nextInt(3);
		int totalDistance = 0;
		if (d == 0) { 
			totalDistance = 150;
		}
		else if (d == 1) {
			totalDistance = 250;
		}
		else {
			totalDistance = 500;
		}

		while (standings.get(0).getDistance() < totalDistance) {
			System.out.println("Generating data statistics.");
			System.out.println("Generating data statistics..");
			System.out.println("Generating data statistics...");
			System.out.println("");

			for (Runner runner : standings) {
				runner.move();
			}

			Collections.sort(standings, new Comparator<Runner>() {
				@Override
				public int compare(Runner o1, Runner o2) {
					return o2.getDistance() - o1.getDistance();
				}
			});

			printLeaderBoard(standings, totalDistance);
			
			if (standings.get(0).getDistance() < totalDistance){
				System.out.println("Press Enter to continue the run");
				scan.nextLine();
			}
		}
		if (standings.get(0) instanceof Hare){
			hareCount++;
		}
		else{
			turtleCount++;
		}
		System.out.println(standings.get(0).getName() + " Wins The Race!!!");
		System.out.println("");
		return;
	}
	
	public void printLeaderBoard(ArrayList<Runner> standings, int totalDistance) {
		System.out.println("+============================================+");
		System.out.printf("+Current Standing                         %d+\n", totalDistance);
		System.out.println("+============================================+");
		System.out.printf("+ %-3s | %-15s | %-7s | %-8s +\n", "No.", "Name", "Type", "Distance");
		System.out.println("+============================================+");
		int index = 1;
		for (Runner runner : standings) {
			String type = "";
			if (runner instanceof Hare) {
				type = "Hare";
			}
			else {
				type = "Turtle";
			}
			System.out.printf("+ %-3d | %-15s | %-7s | %-8s +\n", index, runner.getName(), type, runner.getDistance());
			index++;		
		}
		System.out.println("+============================================+");
	}

	public void viewStanding() {
		if (hareCount > turtleCount){
			System.out.println(" ___   ___  _______  _____    ________   __      ________  _______  _____   ______");
			System.out.println("|   | |   ||   _   ||   _ |  |        | |  |    |        ||   _   ||     | |      |");
			System.out.println("|   |_|   ||  |_|  ||  | ||  |   _____| |  |    |   _____||  |_|  ||  _   ||  ____|");
			System.out.println("|         ||       ||  |_||_ |  |_____  |  |    |  |_____ |       || | |  || |____");
			System.out.println("|         ||       ||    _  ||   _____| |  |___ |   _____||       || |_|  ||____  |");
			System.out.println("|    _    ||   _   ||   | | ||  |_____  |      ||  |_____ |   _   ||      | ____| |");
			System.out.println("|___| |___||__| |__||___| |_||________| |______||________||__| |__||_____| |______|");
		}
		else if (hareCount < turtleCount) {
			System.out.println(" ______  __   __  _____    ______  __      ________   __      ________  _______  _____   ______ ");
			System.out.println("|      ||  | |  ||   _ |  |      ||  |    |        | |  |    |        ||   _   ||     | |      |");
			System.out.println("|_    _||  | |  ||  | ||  |_    _||  |    |   _____| |  |    |   _____||  |_|  ||  _   ||  ____|");
			System.out.println("  |  |  |  |_|  ||  |_||_   |  |  |  |    |  |_____  |  |    |  |_____ |       || | |  || |____ ");
			System.out.println("  |  |  |       ||    _  |  |  |  |  |___ |   _____| |  |___ |   _____||       || |_|  ||____  |");
			System.out.println("  |  |  |       ||   | | |  |  |  |      ||  |_____  |      ||  |_____ |   _   ||      | ____| |");
			System.out.println("  |__|  |_______||___| |_|  |__|  |______||________| |______||________||__| |__||_____| |______|");
		}
		else {
			System.out.println(" _______   _______    _______  _     _ ");
			System.out.println("|       | |    __ |  |   _   || | _ | | ");
			System.out.println("|   _    ||   |  ||  |  |_|  || || || | ");
			System.out.println("|  | |   ||   |__||_ |       ||       | ");
			System.out.println("|  |_|   ||    __   ||       ||       |");
			System.out.println("|        ||   |  |  ||   _   ||   _   |");
			System.out.println("|_______| |___|  |__||__| |__||__| |__|");
		}
		System.out.println("+===========================================+");
		System.out.println("+        Hare         |       Turtle        +");
		System.out.println("+===========================================+");
		System.out.printf ("+ %-20d| %-20d+\n", hareCount, turtleCount);
		System.out.println("+===========================================+");
	}

	public int getMenu(){
		System.out.println(" ______     __          _____    __   __  __    _");
		System.out.println("|  _   |   |  |        |   _ |  |  | |  ||  |  | |");
		System.out.println("| |_|  |   |  |  ___   |  | ||  |  | |  ||   |_| |");
		System.out.println("|      |   |  | |___|  |  |_||_ |  |_|  ||       |");
		System.out.println("|  _  |  __|  |        |    _  ||       ||  _    |");
		System.out.println("| |_|  ||     |        |   | | ||       || | |   |");
		System.out.println("|______||_____|        |___| |_||_______||_|  |__|");
		System.out.println("");
		System.out.println("+=======================+");
		System.out.println("+ Menu List~            +");
		System.out.println("+=======================+");
		System.out.println("+ 1. Add Runner         +");
		System.out.println("+ 2. Join Run           +");
		System.out.println("+ 3. View Standing      +");
		System.out.println("+ 4. Close Program      +");
		System.out.println("+=======================+");
		int menu = 0;

		do {
			try {
				System.out.print("Choice >> ");
				menu = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
				//TODO: handle exception
			}
		} while (menu < 1 || menu > 4);
		return menu;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
