import java.time.LocalDate;
import java.util.*;

/** Core service: owns the item and member collections. */
public class Library {
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();

    public void addItem(LibraryItem item) {
        if (item == null) throw new IllegalArgumentException("Item must not be null");
        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException("An item with id " + item.getId() + " already exists");
        }
        items.put(item.getId(), item);
    }

    public void registerMember(Member member) {
        if (member == null) throw new IllegalArgumentException("Member must not be null");
        if (members.containsKey(member.getId())) {
            throw new IllegalArgumentException("A member with id " + member.getId() + " already exists");
        }
        members.put(member.getId(), member);
    }

    public void borrow(String memberId, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        borrow(memberId, itemId, LocalDate.now());
    }

    public void borrow(String memberId, String itemId, LocalDate date)
            throws ItemNotAvailableException, MemberLimitExceededException {
        Member member = findMember(memberId);
        LibraryItem item = findItem(itemId);
        item.borrow(member, date); // checks availability and the limit, then records the loan
    }

    public void giveBack(String itemId) {
        findItem(itemId).giveBack();
    }

    public List<Loan> overdueLoans(LocalDate today) {
        return items.values().stream()
                .filter(i -> !i.isAvailable())
                .map(LibraryItem::getCurrentLoan)
                .filter(l -> l.isOverdue(today))
                .sorted(Comparator.comparing(Loan::getDueDate))
                .toList();
    }

    public List<LibraryItem> searchByTitle(String text) {
        String needle = text.toLowerCase();
        return items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(needle))
                .sorted(Comparator.comparing(LibraryItem::getTitle))
                .toList();
    }

    public LibraryItem findItem(String id) {
        LibraryItem item = items.get(id);
        if (item == null) throw new IllegalArgumentException("No item with id " + id);
        return item;
    }

    public Member findMember(String id) {
        Member m = members.get(id);
        if (m == null) throw new IllegalArgumentException("No member with id " + id);
        return m;
    }

    public Map<String, LibraryItem> getItems() { return Collections.unmodifiableMap(items); }
    public Map<String, Member> getMembers() { return Collections.unmodifiableMap(members); }
}
