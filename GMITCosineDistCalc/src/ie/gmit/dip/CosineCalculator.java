package ie.gmit.dip;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Michael Carew
 * 
 * @version 1.0
 * 
 * compares files and calculates the cosine similarity between them
 *
 */
public class CosineCalculator {

	public CosineCalculator() {

	}


	/**
	 * @param sw This is the subject file
	 * @param qw This is the query file
	 * @return cosine similarity of files
	 * @throws Exception throws any file exceptions
	 */
	public static synchronized double cosineSimilarity(File sw, File qw) throws Exception {
		SubjectFileHandler sf = new SubjectFileHandler();
		QueryFileHandler qf = new QueryFileHandler();

		// Get vectors
		ConcurrentMap<String, Integer> a = sf.readText(sw);
		Map<String, Integer> b = qf.readText(qw);

		// Get unique words from both sequences
		HashSet<String> intersection = new HashSet<>(a.keySet());
		intersection.retainAll(b.keySet());

		double dotProduct = 0, magnitudeA = 0, magnitudeB = 0;

		// Calculate dot product
		for (String item : intersection) {
			dotProduct += a.get(item) * b.get(item);
		}

		// Calculate magnitude a
		for (String k : a.keySet()) {
			magnitudeA += Math.pow(a.get(k), 2);
		}

		// Calculate magnitude b
		for (String k : b.keySet()) {
			magnitudeB += Math.pow(b.get(k), 2);
		}

		// return cosine similarity
		return dotProduct / Math.sqrt(magnitudeA * magnitudeB);

	}

}
