import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;
public class ExtendBook extends Library {
    @Override
    public void performAction(String line,BufferedWriter bufferedWriter) throws IOException{
        // Check if the book's deadline has already been extended
        if (!Library.getExtendCounter().contains(line.split("\t")[1])) {
            // Add the book to the list of extended books
            Library.getExtendCounter().add(line.split("\t")[1]);
            bufferedWriter.write("The deadline of book ["+line.split("\t")[1]+"] was extended by member ["+line.split("\t")[2]+"] at "+line.split("\t")[3]+"\n");
            // Check if the member is a student
            if (Library.getIDStudentAcademic().get("Member [id: "+line.split("\t")[2]+"]").equals("S")) {
                // Extend the deadline for the book by 7 days
                Library.getBookDate().put("book ["+line.split("\t")[1]+"]",LocalDate.parse(line.split("\t")[3]).plusDays(7));
                bufferedWriter.write("New deadline of book ["+line.split("\t")[1]+"] is "+LocalDate.parse(line.split("\t")[3]).plusDays(7)+"\n");
            }
             // Check if the member is an academic
            else if (Library.getIDStudentAcademic().get("Member [id: "+line.split("\t")[2]+"]").equals("A")) {
                // Extend the deadline for the book by 14 days
                Library.getBookDate().put("book ["+line.split("\t")[1]+"]",LocalDate.parse(line.split("\t")[3]).plusDays(14));
                bufferedWriter.write("New deadline of book ["+line.split("\t")[1]+"] is "+LocalDate.parse(line.split("\t")[3]).plusDays(14)+"\n");
            }
        }
        else {
            bufferedWriter.write("You cannot extend the deadline!\n");
        }
    }
}