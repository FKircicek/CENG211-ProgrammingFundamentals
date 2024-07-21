import java.lang.reflect.Method;
import java.util.StringTokenizer;

public class LibraryQuery {

    //Main requested methods
    public static String mostIssuedBook(Library_Management LM, Library L1,Library L2,Library L3) {  //1- The most issued book (among the three libraries).
        int b = 0;
        int c = 0;
        int d = 0;
        String[] book = new String[35];
        String title = null;
        int[] countIssues = new int[35];
        for (Issue[] x : LM.getIssues()) {
            for (Issue y : x) {
                int a = 0;
                for (String z : book) {
                    if (y == null) {
                        break;
                    } else {
                        if (book[0] == null) {
                            book[a] = y.getBook();
                            countIssues[a] = 1;
                            break;
                        } else {
                            if (z != null) {
                                if (y.getBook().equals(z)) {
                                    countIssues[a]++;
                                    break;
                                }
                            } else {
                                book[a] = y.getBook();
                                countIssues[a] = 1;
                                break;
                            }

                        }
                    }
                    a++;
                }
            }
        }
        for (int x : countIssues) {
            if (x > b) {
                b = x;
                d = c;
            }
            c++;
        }
        for (Book x : L1.getBook()) {
            if (x.getID().equals(book[d])) {
                title = x.getTitle();
            }
            }
            if (title == null){
                for (Book i : L2.getBook()) {
                    if (i.getID().equals(book[d])) {
                        title = i.getTitle();
                    }
            }
        }
            if (title == null){
                for (Book i : L3.getBook()) {
                    if (i.getID().equals(book[d])) {
                        title = i.getTitle();
                    }
                }
            }
        return title;
    }

        public static String theMemberMostIssues(Library_Management LM) {// 2- The member who issues the most books (for all three libraries and all years).
            Member[] members = Create.createMemberArray(6, "Members.csv");
            int[] countIssues = {0,0,0,0};
            for (Issue[] y : LM.getIssues()) {
                for (Issue x :y) {
                    if (x == null){
                        break;
                    }
                    else {
                        if (x.getMember() == members[0].getID()) {
                            countIssues[0]++;
                        } else if (x.getMember() == members[1].getID()) {
                            countIssues[1]++;
                        } else if (x.getMember() == members[2].getID()) {
                            countIssues[2]++;
                        } else if (x.getMember() == members[3].getID()) {
                            countIssues[3]++;
                        } else {
                            continue;
                        }
                    }
                }
            }
            int i = 0;
            int b = 0;
            int c = 0;
            for (int a: countIssues){
                if(a>i){
                    i =a;
                    b = c;
                }
                c++;
            }
            return members[b].getName();
        }

    public static double highestPenalty(Library_Management LM) { // 3- Highest penalty for late returning.
        double b = 0;
        int[] ID = new int[35];
        String name = null;
        double[][] penalties = new double[3][30];
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 30; k++) {
                Issue issue = LM.getIssues()[i][k];
                if (issue == null) {
                    continue;
                } else {
                    double z = Math.abs(numberToCalculateDateDiff(issue.getReturning_date())
                            - numberToCalculateDateDiff(issue.getIssue_date()));
                    if (z > 14) {
                        z = (z - 14) / 2;

                        penalties[i][k] = z;
                    }
                }
            }
        }

            for (double[] x : penalties) {
                for (double y: x) {
                    if (y > b) {
                        b = y;
                    }
                }
            }

            return b;
        }
    public static String mostCopyForAllLibraries(Library L1, Library L2, Library L3) { //4- The book with the most copies
        Book x = mostCopyFor1Library(L1);
        Book y = mostCopyFor1Library(L2);
        Book z = mostCopyFor1Library(L3);

        int a = Math.max(x.getQuantity(), y.getQuantity());
        int b = Math.max(x.getQuantity(),z.getQuantity());
        int c = Math.max(a,b);
        if(c == x.getQuantity()){
            return x.getTitle();
        }
        else if (c == y.getQuantity()){
            return y.getTitle();
        }
        else {
            return z.getTitle();
        }
    }
    public static String fewestCopy(Library_Management LM, Library L1, Library L2,Library L3) { //5- The book with the fewest copies of previously issued books.
        Book[] booksL1 =fewestCopy1Library(LM,L1);
        Book[] booksL2 =fewestCopy1Library(LM,L2);
        Book[] booksL3 =fewestCopy1Library(LM,L3);
        Book[] books4 = new Book[53];
        int i = 0;
        for (Book x: booksL1){
            if(x != null) {
                books4[i] = x;
                i++;
            }
        }
        for(Book y:books4){
            for(Book x : booksL2){
                if (y!= null) {
                }
                if(x!= null && y !=null) {
                    if (x.getQuantity() > y.getQuantity()) {
                        books4 = new Book[53];
                        i = 0;
                        books4[i] = x;
                    } else if (x.getQuantity() == y.getQuantity()) {
                        int n = 0;
                        for(Book z:books4){
                            if(x ==z){
                                n = 1;
                            }
                        }
                        if(n == 0) {
                            books4[i] = x;
                            i++;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        for(Book y:books4){
            for(Book x : booksL3){
                if (y!= null) {
                }
                if(x!= null && y !=null) {
                    if (x.getQuantity() > y.getQuantity()) {
                        books4 = new Book[53];
                        i = 0;
                        books4[i] = x;
                    } else if (x.getQuantity() == y.getQuantity()) {
                        int n = 0;
                        for(Book z:books4){
                            if(x ==z){
                                n = 1;
                            }
                        }
                        if(n == 0) {
                            books4[i] = x;
                            i++;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        String fewestCopies = "";
        for (Book x :books4){
            if(x != null) {
                fewestCopies = fewestCopies+ x.getTitle() + ", ";
            }
        }
        return fewestCopies.substring(0,fewestCopies.length()-2);
    }
    public static String memberWhoIssuesLeast(Library_Management LM) { //6- The member who issues the least number of books from the Computer Science Librar
        Member[] members = Create.createMemberArray(6, "Members.csv");
        int[] countIssues = {0,0,0,0};
        for (Issue x : LM.getIssues()[0]) {
            if (x.getMember() == members[0].getID()){
                countIssues[0]++;
            }
            else if (x.getMember() == members[1].getID()){
                countIssues[1]++;
            }
            else if (x.getMember() == members[2].getID()){
                countIssues[2]++;
            }
            else if (x.getMember() == members[3].getID()){
                countIssues[3]++;
            }
            else {
              continue;
            }
        }
        int i = 30;
        int b = 0;
        int c = 0;
        for (int a: countIssues){
            if(a<i){
                i =a;
                b = c;
            }
            c++;
        }
        return members[b].getName();
    }
    //Helper Methods
    public static Book mostCopyFor1Library(Library L){
        int i = 0;
        Book y = new Book(null,null,null,null,0,null,0) ;
        for(Book x: L.getBook()){
            if(x.getQuantity()>i){
                i = x.getQuantity();
                y = x;
            }
        }
        return y;
    }
    public static int stringMonthToInt(String month) {
        if (month.equals("Jan")) {
            return 31;
        } else if (month.equals("Feb")) {
            return 59;
        } else if (month.equals("Mar")) {
            return 90;
        } else if (month.equals("Apr")) {
            return 120;
        } else if (month.equals("May")) {
            return 151;
        } else if (month.equals("Jun")) {
            return 181;
        } else if (month.equals("Jul")) {
            return 212;
        } else if (month.equals("Aug")) {
            return 243;
        } else if (month.equals("Sep")) {
            return 273;
        } else if (month.equals("Oct")) {
            return 304;
        } else if (month.equals("Nov")) {
            return 334;
        } else if (month.equals("Dec")) {
            return 365;
        } else {
            return 0;
        }
    }

    public static int numberToCalculateDateDiff(String date1) {
        int day1;
        int monthToInt1;
        String month1;
        int year1;
        StringTokenizer st1 = new StringTokenizer(date1, "-");
        day1 = Integer.parseInt(st1.nextToken());
        month1 = st1.nextToken();
        year1 = Integer.parseInt(st1.nextToken());
        monthToInt1 = stringMonthToInt(month1);
        return day1 + monthToInt1 + year1*365 + year1/4;
    }
    public static void runAllMethods(Library_Management LM, Library L1, Library L2, Library L3){
        System.out.println("1) "+LibraryQuery.mostIssuedBook(LM, L1,L2,L3));
        System.out.println("2) "+LibraryQuery.theMemberMostIssues(LM));
        System.out.println("3) "+LibraryQuery.highestPenalty(LM));
        System.out.println("4) "+LibraryQuery.mostCopyForAllLibraries(L1, L2, L3));
        System.out.println("5) "+LibraryQuery.fewestCopy(LM, L1,L2,L3));
        System.out.println("6) "+LibraryQuery.memberWhoIssuesLeast(LM));
    }
    public static Book[] fewestCopy1Library(Library_Management LM, Library L) { //5- The book with the fewest copies of previously issued books.
        int i = 100;
        int p = 0;
        Book[] books = new Book[53];
        for (Issue[] x : LM.getIssues()) {
            for (Issue y : x) {
                if(y != null ){

                }
                for (Book z: L.getBook()){
                    if (z.getID().equals("Fi1")) {
                    }
                    if(y != null && z != null) {
                        if (z.getQuantity() == i && y.getBook().equals(z.getID())) {
                            int n = 0;
                            for(Book l: books){
                                if(z == l){
                                    n = 1;
                                }
                            }
                            if(n ==0) {
                                books[p] = z;
                                p++;
                            }
                        } else if (z.getQuantity() < i && y.getBook().equals(z.getID())) {
                            books = new Book[53];
                            i = z.getQuantity();
                            books[p] = z;
                            p++;
                        }
                    }
                }
            }
        }
        return books;
    }
}


