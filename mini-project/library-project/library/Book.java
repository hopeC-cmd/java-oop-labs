public class Book extends LibraryItem {
    private final String author;

    public Book(String id, String title, String author) {
        super(id, title);
        if (author == null || author.isBlank()) throw new IllegalArgumentException("Author must not be empty");
        this.author = author.trim();
    }

    public String getAuthor() { return author; }

    @Override public int loanPeriodDays() { return 21; }
    @Override public String type() { return "BOOK"; }

    @Override
    public String toString() {
        return "Book[id=" + getId() + ", title=" + getTitle() + ", author=" + author
                + ", " + (isAvailable() ? "available" : "on loan") + "]";
    }
}
