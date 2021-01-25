package ie.gmit.dip;

import java.io.FileWriter;
import java.io.IOException;

public class RailCypherEncryptDecrypt {

	// pass between the methods
	private static String filetoEncrypt = "";
	// set this string as static so I can pass the encrypted file to decrypt
	private static String encrypText;
	private int key;
	private int col;
	private char[][] railfence = new char[key][col];
	FileHandler f1 = new FileHandler();

	public RailCypherEncryptDecrypt(String xy, int key) {
		super();
		this.setFiletoEncrypt(xy);
		this.key = key;
	}

	// get the key
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key; // store the key
	}

	/**
	 * @return the filetoEncrypt
	 */

	public String getFiletoEncrypt() {
		return filetoEncrypt;
	}

	/**
	 * @param filetoEncrypt the filetoEncrypt to set
	 */
	public void setFiletoEncrypt(String filetoEncrypt) {
		RailCypherEncryptDecrypt.filetoEncrypt = filetoEncrypt;
	}

// I used  the algorithim from below to encrypt and decrypt	
// https://github.com/VoxelPixel/CiphersInJava/blob/master/RailFence.java

	public String encrypt() throws IOException {
		// create a file for the encrypted text
		FileWriter fw = new FileWriter("EncryptedFile.txt");
		// display the key
		System.out.println(key);
		// only reads the last word aaarrrdgh
		System.out.println(filetoEncrypt);
		System.out.println(getFiletoEncrypt().length());

		// set a matrix
		for (int i = 0; i < key; i++) {
			for (int j = 0; j < getFiletoEncrypt().length(); j++) {
				railfence[i][j] = '*';
			}
		}
		// zigzag the rows
		int row = 0;
		int check = 0;
		for (int i = 0; i < getFiletoEncrypt().length(); i++) {
			if (check == 0) {
				railfence[row][i] = getFiletoEncrypt().charAt(i);
				row++;
				if (row == key) {
					check = 1;
					row--;
				}
			} else if (check == 1) {
				row--;
				railfence[row][i] = getFiletoEncrypt().charAt(i);
				if (row == 0) {
					check = 0;
					row = 1;
				}
			}
		}

		// encrypt
		String encrypText = "";
		for (int i = 0; i < key; i++) {
			for (int j = 0; j < getFiletoEncrypt().length(); j++) {
				encrypText += railfence[i][j];
			}

		}
		// Write to file and print to console

		encrypText = encrypText.replaceAll("\\*", "");
		// write to the file
		fw.write(encrypText);
		// close the filewriter
		fw.close();

		return encrypText;

	}

	public String decrypt() throws Exception {

		// Add filewriter to print the file
		FileWriter fw = new FileWriter("DecryptedFile.txt");

		railfence = new char[key][encrypText.length()];
		// matrix
		for (int i = 0; i < key; i++) {
			for (int j = 0; j < encrypText.length(); j++) {
				railfence[i][j] = '*';
			}
		} // for

		// putting letters in the matrix in zig-zag
		int row = 0;
		int check = 0;
		for (int i = 0; i < encrypText.length(); i++) {
			if (check == 0) {
				railfence[row][i] = encrypText.charAt(i);
				row++;
				if (row == key) {
					check = 1;
					row--;
				}
			} else if (check == 1) {
				row--;
				railfence[row][i] = encrypText.charAt(i);
				if (row == 0) {
					check = 0;
					row = 1;
				}
			} // if-else
		} // for

		// changing order of rails
		int ordr = 0;
		for (int i = 0; i < key; i++) {
			for (int j = 0; j < encrypText.length(); j++) {
				String temp = railfence[i][j] + "";
				if (temp.matches("\\*")) {
					// skipping in case of '*'
					continue;
				} else {
					// adding cipher letters one by one diagonally
					railfence[i][j] = encrypText.charAt(ordr);
					ordr++;
				} // if-else
			} // inner for
		} // for

		String decrypText = "";
		check = 0;
		row = 0;
		// converting rails back into a single line message
		for (int i = 0; i < encrypText.length(); i++) {
			if (check == 0) {
				decrypText += railfence[row][i];
				row++;
				if (row == key) {
					check = 1;
					row--;
				}
			} else if (check == 1) {
				row--;
				decrypText += railfence[row][i];
				if (row == 0) {
					check = 0;
					row = 1;
				}
			} // if-else
		} // for

		// write to file
		fw.write(decrypText);
		// close the filewriter
		fw.close();

		return decrypText;

	}

}
