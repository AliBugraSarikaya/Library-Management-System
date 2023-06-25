import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;
public class ReadInLibrary extends Library {
    @Override
    public void performAction(String line,BufferedWriter bufferedWriter) throws IOException{
        if (!Library.getBookMember().containsKey("book ["+line.split("\t")[1]+"]")) {
            // Check if the book is handwritten and the member is a student
            if (Library.getIDPrintedHandwritten().get("Book [id: "+line.split("\t")[1]+"]").equals("H") && Library.getIDStudentAcademic().get("Member [id: "+line.split("\t")[2]+"]").equals("S")) {
                bufferedWriter.write("Students can not read handwritten books!\n");
            }
            else {
                // Book is available to be read in the library
                bufferedWriter.write("The book ["+line.split("\t")[1]+"] was read in library by member ["+line.split("\t")[2]+"] at "+line.split("\t")[3]+"\n");
                Library.getBookMember().put("book ["+line.split("\t")[1]+"]","member ["+line.split("\t")[2]+"]");
                Library.getBookDate().put("book ["+line.split("\t")[1]+"]",LocalDate.parse(line.split("\t")[3]));
                Library.getBookReadInLibraryList().put("book ["+line.split("\t")[1]+"]","The book ["+line.split("\t")[1]+"] was read in library by member ["+line.split("\t")[2]+"] at "+line.split("\t")[3]);
            }
        }
        else {
            // Book is already borrowed and cannot be read in the library
            bufferedWriter.write("You can not read this book!\n");
        }
    }
}