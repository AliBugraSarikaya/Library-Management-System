import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;
public abstract class Library {
    private static List<String> studentList = new ArrayList<String>();
    private static List<String> academicList = new ArrayList<String>();
    private static List<String> printedList = new ArrayList<String>();
    private static List<String> handwrittenList = new ArrayList<String>();
    private static Map<String,String> BookMember = new HashMap<>();
    private static Map<String,LocalDate> BookDate = new HashMap<>();
    private static Map<String,String> BookReadInLibraryList = new HashMap<>();
    private static Map<String,String> BookBorrowList = new HashMap<>();
    private static List<String> ExtendCounter = new ArrayList<String>();
    private static Map<String,String> IDStudentAcademic = new HashMap<>();
    private static Map<String,String> IDPrintedHandwritten  = new HashMap<>();
    private static Map<String,Integer> MemberBookCounter = new HashMap<>();
    public static List<String> getStudentList() {
        return studentList;
    }
    public static List<String> getAcademicList() {
        return academicList;
    }
    public static List<String> getPrintedList() {
        return printedList;
    }
    public static List<String> getHandwrittenList() {
        return handwrittenList;
    }
    public static Map<String,String> getBookMember() {
        return BookMember;
    }
    public static Map<String,LocalDate> getBookDate() {
        return BookDate;
    }
    public static Map<String,String> getBookReadInLibraryList() {
        return BookReadInLibraryList;
    }
    public static Map<String,String> getBookBorrowList() {
        return BookBorrowList;
    }
    public static List<String> getExtendCounter() {
        return ExtendCounter;
    }
    public static Map<String,String> getIDStudentAcademic() {
        return IDStudentAcademic;
    }
    public static Map<String,String> getIDPrintedHandwritten() {
        return IDPrintedHandwritten;
    }
    public static Map<String,Integer> getMemberBookCounter() {
        return MemberBookCounter;
    }
    public abstract void performAction(String line, BufferedWriter bufferedWriter) throws IOException;
}