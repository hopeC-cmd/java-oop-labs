import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {
    private final LibraryItem item;
    private final Member member;
    private final LocalDate loanDate;

    public Loan(LibraryItem item, Member member, LocalDate loanDate) {
        if (item == null || member == null || loanDate == null) {
            throw new IllegalArgumentException("Loan needs an item, a member and a date");
        }
        this.item = item;
        this.member = member;
        this.loanDate = loanDate;
    }

    public LibraryItem getItem() { return item; }
    public Member getMember() { return member; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getDueDate() { return loanDate.plusDays(item.loanPeriodDays()); }

    public boolean isOverdue() { return isOverdue(LocalDate.now()); }
    public boolean isOverdue(LocalDate today) { return today.isAfter(getDueDate()); }
    public long daysOverdue(LocalDate today) { return Math.max(0, ChronoUnit.DAYS.between(getDueDate(), today)); }

    @Override
    public String toString() {
        return "Loan[" + item.getTitle() + " -> " + member.getName() + ", due " + getDueDate() + "]";
    }
}
