public class Create {

    public static Book createBook(int rows,String fileName) {
        FileIO fileIO = new FileIO();
        String ID = "";
        String title = "";
        String author = "";
        String publisher = "";
        int edition = -1;
        String genre = "";
        int quantity = 2;
        for (String j : fileIO.readValues(fileName)[rows]) {
            if (j.equals(fileIO.readValues(fileName)[rows][0])) {
                ID = j;
            } else if (j.equals(fileIO.readValues(fileName)[rows][1])) {
                title = j;
            } else if (j.equals(fileIO.readValues(fileName)[rows][2])) {
                author = j;
            } else if (j.equals(fileIO.readValues(fileName)[rows][3])) {
                publisher = j;
            } else if (j.equals(fileIO.readValues(fileName)[rows][4])) {
                edition = Integer.parseInt(j);
            } else if (j.equals(fileIO.readValues(fileName)[rows][5])) {
                genre = j;
            } else {
                quantity = Integer.parseInt(j);
            }
        }
        Book book = new Book(ID, title, author, publisher, edition, genre, quantity);
        return book;
    }
    public static Issue createIssue(int rows,String fileName) {
        FileIO fileIO = new FileIO();
        int ID = -1;
        int member = -1;
        String book = "";
        String issue_date = "";
        String returning_date = "";
        for (String j : fileIO.readValues(fileName)[rows]) {
            if (j.equals(fileIO.readValues(fileName)[rows][0])) {
                ID = Integer.parseInt(j);
            } else if (j.equals(fileIO.readValues(fileName)[rows][1])) {
                member =Integer.parseInt(j);
            } else if (j.equals(fileIO.readValues(fileName)[rows][2])) {
                book = j;
            } else if (j.equals(fileIO.readValues(fileName)[rows][3])) {
                issue_date = j;
            }
            else {
                returning_date = j;
           }
        }
        Issue issue = new Issue(ID, member, book, issue_date, returning_date);
        return issue;
    }
    public static Library createLibrary(int rows,String fileName){
        Book[] x = new Book[rows];
        for(int i = 0;i<rows;i++){
            x[i] =  createBook(i,fileName);

        }
    Library library = new Library(x);
        return library;
    }
    public static Library_Management createtLM(String fileName1,String fileName2,String fileName3){
            Issue[][] x = new Issue[3][30];
            for(int i = 0; i< 30;i++){
            x[0][i] = createIssue(i,fileName1);

            }
            for(int i = 0; i< 13;i++) {
                x[1][i] =  createIssue(i, fileName2);

            }
            for(int i = 0; i< 17;i++){
            x[2][i] =  createIssue(i,fileName3);

            }
            Library_Management LM = new Library_Management(x);
            return LM;

    }
    public static  Member createMember(int rows, String fileName){

        int ID = -1;
        String name = "";
        String email = "";
        FileIO fileIO = new FileIO();
        for (String j : fileIO.readValues(fileName)[rows]) {

                if (j.equals(fileIO.readValues(fileName)[rows][0])) {
                    ID = Integer.parseInt(j);
                } else if (j.equals(fileIO.readValues(fileName)[rows][1])) {
                    name = j;

                } else {
                    email = j;
                }
            }
        Member member = new Member(ID, name, email);
        return member;
    }

    public static  Member[] createMemberArray(int rows, String fileName){
        Member[] members = new Member[4];
        for(int i = 2;i<rows;i++){
            members[i-2] =  createMember(i,fileName);

        }
        return members;
    }
}
