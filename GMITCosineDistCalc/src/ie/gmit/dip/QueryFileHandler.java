package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Michael Carew
 * 
 * @version 1.0
 * 
 * Sets up and stores the query file in a map
 *
 */


public class QueryFileHandler implements Runnable {

	private ConcurrentMap<String, Integer> queryFileMap = new ConcurrentHashMap<String, Integer>();

	public QueryFileHandler() {

	}
	
	

	/**
	 * @param sw  File parameter to allow the file and it's contents to be processed
	 * @return the map of file words and frequency
	 * @throws Exception throws any exceptions
	 */
	public synchronized ConcurrentMap<String, Integer> readText(File sw) throws Exception {

		// Instantiate the Reader
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sw)))) {
			// String to store the txt
			String line = null;

			while ((line = br.readLine()) != null) {

				String[] words = line.toLowerCase().replaceAll("[^A-Za-z0-9 ]", " ").split(" ");

				for (String wordLoop : words) {
					int frequency = 1;
					if (queryFileMap.containsKey(wordLoop)) {
						frequency = queryFileMap.get(wordLoop);
						++frequency;

					}

					queryFileMap.put(wordLoop, frequency);

				}

				// System.out.println(Collections.singletonList(queryFileMap));

			}
			// Stops memory leaks!
			br.close();

		} catch (Exception e) {
			System.out.println("QueryFileHandler exception ");
		}
		return queryFileMap;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
