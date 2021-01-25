package ie.gmit.dip;

/**
 * @author Michael Carew
 *
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Menu {

	private static String path;
	private Scanner s;
	private int key;
	private boolean selectOption = true;
	RailCypherEncryptDecrypt cypher = new RailCypherEncryptDecrypt(path, key);

	public Menu() {
		// set the scanner object
		s = new Scanner(System.in);
	}

	public void startMenu() throws Exception {

		try {
			// while true allow each selection below be used
			while (selectOption) {
				show();
				int choice = Integer.parseInt(s.next());

				if (choice == 1) {
					// Add file
					add();
					break;
				} else if (choice == 2) {
					// Add Key
					addKey();
					break;
				} else if (choice == 3) {
					// Encrypt
					encrypt();
					break;
				} else if (choice == 4) {
					// Decrypt
					decrypt();
					break;
				} else if (choice == 5) {
					// Display encoded
					display();
					break;
				} else if (choice == 6) {
					// quits the program
					System.out.println("Quiting...");
					selectOption = false;

				} else {
					// catches any number outside of 1 to 6
					System.out.println("Please try again and select a number from 1 to 6");

				}
			}
		} catch (NumberFormatException e) {
			// catches any char that is not an number
			System.out.println("Please try again and select a number from 1 to 6");
			// redisplay the menu
			startMenu();

		}
	}

	private void add() throws Exception {

		try {

			System.out.println("Add a file or URL:");
			path = s.next();
			File f = new File(path);
			FileHandler s1 = new FileHandler();
			// check if the entry is a file
			if (f.exists()) {
				// sends a file to Filehandler to be read to a file
				s1.readText(new FileInputStream(new File(path)), true);
			} else {
				// if it's not a file, sends as a URL to Filehandler to be read to a file
				s1.readText(new URL(path).openStream(), true);
			}
			// redisp[lay the menu
			startMenu();

		} catch (Exception e) {
			// Catches any invalid input and redisplay the menu
			System.out.println("Please enter a File or a URL");
			startMenu();
			// e.printStackTrace();
		}
	}

	private void addKey() throws Exception {
		try {

			System.out.println("Please add a number greater or equal to 1 and less than or equal 50");
			System.out.println("Enter the Key for the rail cipher: ");
			// get the scanner to accept int
			int key = Integer.parseInt(s.next());
			// set the boundaries for the input for the key
			if (key >= 1 && key <= 50) {
				// store the key value for encryption/decryption
				cypher.setKey(key);
				// let the user know the input is saved
				System.out.println("Key is saved");
				// redispay the menu
				startMenu();
			} else {
				System.out.println("Please try again and add a number greater or equal to 1 and less than or equal 50");
				startMenu();
			}

			// Catches any invalid numeric input and redisplay the menu
		} catch (NumberFormatException e) {
			System.out.println("Please try again and add a number greater or equal to 1 and less than or equal 50");
			startMenu();
			// Catches any invalid input and redisplay the menu
		} catch (Exception e) {
			System.out.println("Please try again and add a number greater or equal to 1 and less than or equal 50");
			startMenu();

		}

	}

	private void encrypt() throws Exception {

		try {

			cypher.encrypt();

			// Catches any issue thrown and redisplay the menu
		} catch (Exception e) {
			// this is on because the string parameter is setting itself to null
			e.printStackTrace();
			// prompt the user and redisplay the menu
			System.out.println("Enter a railkey or a file/url");
			startMenu();
		}
	}

	private void decrypt() {

		try {

			cypher.decrypt();
			// Catches any invalid input and redisplay the menu
		} catch (Exception e) {
			System.out.println("Please encrypt a file");
			e.printStackTrace();
		}

	}

	private void display() {
		try {

			// three options to print the files create during
			while (selectOption) {
				showFile();
				int choice = Integer.parseInt(s.next());

				if (choice == 1) {
					// Instantiate the Reader and create the new file
					BufferedReader in = new BufferedReader(new FileReader("filein.txt"));
					String line;
					while ((line = in.readLine()) != null) {
						System.out.println(line);
					}
					in.close();
					break;
				} else if (choice == 2) {
					// Instantiate the Reader and create the new file
					BufferedReader in = new BufferedReader(new FileReader("encryptedfile.txt"));
					// String to store the txt
					String line;
					// print to console
					while ((line = in.readLine()) != null) {
						System.out.println(line);
					}
					in.close();
					break;
				} else if (choice == 3) {
					// Instantiate the Reader and create the new file
					BufferedReader in = new BufferedReader(new FileReader("Decryptedfile.txt"));
					// String to store the txt
					String line;
					// print to console
					while ((line = in.readLine()) != null) {
						System.out.println(line);
					}
					in.close();
					break;
				} else if (choice == 4) {
					startMenu();
				}
			}
		} catch (Exception e) {
			// catch any errors, prompt the user for valid input and redisplay
			System.out.println("Please try again and select a number from 1 to 4");
			// redisplay the menu
			showFile();
		}
	}

	private void show() {
		// Menu options
		System.out.println("1. Select File or URL");
		System.out.println("2. Enter Rail Fence Key");
		System.out.println("3. Encrypt");
		System.out.println("4. Decrypt");
		System.out.println("5. Display Rail Fence");
		System.out.println("6. Quit \n");
		System.out.println("Type Option [1-6]:");
	}

	private void showFile() {
		// Display options
		System.out.println("1. Print File entered");
		System.out.println("2. Print Encrypted file");
		System.out.println("3. Print Decrypted File");
		System.out.println("4. Main Menu");
	}

}
