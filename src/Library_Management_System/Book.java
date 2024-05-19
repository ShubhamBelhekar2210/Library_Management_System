package Library_Management_System;

/**
 * Represents a book in the library.
 */

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private int year;
    
    /**
     * Constructs a new Book object.
     *
     * @param bookId    the ID of the book
     * @param title     the title of the book
     * @param author    the author of the book
     * @param publisher the publisher of the book
     * @param year      the publication year of the book
     */

    public Book(String title, String author, String publisher, int year) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Publisher: " + publisher + ", Year: " + year;
    }
}
