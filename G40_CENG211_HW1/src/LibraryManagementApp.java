import java.util.Arrays;

public class LibraryManagementApp {
    public static void main(String[] args) {
        Library L1 = Create.createLibrary(20, "L1_Books.csv"); //Central Library
        Library L2 = Create.createLibrary(10, "L2_Books.csv"); //School of Foreign Languages Library
        Library L3 = Create.createLibrary(13, "L3_Books.csv"); //Computer Science Library
        Library_Management LM = Create.createtLM("L1_Issues.csv", "L2_Issues.csv", "L3_Issues.csv"); //Library Management
        LibraryQuery.runAllMethods(LM,L1,L2,L3);
    }
}
