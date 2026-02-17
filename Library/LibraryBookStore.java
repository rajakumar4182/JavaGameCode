package Library;

import java.util.Scanner;

class Library {
    public String[] issueBook;
    public String[] availablebook;
    public int availableCount = 0;
    public int issueCount = 0;

    Library(int capacity) {
        this.availablebook = new String[capacity];
        this.issueBook = new String[capacity];
        this.availableCount = 0;
        this.issueCount = 0;
    }

    public void addBook(String book) {
        if (availableCount < availablebook.length) {
            availablebook[availableCount] = book;
            availableCount++;
            System.out.println(book + " Book has been added");
        } else {
            System.out.println("There is no space to add any book");
        }

    }

    public void issuedBook(String book) {
        for (int i = 0; i < availableCount; i++) {
            if (availablebook[i].equals(book)) {
                issueBook[issueCount] = book;
                issueCount++;

                for (int j = i; j < availableCount - 1; j++) {
                    availablebook[j] = availablebook[j + 1];
                }
                availablebook[availableCount - 1] = null;
                availableCount--;

                System.out.println(book + " Book has been issued");
                return;
            }
        }
        System.out.println("There is no such book present in the library");
    }

    public void returnBook(String Book) {
        for (int i = 0; i < issueCount; i++) {
            if (issueBook[i].equals(Book)) {
                for (int j = i; j < issueCount - 1; j++) {
                    issueBook[j] = issueBook[j + 1];
                }
                issueBook[issueCount - 1] = null;
                issueCount--;

                addBook(Book);
                System.out.println("Book has been returned to the library");
                return;
            }
        }
        System.out.println("No such book has been issued from this library");
    }

    public void showAvailableBook() {
        if (availableCount == 0) {
            System.out.println("No books are available.");
        } else {
            for (int i = 0; i < availableCount; i++) {
                int j = 1;
                System.out.println("Books are available are :-");
                System.out.println(j++ + ") " + availablebook[i]);
            }
        }

        System.out.println("---------------------------------");
    }
}

public class LibraryBookStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library l = new Library(3);

        for (int i = 0; i < 3; i++) {
            System.out.println(
                    "What do you want? Please type 1 for add,2 for issue ,3 for return or 4 for showAvailableBook");
            int userInput = sc.nextInt();
            sc.nextLine();

            switch (userInput) {
                case 1: {
                    System.out.println("Please Enter the book name to add in the library");
                    String bookName = sc.nextLine();
                    l.addBook(bookName);
                    break;
                }
                case 2: {
                    System.out.println("Please Enter the book name to issue from the library");
                    String bookName = sc.nextLine();
                    l.issuedBook(bookName);
                    break;
                }
                case 3: {
                    System.out.println("Please Enter the book name to return to the library");
                    String bookName = sc.nextLine();
                    l.returnBook(bookName);
                    break;
                }
                case 4: {
                    // System.out.println("Please Enter the book name to add in the library");
                    // String bookName = sc.nextLine();
                    l.showAvailableBook();
                    break;
                }
                default:
                    System.out.println("Invalid choice. Please select the proper choice");
            }
        }

        sc.close();

    }
}