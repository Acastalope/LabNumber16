package CountriesTextFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesTextFile {


public static void readFromFile(String directoryFolder, String fileName) {
	Path filePath = Paths.get(directoryFolder,  fileName);
	File file = filePath.toFile();

	try {
		FileReader fr = new FileReader(file);
		BufferedReader reader = new BufferedReader(fr);
		
		String line = reader.readLine();
		
		while (line != null) {
			System.out.println(line);
			line = reader.readLine(); // reads the next line
		}
		reader.close();
		
	} catch (FileNotFoundException e) {
		System.out.println("File not found!");
		
	} catch (IOException e) {
		System.out.println("Contact customer serice.");
	}		
}

public static void writeToFile(String country, String directoryFolder, String fileName) {
Path filePath = Paths.get(directoryFolder,  fileName);
File file = filePath.toFile();

//Country c = new Country("USA");

try {
	// the true parameter for the FileOutputStream() constructor
	// appends data to the end of the file
	// false rewrites over the entire file
	PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
	outW.println(country);
	outW.close(); // MANDATORY: this needs to be closed when you are done
	
} catch (FileNotFoundException e) {
	System.out.println("The file was not found");
	}

}

public static void createFile(String directoryFolder, String fileName) {


Path filePath = Paths.get(directoryFolder, fileName);
if (Files.notExists(filePath)) {
	try {
	Files.createFile(filePath);
	System.out.println("The file was created successfully.");
	} catch (IOException e) {
		System.out.println("Something went wrong with the file creation.");
	}
} else {
		//System.out.println("File already exists!");
	}
}
}