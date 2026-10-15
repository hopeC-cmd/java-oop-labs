# Mini-Project Report: Library Management System

**Authors:** _(add both pair members' names and student numbers)_
**Language:** Java 17+ (uses `switch` arrows, text blocks, pattern-matching `instanceof` and `Stream.toList()`)

## 1. Overview
A console application that manages a small library: adding books and DVDs, registering members, borrowing and returning items, listing overdue loans and searching by title. All data is saved to CSV files on exit and reloaded on start.

## 2. Design and how each requirement is met

| # | Requirement | Where / how |
|---|-------------|-------------|
| 1 | Book, Member, Loan with private fields, validation, `toString` | All fields are `private`; constructors throw `IllegalArgumentException` for blank ids/names/titles, non-positive runtime, null arguments. Each class overrides `toString`. |
| 2 | Abstract `LibraryItem`, subclasses `Book` / `Dvd` | `LibraryItem` holds `id`, `title`, availability and declares `abstract int loanPeriodDays()`. `Book` returns 21 days, `Dvd` returns 7 days. `Loan.getDueDate()` calls it polymorphically. |
| 3 | `Borrowable` interface | `borrow(Member)` and `giveBack()`; implemented once in `LibraryItem`, so Book and Dvd inherit identical, tested behaviour. |
| 4 | Custom exceptions, max 3 loans | `ItemNotAvailableException` and `MemberLimitExceededException` are checked exceptions. The limit (`Member.MAX_LOANS = 3`) is enforced in `Member.addLoan`. |
| 5 | `Map<String, ...>` keyed by id | `Library` keeps `Map<String, LibraryItem>` and `Map<String, Member>` (HashMap). Duplicate ids are rejected; unknown ids raise `IllegalArgumentException`. |
| 6 | CSV persistence | `LibraryStorage` writes `items.csv`, `members.csv`, `loans.csv` to a `data/` folder on exit and rebuilds the library on start. Loans are re-created through the normal `borrow` path so rules are re-checked. |
| 7 | Menu incl. stream search | `Main` offers: add item, register member, borrow, return, list overdue, search, save and exit. `searchByTitle` and `overdueLoans` use `stream().filter().sorted().toList()`. |

### Key decisions
- **Borrow logic lives in `LibraryItem`**, and `Library.borrow` just looks up the member and item and delegates. The `Loan` is only attached to the member after the limit check passes, so a failed borrow leaves no partial state.
- **Item availability is checked before the member limit**, so the user sees the most specific error.
- **Dates are injectable** (`borrow(member, date)`, `overdueLoans(today)`), which makes overdue behaviour testable and lets CSV loading restore the original loan date.
- **CSV simplicity:** commas in text fields are replaced with `;` when saving so a plain `split(",")` is safe.
- **Error handling in `Main`:** checked exceptions and validation errors are caught in the menu loop and shown as messages, so bad input never crashes the program.

## 3. Testing
A scripted session was run against the compiled program:

| Test | Result |
|------|--------|
| Add 3 books and 1 DVD, register a member | Success |
| Borrow 3 items | Success, due dates 21 days ahead |
| 4th borrow by the same member | `MemberLimitExceededException` message shown |
| Borrow an item already on loan | `ItemNotAvailableException` message shown |
| Borrow with unknown member id | "No member with id ..." |
| Duplicate member id | "already exists" |
| Search "java" (case-insensitive) | Results sorted by title |
| Return an item, return it again | Success, then "not on loan" |
| Exit, restart | Items, members and open loans reloaded from CSV |
| Loan dated 2026-09-01 | Listed as overdue (due 2026-09-22) |

## 4. Limitations and possible improvements
- Passwords/roles, fines and reservations are not modelled.
- CSV is deliberately simple; a library such as OpenCSV would handle quoting properly.
- Unit tests (JUnit) could replace the manual scripted session.

## 5. How to run
```
cd library
javac -d out *.java
java -cp out Main          # data stored in ./data
```

## 6. Division of work
_(Fill in who did what: e.g. Partner A – model classes and exceptions; Partner B – Library, storage and menu.)_
