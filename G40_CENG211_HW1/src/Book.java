public class Book {
    private String ID;
    private String title;
    private String author;
    private String publisher;
    private int edition;
    private String genre;
    private int quantity;

    public Book(String ID, String title, String author, String publisher, int edition, String genre, int quantity) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
        this.genre = genre;
        this.quantity = quantity;
    }
    public Book(Book book){
        this.ID = new String(book.getID());
        this.title = new String(book.getTitle());
        this.author = new String(book.getAuthor());
        this.publisher = new String(book.getPublisher());
        this.edition = book.getEdition();
        this.genre = new String(book.getGenre());
        this.quantity = book.getQuantity();
    }

    public String getID() {
        return new String(ID);
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
            return (title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return new String(author);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return new String(publisher);
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getGenre() {
        return new String(genre);
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return  quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
