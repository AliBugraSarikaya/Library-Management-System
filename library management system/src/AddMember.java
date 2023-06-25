import java.io.*;
import java.util.*;
public class AddMember extends Library {
    int member_id_calculator = 1;
    @Override
    public void performAction(String line,BufferedWriter bufferedWriter) throws IOException {
        if (member_id_calculator < 1000000) {
            // Store the member ID in the ID-Student/Academic map
            Library.getIDStudentAcademic().put("Member [id: "+member_id_calculator+"]",line.split("\t")[1]);
            // Check if the member is a student
            if (line.split("\t")[1].equals("S")) {
                // Add the student to the Student list
                Library.getStudentList().add("Student [id: "+member_id_calculator+"]");
                bufferedWriter.write("Created new member: Student [id: "+member_id_calculator+"]\n");
                // Increment the member ID calculator
                member_id_calculator++;
            }
            else if (line.split("\t")[1].equals("A")) {
                // Add the academic to the Academic list
                Library.getAcademicList().add("Academic [id: "+member_id_calculator+"]");
                bufferedWriter.write("Created new member: Academic [id: "+member_id_calculator+"]\n");
                // Increment the member ID calculator
                member_id_calculator++;
            }
        }
    }
}