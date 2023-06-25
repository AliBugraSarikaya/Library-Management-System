import java.io.*;
import java.util.*;
public class GetTheHistory extends Library {
    @Override
    public void performAction(String line,BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write("History of library:\n");
        // Write the number of students and list their details
        bufferedWriter.write("\nNumber of students: "+Library.getStudentList().size());
        for (String i : Library.getStudentList()) {
            bufferedWriter.write("\n"+i);
        }
        // Write the number of academics and list their details
        bufferedWriter.write("\n\nNumber of academics: "+Library.getAcademicList().size());
        for (String i : Library.getAcademicList()) {
            bufferedWriter.write("\n"+i);
        }
        // Write the number of printed books and list their details
        bufferedWriter.write("\n\nNumber of printed books: "+Library.getPrintedList().size());
        for (String i : Library.getPrintedList()) {
            bufferedWriter.write("\n"+i);
        }
        // Write the number of handwritten books and list their details
        bufferedWriter.write("\n\nNumber of handwritten books: "+Library.getHandwrittenList().size());
        for (String i : Library.getHandwrittenList()) {
            bufferedWriter.write("\n"+i);
        }
        // Write the number of borrowed books and list their details
        bufferedWriter.write("\n\nNumber of borrowed books: "+Library.getBookBorrowList().size());
        for (String i : Library.getBookBorrowList().keySet()) {
            bufferedWriter.write("\n"+Library.getBookBorrowList().get(i));
        }
        // Write the number of books read in the library and list their details
        bufferedWriter.write("\n\nNumber of books read in library: "+Library.getBookReadInLibraryList().size());
        for (String i : Library.getBookReadInLibraryList().keySet()) {
            bufferedWriter.write("\n"+Library.getBookReadInLibraryList().get(i));
        }
    }
}