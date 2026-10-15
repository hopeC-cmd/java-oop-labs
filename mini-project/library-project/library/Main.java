import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryStorage storage = new LibraryStorage(Path.of(args.length > 0 ? args[0] : "data"));
        Library library;
        try {
            library = storage.load();
            System.out.println("Loaded " + library.getItems().size() + " items and "
                    + library.getMembers().size() + " members.");
        } catch (IOException | RuntimeException e) {
            System.out.println("Could not load saved data (" + e.getMessage() + "); starting empty.");
            library = new Library();
        }

        Scanner in = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printMenu();
            String choice = in.hasNextLine() ? in.nextLine().trim() : "0";
            try {
                switch (choice) {
                    case "1" -> addItem(library, in);
                    case "2" -> registerMember(library, in);
                    case "3" -> borrow(library, in);
                    case "4" -> giveBack(library, in);
                    case "5" -> listOverdue(library);
                    case "6" -> search(library, in);
                    case "0" -> running = false;
                    default -> System.out.println("Unknown option.");
                }
            } catch (ItemNotAvailableException | MemberLimitExceededException e) {
                System.out.println("Cannot borrow: " + e.getMessage());
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        try {
            storage.save(library);
            System.out.println("Data saved. Goodbye!");
        } catch (IOException e) {
            System.out.println("Failed to save data: " + e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println("""

                === Library Menu ===
                1. Add item
                2. Register member
                3. Borrow item
                4. Return item
                5. List overdue items
                6. Search by title
                0. Save and exit""");
        System.out.print("> ");
    }

    private static String ask(Scanner in, String prompt) {
        System.out.print(prompt + ": ");
        return in.nextLine().trim();
    }

    private static void addItem(Library lib, Scanner in) {
        String type = ask(in, "Type (B = book, D = dvd)").toUpperCase();
        String id = ask(in, "Item id");
        String title = ask(in, "Title");
        switch (type) {
            case "B" -> lib.addItem(new Book(id, title, ask(in, "Author")));
            case "D" -> {
                String text = ask(in, "Runtime in minutes");
                try {
                    lib.addItem(new Dvd(id, title, Integer.parseInt(text)));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Runtime must be a whole number");
                }
            }
            default -> throw new IllegalArgumentException("Type must be B or D");
        }
        System.out.println("Item added.");
    }

    private static void registerMember(Library lib, Scanner in) {
        lib.registerMember(new Member(ask(in, "Member id"), ask(in, "Name")));
        System.out.println("Member registered.");
    }

    private static void borrow(Library lib, Scanner in)
            throws ItemNotAvailableException, MemberLimitExceededException {
        String memberId = ask(in, "Member id");
        String itemId = ask(in, "Item id");
        lib.borrow(memberId, itemId);
        System.out.println("Borrowed. Due " + lib.findItem(itemId).getCurrentLoan().getDueDate());
    }

    private static void giveBack(Library lib, Scanner in) {
        lib.giveBack(ask(in, "Item id"));
        System.out.println("Item returned.");
    }

    private static void listOverdue(Library lib) {
        LocalDate today = LocalDate.now();
        List<Loan> overdue = lib.overdueLoans(today);
        if (overdue.isEmpty()) { System.out.println("No overdue items."); return; }
        overdue.forEach(l -> System.out.println(l + " (" + l.daysOverdue(today) + " days overdue)"));
    }

    private static void search(Library lib, Scanner in) {
        List<LibraryItem> results = lib.searchByTitle(ask(in, "Search text"));
        if (results.isEmpty()) System.out.println("No matches.");
        else results.forEach(System.out::println);
    }
}
