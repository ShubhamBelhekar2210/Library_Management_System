package Library_Management_System;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Main class to run the Library Management System.
 */
public class LibraryManagementSystem {

	/**
     * Main method to start the Library Management System.
     *
     * @param args the command-line arguments
     * @throws SQLException if a database access error occurs
     */
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        BookDao bookDao = new BookDao();
        MemberDao memberDao = new MemberDao();

        System.out.println("\n****************Welcome to Library Management System!****************");
     // Implement console-based menu for operations
        
        int choice;
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Search for Book");
            System.out.println("5. Add Member");
            System.out.println("6. Update Member");
            System.out.println("7. Delete Member");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addBook(scanner, bookDao);
                    break;
                case 2:
                    updateBook(scanner, bookDao);
                    break;
                case 3:
                    deleteBook(scanner, bookDao);
                    break;
                case 4:
                    searchBook(scanner, bookDao);
                    break;
                case 5:
                    addMember(scanner, memberDao);
                    break;
                case 6:
                    updateMember(scanner, memberDao);
                    break;
                case 7:
                    deleteMember(scanner, memberDao);
                    break;
                case 8:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }

    private static void addBook(Scanner scanner, BookDao bookDao) {
        System.out.println("Enter book title:");
        String title = scanner.nextLine(); // Read title

        System.out.println("Enter book author:");
        String author = scanner.nextLine(); // Read author

        System.out.println("Enter book publisher:");
        String publisher = scanner.nextLine(); // Read publisher

        System.out.println("Enter publication year:");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left after reading the year

        Book newBook = new Book(title, author, publisher, year);
        if (bookDao.addBook(newBook)) {
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Failed to add book.");
        }
    }

    private static void updateBook(Scanner scanner, BookDao bookDao) {
        System.out.println("Enter book ID to update:");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new title:");
        String title = scanner.nextLine();
        System.out.println("Enter new author:");
        String author = scanner.nextLine();
        System.out.println("Enter new publisher:");
        String publisher = scanner.nextLine();
        System.out.println("Enter new publication year:");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left after reading the year

        Book updatedBook = new Book(title, author, publisher, year);
        if (bookDao.updateBook(updatedBook)) {
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Failed to update book.");
        }
    }

    private static void deleteBook(Scanner scanner, BookDao bookDao) {
        System.out.println("Enter book ID(s) to delete (comma separated):");
        String input = scanner.nextLine();
        String[] ids = input.split(",");
        boolean success = true;

        for (String idStr : ids) {
            try {
                int bookId = Integer.parseInt(idStr.trim());
                if (!bookDao.deleteBook(bookId)) {
                    success = false;
                    System.out.println("Failed to delete book with ID: " + bookId);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid book ID: " + idStr);
                success = false;
            }
        }

        if (success) {
            System.out.println("Book(s) deleted successfully.");
        } else {
            System.out.println("Failed to delete one or more books.");
        }
    }

    private static void searchBook(Scanner scanner, BookDao bookDao) {
        System.out.println("Enter search term:");
        String searchTerm = scanner.nextLine(); // Read search term

        List<Book> searchResults = bookDao.searchBooks(searchTerm);
        if (searchResults.isEmpty()) {
            System.out.println("No books found matching the search term.");
        } else {
            System.out.println("Search Results:");
            for (Book book : searchResults) {
                System.out.println(book);
            }
        }
    }

    private static void addMember(Scanner scanner, MemberDao memberDao) {
        System.out.println("Enter member name:");
        String name = scanner.nextLine();
        System.out.println("Enter member email:");
        String email = scanner.nextLine();
        System.out.println("Enter member phone:");
        String phone = scanner.nextLine();

        Member newMember = new Member(name, email, phone); // -1 as dummy ID
        if (memberDao.addMember(newMember)) {
            System.out.println("Member added successfully.");
        } else {
            System.out.println("Failed to add member.");
        }
    }

    private static void updateMember(Scanner scanner, MemberDao memberDao) {
        System.out.println("Enter member ID to update:");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new name:");
        String name = scanner.nextLine();
        System.out.println("Enter new email:");
        String email = scanner.nextLine();
        System.out.println("Enter new phone:");
        String phone = scanner.nextLine();

        Member updatedMember = new Member(name, email, phone);
        if (memberDao.updateMember(updatedMember)) {
            System.out.println("Member updated successfully.");
        } else {
            System.out.println("Failed to update member.");
        }
    }

    private static void deleteMember(Scanner scanner, MemberDao memberDao) {
        System.out.println("Enter member ID to delete:");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (memberDao.deleteMember(memberId)) {
            System.out.println("Member deleted successfully.");
        } else {
            System.out.println("Failed to delete member.");
        }
    }
}
