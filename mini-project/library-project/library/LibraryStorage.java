import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * CSV persistence. Files:
 *   items.csv   : type,id,title,extra(author|runtimeMinutes)
 *   members.csv : id,name
 *   loans.csv   : itemId,memberId,loanDate
 * Fields are written with commas and newlines replaced so a simple split(",") is safe.
 */
public class LibraryStorage {
    private final Path dir;

    public LibraryStorage(Path dir) { this.dir = dir; }

    public void save(Library lib) throws IOException {
        Files.createDirectories(dir);

        List<String> items = new ArrayList<>();
        List<String> loans = new ArrayList<>();
        for (LibraryItem i : lib.getItems().values()) {
            String extra = (i instanceof Book b) ? b.getAuthor() : String.valueOf(((Dvd) i).getRuntimeMinutes());
            items.add(String.join(",", i.type(), clean(i.getId()), clean(i.getTitle()), clean(extra)));
            if (!i.isAvailable()) {
                Loan l = i.getCurrentLoan();
                loans.add(String.join(",", i.getId(), l.getMember().getId(), l.getLoanDate().toString()));
            }
        }
        List<String> members = lib.getMembers().values().stream()
                .map(m -> clean(m.getId()) + "," + clean(m.getName())).toList();

        Files.write(dir.resolve("items.csv"), items);
        Files.write(dir.resolve("members.csv"), members);
        Files.write(dir.resolve("loans.csv"), loans);
    }

    public Library load() throws IOException {
        Library lib = new Library();
        Path itemsFile = dir.resolve("items.csv");
        Path membersFile = dir.resolve("members.csv");
        Path loansFile = dir.resolve("loans.csv");

        if (Files.exists(membersFile)) {
            for (String line : Files.readAllLines(membersFile)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",", 2);
                lib.registerMember(new Member(p[0], p[1]));
            }
        }
        if (Files.exists(itemsFile)) {
            for (String line : Files.readAllLines(itemsFile)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",", 4);
                if (p[0].equals("BOOK")) lib.addItem(new Book(p[1], p[2], p[3]));
                else lib.addItem(new Dvd(p[1], p[2], Integer.parseInt(p[3])));
            }
        }
        if (Files.exists(loansFile)) {
            for (String line : Files.readAllLines(loansFile)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",");
                try {
                    lib.borrow(p[1], p[0], LocalDate.parse(p[2]));
                } catch (ItemNotAvailableException | MemberLimitExceededException e) {
                    throw new IOException("Corrupt loans.csv: " + e.getMessage(), e);
                }
            }
        }
        return lib;
    }

    private static String clean(String s) { return s.replace(",", ";").replace("\n", " "); }
}
