package ie.gmit.dip;


import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Michael Carew
 * 
 * @version 1.0
 * 
 * reads in the subject file 
 *
 */
public class SubjectFileHandler {

	private ConcurrentMap<String, Integer> subjectFileMap = new ConcurrentHashMap<String, Integer>();

	public SubjectFileHandler() {

	}

	/**
	 * @param sw stores and processes the file for cosine calc
	 * @return the map of the words and frequency in the subject file
	 * @throws Exception
	 */
	public synchronized ConcurrentMap<String, Integer> readText(File sw) throws Exception {
		// String to store the txt
		String line;

		// Instantiate the Reader
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sw)))) {

			while ((line = br.readLine()) != null) {

				String[] words = line.toLowerCase().replaceAll("[^A-Za-z0-9 ]", " ").split(" ");
				for (String wordLoop : words) {
					int frequency = 1;

					if (subjectFileMap.containsKey(wordLoop)) {
						frequency = subjectFileMap.get(wordLoop);
						++frequency;

					}

					subjectFileMap.put(wordLoop, frequency);

				}

			}
			// Stops memory leaks!
			br.close();
			
			
		}catch (Exception e) {
			// Catches any invalid input and redisplay the menu
			System.out.println("Something is up with the subject file");
		}
		return subjectFileMap;
	}

}
