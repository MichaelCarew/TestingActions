package ie.gmit.dip;

import java.io.File;
import java.util.Scanner;

/**
 * @author Michael Carew
 *
 * @version 1.0
 * 
 * sets up the simple menu 
 */

public class Menu {

	private Scanner s;
	private String subjectFile, queryFile;
	File f;
	File q;

	public Menu() {
		// set the scanner object
		s = new Scanner(System.in);
	}

	/**
	 * @throws Exception throws any exceptions 
	 * 
	 * This is the menu for the simple gui in Console, the user will add a subject file and a query file.
	 * The files are sent  to the cosine calculator class and then set as maps  of items and the similarity between both files is calculated 
	 * and then printed in console
	 */
	public void startMenu() throws Exception {

		try {

			addSubjectFile();
			addQueryFile();
			System.out.println("Comparing files.. Processing now...");
			System.out.println("If the similarity between both files is 1, then they are both the same file");
			System.out.println("The similarity between both files is" + " " + CosineCalculator.cosineSimilarity(f, q));

		} catch (Exception e) {
			// catches any exception and shows where to check
			System.out.println("Something is up!! MAin menu ");

		}
	}

	/**
	 * @throws Exception
	 * 
	 * allows a file path to be added in console
	 */
	private void addSubjectFile() throws Exception {

		try {

			System.out.println("Enter main File:");
			subjectFile = s.next();
			f = new File(subjectFile);

		} catch (Exception e) {
			// Catches any invalid input and redisplay the menu
			System.out.println("Something is up!! Add Subject");
		}
	}

	/**
	 * @throws Exception
	 * 
	 * allows a file path to be added in console
	 */
	private void addQueryFile() throws Exception {

		try {

			System.out.println("Enter Query File:");
			queryFile = s.next();
			q = new File(queryFile);

		} catch (Exception e) {
			// Catches any invalid input and redisplay the menu
			System.out.println("Something is up!! QueryFile");
			// e.printStackTrace();
		}
	}

}
