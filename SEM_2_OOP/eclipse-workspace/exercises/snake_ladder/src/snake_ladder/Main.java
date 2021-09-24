/*
Ananto Joyoadikusumo
2301914434
*/

package snake_ladder;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public Main(){
		int menu = 0;
		do{
			menu = getMenu();
			if (menu == 1){
				gameLoop(2);
			}
			else if (menu == 2){
				gameLoop(3);
			}
			else if (menu == 3){
				break;
			}
		} while (menu != 3);
	}

	public void gameLoop(int playerNumber){
		ArrayList<Player> playerList = new ArrayList<Player>();
		for (int i = 0; i < playerNumber; i++){
			Player newPlayer = new Player();
			playerList.add(newPlayer);
		}

		int round = 1;
		boolean isWon = false;

		while(true){
			if (isWon || round == 26){
				break;
			}
			int playernum = 1;
			for (Player player : playerList) {
				if (isWon){
					break;
				}
				int dice = getDiceNumber(round, playernum);
				player.insertDice(dice);
				playernum++;
				isWon = player.update();
			}
			if (isWon){
				break;
			}
			printTable(playerList, round);
			round++;
		}
		printWinner(playerList);
		displayScoreboard(playerList);
	}

	public void cls(){
		for(int i = 0; i < 10; i++){
			System.out.println("");
		}
	}

	public void printWinner(ArrayList<Player> playerList){
		Player player = new Player();
		for (int i = 0; i < playerList.size(); i++){
			if (i == 0){
				player = playerList.get(i);
				continue;
			}
			Player player2 = playerList.get(i);
			if (player.getNewStep(player.getNewListSize()-1) < player2.getNewStep(player2.getNewListSize()-1)){
				player = player2;
			}
		}
		int index = playerList.indexOf(player); 
		System.out.println("Player " + (char)(index+65) + " is the Winner!!! ");
		System.out.println("");
	}

	public void displayScoreboard(ArrayList<Player> playerList){
		System.out.println("SCOREBOARD");
		System.out.println("==========");
		for (int i = 0; i < playerList.size(); i++){
			Player player = new Player();
			for (int j = 0; j < playerList.size(); j++){
				if (j == 0){
					player = playerList.get(j);
					continue;
				}
				Player player2 = playerList.get(j);
				if (player.getNewStep(player.getNewListSize()-1) < player2.getNewStep(player2.getNewListSize()-1)){
					player = player2;
				}
			}
			int index = playerList.indexOf(player); 
			System.out.print((i+1) + ". Player " + (char)(index+65));
			System.out.println(" - " + player.getNewStep(player.getNewListSize()-1));
			player.destroy();
		}
		System.out.println("");
		System.out.println("Press Enter to go back to main menu...");
		scan.nextLine();
	}
	
	public void printTable(ArrayList<Player> playerList, int round){
		System.out.println("|=======|==========================|==========================|==========================|");
		System.out.print("|       ");
		for (int i = 0; i < 3; i++){
			System.out.printf("| %-24s ", "Player " + (char)(i+65));
		}
		System.out.println("|");
		System.out.print("| ROUND ");
		System.out.println("|==========================|==========================|==========================|");
		System.out.printf("| %5s ", "");
		for (int i = 0; i < 3; i++){
			System.out.printf("| %-6s | %-6s | %-6s ", "Old", "Dice", "New");
		}
		System.out.println("|");
		System.out.println("|=======|==========================|==========================|==========================|");
		for(int i = 0; i < round; i++){
			System.out.printf("| %-5d ", i+1);
			for (int j = 0; j < playerList.size(); j++){
				Player player = playerList.get(j);
				System.out.printf("| %-6d | %-6d | %-6d ", player.getOldStep(i), player.getDice(i), player.getNewStep(i));
			}
			if (playerList.size() == 2){
				System.out.printf("| %-6s | %-6s | %-6s ", "", "", "");
			}
			System.out.println("|");
			System.out.println("|=======|==========================|==========================|==========================|");
		}
	}

	public int getDiceNumber(int round, int playernum){
		System.out.println("+-+-+-+ ROUND " + round + " +-+-+-+");
		int i = playernum+64;
		System.out.println("Player " + (char)(i) + " roll dice!");
		System.out.println("Press Enter to roll dice!");
		scan.nextLine();
		Random rand = new Random();
		int dice = rand.nextInt(6) + 1;
		System.out.println("Player " + (char)(i) + " got " + dice);
		System.out.println("Press Enter to continue!");
		scan.nextLine();
		return dice;
	}

	public int getMenu(){
		cls();
		System.out.println("Snake and Ladders");
		System.out.println("=================");
		System.out.println("1. 2 Players");
		System.out.println("2. 3 Players");
		System.out.println("3. Exit");
		int menu = 0;
		do{
			try {
				System.out.print(">> ");
				menu = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
				//TODO: handle exception
			}
		}while(menu < 1 || menu > 3);
		return menu;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
