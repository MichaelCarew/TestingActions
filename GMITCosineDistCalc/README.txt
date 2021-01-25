The file handling and the menu with  exception handling were used from the Rail Cypher project to get started.
Once I had the file passing through the program I set up concurrentHashMaps in the the file handler classes using the Assignment workshop tips.
I set up the code from https://blog.nishtahir.com/fuzzy-string-matching-using-cosine-similarity/ in the CosineCalculator class and studied how it worked.
I had the work done for setting up the maps in the Filehandler classes so I just needed to pass in the files to the cosine class. 
<Integer Integer> did not play well with the cosinecalulator so I reverted back to <string, Integer> and it worked well
The methods are thread safe and all have exception handling
Javadoc comments done and stored in ~/Desktop/docs
cosine.jar created and works as expected outside the dev env. This jar file is in the bin folder
UML design added as a png

