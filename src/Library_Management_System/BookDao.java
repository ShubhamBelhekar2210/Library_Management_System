package Library_Management_System;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) for books.
 */

public class BookDao {
    private Connection con;

    /**
     * Constructs a BookDao and establishes a database connection.
     */
    
    public BookDao() throws SQLException {
        con = DatabaseConnection.getConnection();
    }

    /**
     * Adds a book to the database.
     *
     * @param book the book to add
     */
    
    public boolean addBook(Book book) {
        String query = "INSERT INTO books (title, author, publisher, year) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getPublisher());
            pstmt.setInt(4, book.getYear());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error adding book:");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Updates a book in the database.
     *
     * @param book the book to update
     */
    
    public boolean updateBook(Book book) {
        String query = "UPDATE books SET title=?, author=?, publisher=?, year=? WHERE book_id=?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getPublisher());
            pstmt.setInt(4, book.getYear());
            pstmt.setInt(5, book.getBookId());
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Error updating book:");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deletes a book from the database.
     *
     * @param bookId the ID of the book to delete
     */
    
    public boolean deleteBook(int bookId) {
        String query = "DELETE FROM books WHERE book_id=?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, bookId);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting book:");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Gets a book by its ID.
     *
     * @param bookId the ID of the book
     * @return the book with the specified ID, or null if not found
     */
    
    public Book getBookById(int bookId) {
        String query = "SELECT * FROM books WHERE book_id=?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, bookId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("year")
                );
            } else {
                System.out.println("No book found with the specified ID.");
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving book:");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Searches for books by title or author.
     *
     * @param searchTerm the search term
     * @return a list of books matching the search term
     */
    
    public List<Book> searchBooks(String searchTerm) {
        List<Book> searchResults = new ArrayList<>();
        String query = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, "%" + searchTerm + "%");
            pstmt.setString(2, "%" + searchTerm + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                searchResults.add(new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("year")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error searching books:");
            e.printStackTrace();
        }
        return searchResults;
    }
}
