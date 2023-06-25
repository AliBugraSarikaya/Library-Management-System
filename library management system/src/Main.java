import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        try {
            // Create instances of required classes
            Library addBook = new AddBook();
            Library addMember = new AddMember();
            Library getTheHistory = new GetTheHistory();
            Library borrowBook = new BorrowBook();
            Library readInLibrary = new ReadInLibrary();
            Library returnBook = new ReturnBook();
            Library extendBook = new ExtendBook();
            // Read input file and write to output file
            FileInputStream fStream = new FileInputStream(args[0]);
            BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
            FileWriter fileWriter = new FileWriter(args[1]);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            while ((line = br.readLine()) != null) {
                // Determine the command type and invoke corresponding methods
                if (line.split("\t")[0].equals("addBook")) {
                    addBook.performAction(line,bufferedWriter);
                }
                else if (line.split("\t")[0].equals("addMember")) {
                    addMember.performAction(line,bufferedWriter);
                }
                else if (line.split("\t")[0].equals("getTheHistory")) {
                    getTheHistory.performAction(line,bufferedWriter);
                }
                else if (line.split("\t")[0].equals("borrowBook")) {
                    borrowBook.performAction(line,bufferedWriter);
                }
                else if (line.split("\t")[0].equals("readInLibrary")) {
                    readInLibrary.performAction(line,bufferedWriter);
                }
                else if (line.split("\t")[0].equals("returnBook")) {
                    returnBook.performAction(line,bufferedWriter);
                }
                else if (line.split("\t")[0].equals("extendBook")) {
                    extendBook.performAction(line,bufferedWriter);
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            
        }
    }
}