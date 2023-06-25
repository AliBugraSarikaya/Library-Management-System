import java.io.*;
import java.util.*;
public class AddBook extends Library {
    
    int book_id_calculator = 1;
    @Override
    public void performAction(String line,BufferedWriter bufferedWriter) throws IOException{
        if (book_id_calculator < 1000000) {
            // Store the book ID in the ID-Printed/Handwritten map
            Library.getIDPrintedHandwritten().put("Book [id: "+book_id_calculator+"]",line.split("\t")[1]);
            // Check if the book is printed
            if (line.split("\t")[1].equals("P")) {
                // Add the printed book to the Printed list
                Library.getPrintedList().add("Printed [id: "+book_id_calculator+"]");
                bufferedWriter.write("Created new book: Printed [id: "+book_id_calculator+"]\n");
                // Increment the book ID calculator
                book_id_calculator++;
            }
            // Check if the book is handwritten
            else if (line.split("\t")[1].equals("H")) {
                // Add the handwritten book to the Handwritten list
                Library.getHandwrittenList().add("Handwritten [id: "+book_id_calculator+"]");
                bufferedWriter.write("Created new book: Handwritten [id: "+book_id_calculator+"]\n");
                // Increment the book ID calculator
                book_id_calculator++;
            }
        }
    }
}