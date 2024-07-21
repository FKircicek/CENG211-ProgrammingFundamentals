import java.util.Arrays;

public class Library {
    private Book[] books;


    public Library(Book[] books) {
        this.books = books;
    }
    public Library(Library library){
        this.books = Arrays.copyOf(library.getBook(),library.getBook().length);
    }

    public Book[] getBook() {
        return Arrays.copyOf(books,books.length);
    }

    public void setBook(Book[] books) {
        this.books = books;
    }
}
