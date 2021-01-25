**Menu**
 - Displays the options to use
  - code used from the Student manager
 - Add a file or URL 
   - use scanner to get the file path or absolute URL and then send to be read into the program
   - Uses exception handling to inform the user of error and redisplay the menu
 - Rail key 
  - set this to accept a number between 1 and 50
  - sent to encrypt class and stored for use
  - Error handling for letters which throws a NumberFormatException 
 - Encrypt 
   - stores the file and then encrypts with the key
  - Decrypt 
   - Uses the encrypted file and decrypts it and prints a new file to display
  - Display
    - use choice options to allow the user to display the file entered, displays the encrypted file and displays the decrypted file
  - Quit 
    - quits the program
    
  Error handling was used extensively to prompt the user and catch any errors and then redisplay the menu where applicable
  All exceptions are thrown and caught. All exceptions are caught using try and catch in the menu methods
   
  File handler just reads in what is entered and prints to console, prints to file and passes to Railencrypt constructor to get encrypted 
  
  java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0 is thrown  
  Only the last word of the file is read  so then it's trying to cycle through and throwing the out of bounds. :(. I used a string at the start so I know the encrypt and decrypt work as expected.
  I used 
  Encrypt code will print to file and decrypt code will print to file
  Display will read from each file
  
  I used static variables in Menu and RailCypherEncryptDecrypt to pass variables through methods 
  I just used filewriter to create any file so in my opinion there was no need for a class to handle this. 
  I had 8 files at the start but I didn't need them so I cut the amount down to 4 files by refactoring the code.
    
