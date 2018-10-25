package CountriesTextFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String directoryFolder = "resources";
		String fileName = "countries.txt";
		int input = 0;
		createDirectory();
		CountriesTextFile.createFile(directoryFolder, fileName);
		
		CountriesTextFile.readFromFile(directoryFolder, fileName);
		String contin = "y";

		while (contin.equalsIgnoreCase("y")) {
			System.out.println("Welcome to the Countries Maintenance Application! ");
			System.out.println("1- See the list of countries");
			System.out.println("2- Add a country");
			System.out.println("3- Exit");
			input = Validator.getInt(sc, "\nEnter menu number: ", 1, 3);
		}

	}

	public static void createDirectory() {
		String dirPath = "resources";

		Path folder = Paths.get(dirPath);

		if (Files.notExists(folder)) {

			try {
				Files.createDirectories(folder);
				System.out.println("The folder was created successfully.");
			} catch (IOException e) {
				System.out.println("Something went wrong with the folder creation.");

			}

		}
	}
}
