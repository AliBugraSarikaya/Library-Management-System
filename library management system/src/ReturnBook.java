import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
public class ReturnBook extends Library {
    @Override
    public void performAction(String line,BufferedWriter bufferedWriter) throws IOException {
        // Check if the member is a student
        if (Library.getIDStudentAcademic().get("Member [id: "+line.split("\t")[2]+"]").equals("S")) {
            // Calculate the number of days the book was borrowed and check if the book was returned within 7 days
            if (ChronoUnit.DAYS.between(Library.getBookDate().get("book ["+line.split("\t")[1]+"]"),LocalDate.parse(line.split("\t")[3])) <= 7) {
                bufferedWriter.write("The book ["+line.split("\t")[1]+"] was returned by member ["+line.split("\t")[2]+"] at "+line.split("\t")[3]+" Fee: 0\n");
                Library.getBookDate().remove("book ["+line.split("\t")[1]+"]");
                Library.getBookMember().remove("book ["+line.split("\t")[1]+"]");
                Library.getExtendCounter().remove(line.split("\t")[1]);
            }
            else {
                bufferedWriter.write("The book ["+line.split("\t")[1]+"] was returned by member ["+line.split("\t")[2]+"] at "+line.split("\t")[3]+" Fee: "+(ChronoUnit.DAYS.between(Library.getBookDate().get("book ["+line.split("\t")[1]+"]"),LocalDate.parse(line.split("\t")[3]))-7)+"\n");
                Library.getBookDate().remove("book ["+line.split("\t")[1]+"]");
                Library.getBookMember().remove("book ["+line.split("\t")[1]+"]");
                Library.getExtendCounter().remove(line.split("\t")[1]);
            }
        }
        // Check if the member is an academic
        else if (Library.getIDStudentAcademic().get("Member [id: "+line.split("\t")[2]+"]").equals("A")) {
            // Calculate the number of days the book was borrowed and check if the book was returned within 14 days
            if (ChronoUnit.DAYS.between(Library.getBookDate().get("book ["+line.split("\t")[1]+"]"),LocalDate.parse(line.split("\t")[3])) <= 14) {
                bufferedWriter.write("The book ["+line.split("\t")[1]+"] was returned by member ["+line.split("\t")[2]+"] at "+line.split("\t")[3]+" Fee: 0\n");
                Library.getBookDate().remove("book ["+line.split("\t")[1]+"]");
                Library.getBookMember().remove("book ["+line.split("\t")[1]+"]");
                Library.getExtendCounter().remove(line.split("\t")[1]);
            }
            else {
                bufferedWriter.write("The book ["+line.split("\t")[1]+"] was returned by member ["+line.split("\t")[2]+"] at "+line.split("\t")[3]+" Fee: "+(ChronoUnit.DAYS.between(Library.getBookDate().get("book ["+line.split("\t")[1]+"]"),LocalDate.parse(line.split("\t")[3]))-14)+"\n");
                Library.getBookDate().remove("book ["+line.split("\t")[1]+"]");
                Library.getBookMember().remove("book ["+line.split("\t")[1]+"]");
                Library.getExtendCounter().remove(line.split("\t")[1]);
            }
        }
        if (Library.getBookBorrowList().containsKey("book ["+line.split("\t")[1]+"]")) {
            Library.getMemberBookCounter().put("member ["+line.split("\t")[2]+"]",Library.getMemberBookCounter().get("member ["+line.split("\t")[2]+"]")-1);
            Library.getBookBorrowList().remove("book ["+line.split("\t")[1]+"]");
        }
        else if (Library.getBookReadInLibraryList().containsKey("book ["+line.split("\t")[1]+"]")) {
            Library.getBookReadInLibraryList().remove("book ["+line.split("\t")[1]+"]");
        }
    }
}