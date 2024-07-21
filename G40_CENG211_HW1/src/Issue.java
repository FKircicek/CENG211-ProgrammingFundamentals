import java.lang.reflect.Method;

public class Issue {
    private int ID;
    private int member;
    private String book;
    private String issue_date;
    private String returning_date;

    public Issue(int ID, int member, String book, String issue_date, String returning_date) {
        this.ID = ID;
        this.member = member;
        this.book = book;
        this.issue_date = issue_date;
        this.returning_date = returning_date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public String getBook() {
        return new String(book);
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getIssue_date() {
        return new String(issue_date);
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getReturning_date() {
        return new String(returning_date);
    }

    public void setReturning_date(String returning_date) {
        this.returning_date = returning_date;
    }
}
