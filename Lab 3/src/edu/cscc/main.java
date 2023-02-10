package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.*;

public class main {
// Aidan McBride 2/9/23 Regex Lab
	
	public static Pattern pattern1 = Pattern.compile("\\([2-9]\\d\\d\\)\\s\\d\\d\\d-\\d\\d\\d\\d");
	
	public static Pattern pattern2 = Pattern.compile("[2-9]\\d\\d-\\d\\d\\d-\\d\\d\\d\\d");
	
	public static Pattern pattern3 = Pattern.compile("[2-9]\\d\\d\\d\\d\\d\\d\\d\\d\\d");
	
	static int count = 0;
	
	public static void main(String[] args) {

		try {
			File data = new File("phoneno.dat");
			Scanner reader = new Scanner(data);
			while (reader.hasNext()) {
				count = count+1;
				String entry = reader.nextLine();
				phonecheck(entry);
			}
			reader.close();
		} catch (FileNotFoundException error) {
			System.out.println("File not found!");
			error.printStackTrace();
		} finally {
			System.out.println("Done.");
		}

	}
	public static void phonecheck(String line) {
		Matcher matcher1 = pattern1.matcher(line);
		Matcher matcher2 = pattern2.matcher(line);
		Matcher matcher3 = pattern3.matcher(line);
		boolean result1 = matcher1.matches();
		boolean result2 = matcher2.matches();
		boolean result3 = matcher3.matches();
		if (result1 == true) {
			return;
		} else if (result2 == true) {
			return;
		} else if (result3 == true) {
			return;
		} else {
			System.out.println("Line " + count + " Invalid phone number: " + line);
		}
		
	}
}
