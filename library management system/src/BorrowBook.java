import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;
public class BorrowBook extends Library {
    @Override
    public void performAction(String line,BufferedWriter bufferedWriter) throws IOException{
        // Check if the member has any previous borrowed books
        if (!Library.getMemberBookCounter().containsKey("member ["+line.split("\t")[2]+"]")) {
            // Initialize the member's book counter
            Library.getMemberBookCounter().put("member ["+line.split("\t")[2]+"]",1);
        }
        // Check if the member is a student
        if (Library.getIDStudentAcademic().get("Member [id: "+line.split("\t")[2]+"]").equals("S")) {
            // Check if the student has not exceeded the borrowing limit
            if (Library.getMemberBookCounter().get("member ["+line.split("\t")[2]+"]") < 3) {
                // Check if the book is not already borrowed by another member
                if (!Library.getBookMember().containsKey("book ["+line.split("\t")[1]+"]")) {
                    bufferedWriter.write("The book ["+line.split("\t")[1]+"] was borrowed by member ["+line.split("\t")[2]+"] at "+line.split("\t")[3]+"\n");
                    // Update the book's borrower and borrow date
                    Library.getBookMember().put("book ["+line.split("\t")[1]+"]","borrowed by member ["+line.split("\t")[2]+"]");
                    Library.getBookDate().put("book ["+line.split("\t")[1]+"]",LocalDate.parse(line.split("\t")[3]));
                    // Update the book borrow list
                    Library.getBookBorrowList().put("book ["+line.split("\t")[1]+"]","The book ["+line.split("\t")[1]+"] was borrowed by member ["+line.split("\t")[2]+"] at "+line.split("\t")[3]);
                    // Increment the member's book counter
                    Library.getMemberBookCounter().put("member ["+line.split("\t")[2]+"]",Library.getMemberBookCounter().get("member ["+line.split("\t")[2]+"]")+1);
                }
                else {
                    bufferedWriter.write("You can not read this book!\n");
                    }
            }
            else {
                bufferedWriter.write("You have exceeded the borrowing limit!\n");
            }
        }
        // Check if the member is an academic
        else if (Library.getIDStudentAcademic().get("Member [id: "+line.split("\t")[2]+"]").equals("A")) {
            // Check if the academic has not exceeded the borrowing limit
            if (Library.getMemberBookCounter().get("member ["+line.split("\t")[2]+"]") < 5) {
                // Check if the book is not already borrowed by another member
                if (!Library.getBookMember().containsKey("book ["+line.split("\t")[1]+"]")) {
                    bufferedWriter.write("The book ["+line.split("\t")[1]+"] was borrowed by member ["+line.split("\t")[2]+"] at "+line.split("\t")[3]+"\n");
                    // Update the book's borrower and borrow date
                    Library.getBookMember().put("book ["+line.split("\t")[1]+"]","borrowed by member ["+line.split("\t")[2]+"]");
                    Library.getBookDate().put("book ["+line.split("\t")[1]+"]",LocalDate.parse(line.split("\t")[3]));
                    // Update the book borrow list
                    Library.getBookBorrowList().put("book ["+line.split("\t")[1]+"]","The book ["+line.split("\t")[1]+"] was borrowed by member ["+line.split("\t")[2]+"] at "+line.split("\t")[3]);
                    // Increment the member's book counter
                    Library.getMemberBookCounter().put("member ["+line.split("\t")[2]+"]",Library.getMemberBookCounter().get("member ["+line.split("\t")[2]+"]")+1);
                }
                else {
                    bufferedWriter.write("You can not read this book!\n");
                }
            }
             else {
                bufferedWriter.write("You have exceeded the borrowing limit!\n");
            }
        }
    }
}
