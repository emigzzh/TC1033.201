package gui;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DataFinder {
	private static ArrayList<DummyMaker> pokemonList = new ArrayList<>();
	private static double totalHeightSum = 0; 
	private static double totalWeightSum = 0; 
	private static int totalHpSum = 0; 
	private static int totalDefenseSum = 0; 
	private static int totalSpeedSum = 0;
	private static int pokedexSize = 0;
	
	public static void runFile(String fileName) {
		
		try {
			Scanner inputStream = new Scanner(new File(fileName));
			String line = inputStream.nextLine();
			
			while (inputStream.hasNextLine()) {
				line = inputStream.nextLine();
				String [] ary = line.split(",");
				String name = ary[0];
				String generation = ary[1];
				String rarity = ary[2];
				String type1 = ary[3];
				String type2 = ary[4];
				double height = Double.parseDouble(ary[5]);
				double weight = Double.parseDouble(ary[6]);
				int hp = Integer.parseInt(ary[7]);
				int defense = Integer.parseInt(ary[8]);
				int speed = Integer.parseInt(ary[9]);
				
				DummyMaker pokemon = new DummyMaker(name, generation, type1, type2, hp, defense, speed, weight, height, rarity);
				pokemonList.add(pokemon);
				
				totalHeightSum += Double.parseDouble(ary[5]); 
				totalWeightSum += Double.parseDouble(ary[6]); 
				totalHpSum += Integer.parseInt(ary[7]); 
				totalDefenseSum += Integer.parseInt(ary[8]); 
				totalSpeedSum += Integer.parseInt(ary[9]);
				pokedexSize++;
			}	
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Problem with input from file. Error: "+ e.getMessage());
			InitialWindow.ready = false;
		}
	}
	
	public static ArrayList<DummyMaker> getPokemonList() {
        return pokemonList;
    }
	
	public static double getHeightAverage() {
		return totalHeightSum/pokedexSize;
	}

	public static double getWeightAverage() {
		return totalWeightSum/pokedexSize;
	}

	public static int getHpAverage() {
		return totalHpSum/pokedexSize;
	}

	public static int getDefenseAverage() {
		return totalDefenseSum/pokedexSize;
	}

	public static int getSpeedAverage() {
		return totalSpeedSum/pokedexSize;
	}

}
