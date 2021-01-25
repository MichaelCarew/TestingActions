package ie.gmit.dip;

/**
 * @author Michael Carew
 *
 */

import java.io.*;

public class FileHandler {

	public void readText(InputStream in, boolean encrypt) throws Exception {
		// String to store the txt
		String line;
		int key = 0;
		// Instantiate the Reader
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		FileWriter fw = new FileWriter("Filein.txt");

		while ((line = br.readLine()) != null) {

			
			// Create an object to pass the file to encrypt
			RailCypherEncryptDecrypt cypher = new RailCypherEncryptDecrypt(line, key);
			// send the file to be saved for use
			cypher.setFiletoEncrypt(line);
			// Write the inputed text to a file
			fw.write(line);
		}
		// Stops memory leaks!
		fw.close();
		br.close();

	}

}
