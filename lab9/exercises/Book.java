import java.util.Objects;

public class Book {

    private final String isbn;
    private final String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn()  { return isbn; }
    public String getTitle() { return title; }

    // equality by ISBN only, not by title
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                       // same reference
        if (!(o instanceof Book other)) return false;     // null or a different type
        return isbn.equals(other.isbn);
    }

    // equal books MUST produce equal hash codes
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return title + " [" + isbn + "]";
    }
}