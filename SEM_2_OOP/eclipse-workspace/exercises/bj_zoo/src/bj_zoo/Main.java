package bj_zoo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	ArrayList<Animal> arr = new ArrayList<>();
	int maxCanine = 0;
	int maxFeline = 0;
	int currCanine = 0;
	int currFeline = 0;

	public Main() {
		// TODO Auto-generated constructor stub
		int menu = 0;
		do {
			updateMood();
			menu = getMenu();
			switch (menu) {
				case 1:
					add();
					break;
				case 2:
					view();
					break;
				case 3:
					walk();
					break;
				case 4:
					release();
					break;
				default:
					break;
			}
		} while (menu != 5);
	}
	
	public int getMenu(){
		System.out.println(" ______       ___            _______     ______     ______");
        System.out.println("/\\  == \\     /\\  \\          /\\___   \\   /\\  __ \\   /\\  __ \\");
        System.out.println("\\ \\  __<    _\\_\\  \\         \\/_/   /__  \\ \\ \\/\\ \\  \\ \\ \\/\\ \\");
        System.out.println(" \\ \\_____\\ /\\______\\          /\\______\\  \\ \\_____\\  \\ \\_____\\");
        System.out.println("  \\/_____/ \\/______/          \\/______/   \\/_____/   \\/_____/");
		System.out.println("+=======================+");
		System.out.println("Menu List               +");
		System.out.println("+=======================+");
		System.out.println("+ 1. Add Zoo Animal     +");
		System.out.println("+ 2. View Zoo Animal    +");
		System.out.println("+ 3. Take For A Walk    +");
		System.out.println("+ 4. Release Zoo Animal +");
		System.out.println("+ 5. Close Program      +");
		System.out.println("+=======================+");
		int menu = 0;
		do{
			try {
				System.out.print("Choice >> ");
				menu = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				//TODO: handle exception
				scan.nextLine();
			}
		}while (menu < 1 || menu > 5);
		return menu;
	}
	
	public void updateMood(){
		if (currCanine == 1){
			for (Animal animal : arr) {
				if (animal instanceof Canine){
					Canine canine = (Canine)animal;
					canine.setIsHappy(true);
				}
			}
		}
		else if (currCanine < maxCanine){
			for (Animal animal : arr) {
				if (animal instanceof Canine){
					Canine canine = (Canine)animal;
					canine.setIsHappy(true);
				}
			}
		}
		else{
			for (Animal animal : arr) {
				if (animal instanceof Canine){
					Canine canine = (Canine)animal;
					canine.setIsHappy(false);
				}
			}
		}
		if (currFeline == 1){
			for (Animal animal : arr) {
				if (animal instanceof Feline){
					Feline feline = (Feline)animal;
					feline.setIsHappy(false);
				}
			}
		}
		else if (currFeline < maxFeline){
			for (Animal animal : arr) {
				if (animal instanceof Feline){
					Feline feline = (Feline)animal;
					feline.setIsHappy(false);
				}
			}
		}
		else{
			for (Animal animal : arr) {
				if (animal instanceof Feline){
					Feline feline = (Feline)animal;
					feline.setIsHappy(true);
				}
			}
		}
	}

	public void add(){
		String name = "";
		do {
			System.out.print("Whaht's the name [5-15 characters]? ");
			name = scan.nextLine();
		} while (name.length() < 5 || name.length() > 15);
		String gender = "";
		do {
			System.out.print("what's its gender [male | female]? ");
			gender = scan.nextLine();
		} while (!gender.equals("male") && !gender.equals("female"));
		String genus = "";
		do {
			System.out.print("what's its genus [canine | feline]? ");
			genus = scan.nextLine();
		} while (!genus.equals("canine") && !genus.equals("feline"));
		if (genus.equals("canine")){
			int speed = 0;
			do {
				try {
					System.out.print("what's its speed [1 - 80]? ");
					speed = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					//TODO: handle exception
					scan.nextLine();
				}
				
			} while (speed < 1 || speed > 80);
			Canine c = new Canine(name, gender, speed);
			arr.add(c);

			currCanine++;
			if (currCanine > maxCanine){
				maxCanine = currCanine;
			}
		}
		else{
			Feline f = new Feline(name, gender);
			arr.add(f);

			currFeline++;
			if (currFeline > maxFeline){
				maxFeline = currFeline;
			}
		}
		System.out.println("Another animal has joined the zoo!!");
	}	

	public void view(){
		System.out.println("+========================================================+");
		System.out.printf("+ %-3s | %-15s | %-8s | %-10s | %-6s +\n", "No.","Name","Genus", "Mood", "Gender");
		System.out.println("+========================================================+");
		if (arr.isEmpty()){
			System.out.println("+ No Zoo Animal Spotted                                  +");
		}
		else{
			int num = 1;
			for (Animal animal : arr) {
				String genus = "";
				if (animal instanceof Canine){
					genus = "Canine";
				}
				else{
					genus = "Feline";
				}
				String mood = "";
				if (animal.getIsHappy()){
					mood = "happy";
				}
				else{
					mood = "unhappy";
				}
				System.out.printf("+ %-3d | %-15s | %-8s | %-10s | %-6s +\n", num, animal.getName(), genus, mood, animal.getGender());	
				num++;
			}
		}
		System.out.println("+========================================================+");
	}

	public void walk(){
		if (arr.isEmpty()){
			view();
		}
		else{
			int index = 0;
			do{
				try {
					view();
					System.out.printf("Choose animal to take for a stroll [1 - %d]: ", arr.size());
					index = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					//TODO: handle exception
					scan.nextLine();
				}
			}while (index < 1 || index > arr.size());
			int roamTime = -1;
			do {
				try {
					System.out.print("How much time do you let it roam?[0 - 50]: ");
					roamTime = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					//TODO: handle exception
					scan.nextLine();
				}
			} while (roamTime < 0 || roamTime > 50);

			if (roamTime == 0){
				roamTime = 60;
			}
			Animal animal = arr.get(index-1);
			if (animal instanceof Feline){
				int bool = rand.nextInt(2);
				if (bool == 0){
					System.out.println("Felines doesn't feel like roaming at all today..");
				}
				else{
					if (roamTime % 2 == 0){
						roamTime = roamTime / 2;
					}
					else{
						roamTime = roamTime / 2 + 1;
					}
					int walk_speed = rand.nextInt(51) + 1;
					int duration = rand.nextInt(roamTime);
					int total_range = duration * walk_speed;
					System.out.printf("roaming for total range of %d in %d minutes\n", total_range, duration);
				}
			}
			else if (animal instanceof Canine){
				Canine c = (Canine)animal;
				int duration = rand.nextInt(roamTime);
				int total_range = duration * c.getSpeed();
				System.out.printf("roaming for total range of %d in %d minutes\n", total_range, duration);
			}
		}
	}

	public void release(){
		if (arr.isEmpty()){
			view();
		}
		else{
			int index = 0;
			do{
				try {
					view();
					System.out.printf("Choose that wants to be released [1 - %d]: ", arr.size());
					index = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					//TODO: handle exception
					scan.nextLine();
				}
			}while (index < 1 || index > arr.size());
			int randIndex = rand.nextInt(arr.size());
			Animal animal = arr.get(index-1);
			Animal randAnimal = arr.get(randIndex);
			if (animal instanceof Canine){
				if (randAnimal instanceof Canine){
					Canine c = (Canine)animal;
					if (animal.getGender().equals(randAnimal.getGender())){
						c.sound2();
						arr.remove(index-1);
						currCanine--;
					}
					else{
						c.sound1();
						arr.remove(index-1);
						currCanine--;
						if (randIndex != index-1){
							if (randIndex < index){
								arr.remove(randIndex);
							}
							else{
								arr.remove(randIndex-1);
							}
							currCanine--;
						}
					}
				}
				
			}
			else if (animal instanceof Feline){
				if (randAnimal instanceof Feline){
					Feline f = (Feline)animal;
					if (animal.getGender().equals(randAnimal.getGender())){
						f.sound2();
						arr.remove(index-1);
						currFeline--;
					}
					else{
						f.sound1();
						arr.remove(index-1);
						currFeline--;
						if (randIndex != index-1){
							if (randIndex < index){
								arr.remove(randIndex);
							}
							else{
								arr.remove(randIndex-1);
							}
							currFeline--;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
