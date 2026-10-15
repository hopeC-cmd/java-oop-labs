/** Abstract base for anything the library lends out. */
public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;
    private Loan currentLoan;

    protected LibraryItem(String id, String title) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Item id must not be empty");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title must not be empty");
        this.id = id.trim();
        this.title = title.trim();
    }

    /** Each subclass decides how long it may be kept. */
    public abstract int loanPeriodDays();

    /** Short type label used in CSV files ("BOOK" / "DVD"). */
    public abstract String type();

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }
    void setAvailable(boolean available) { this.available = available; }
    public Loan getCurrentLoan() { return currentLoan; }

    @Override
    public void borrow(Member member) throws ItemNotAvailableException, MemberLimitExceededException {
        borrow(member, java.time.LocalDate.now());
    }

    /** Overload that takes the loan date (useful for loading from CSV and for testing). */
    public void borrow(Member member, java.time.LocalDate date)
            throws ItemNotAvailableException, MemberLimitExceededException {
        if (member == null) throw new IllegalArgumentException("Member must not be null");
        if (!available) throw new ItemNotAvailableException("'" + title + "' is already on loan");
        Loan loan = new Loan(this, member, date);
        member.addLoan(loan); // throws MemberLimitExceededException before anything changes
        currentLoan = loan;
        available = false;
    }

    @Override
    public void giveBack() {
        if (available || currentLoan == null) {
            throw new IllegalStateException("'" + title + "' is not on loan");
        }
        currentLoan.getMember().removeLoan(currentLoan);
        currentLoan = null;
        available = true;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%s, title=%s, %s]", type(), id, title, available ? "available" : "on loan");
    }
}
