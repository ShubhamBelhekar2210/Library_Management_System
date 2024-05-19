# Library_Management_System

## Overview

The Library Management System is a Java-based application that allows users to manage books and members in a library. The system provides functionalities to add, update, delete, and search for books and members.

## Features

- Add, update, delete, and search for books.
- Add, update, and delete members.
- Console-based user interface for interaction.

## Requirements
- Java 8 or later
- MySQL database
- MySQL Connector/J

## Project Structure

Library_Management_System/
│
├── src/
│ ├── Library_Management_System/
│ │ ├── Book.java
│ │ ├── BookDao.java
│ │ ├── DatabaseConnection.java
│ │ ├── LibraryManagementSystem.java
│ │ ├── Member.java
│ │ ├── MemberDao.java
│

## Usage

Upon running the application, a console-based menu will appear:

Welcome to Library Management System!

Select an option:

Add Book
Update Book
Delete Book
Search for Book
Add Member
Update Member
Delete Member
Exit
Enter your choice:

Follow the prompts to perform the desired operations.

## Classes and Their Responsibilities

- **Book**: Represents a book entity with attributes such as title, author, publisher, and year.
- **BookDao**: Data Access Object (DAO) for performing CRUD operations on the `books` table.
- **Member**: Represents a library member with attributes such as name, email, and phone.
- **MemberDao**: Data Access Object (DAO) for performing CRUD operations on the `members` table.
- **DatabaseConnection**: Handles the connection to the MySQL database.
- **LibraryManagementSystem**: Main class that provides the console-based user interface.

## Setup Instructions

### Step 1: Setting Up the Database

1. **Install MySQL**: If you haven't installed MySQL, you can download and install it from [MySQL Downloads](https://dev.mysql.com/downloads/).

2. **Create Database and Tables**: Use the following SQL script to create the database and the necessary tables. You can execute these queries using MySQL Workbench or any other MySQL client.

    ```sql
    -- Create the database
    CREATE DATABASE library_management;

    -- Use the newly created database
    USE library_management;

    -- Create the `books` table
    CREATE TABLE books (
        book_id INT AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
        author VARCHAR(255) NOT NULL,
        publisher VARCHAR(255) NOT NULL,
        year INT NOT NULL
    );

    -- Create the `members` table
    CREATE TABLE members (
        member_id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL,
        phone VARCHAR(20) NOT NULL
    );
    ```

### Step 2: Setting Up MySQL Connectivity

1. **Download MySQL Connector/J**: Download the latest version of MySQL Connector/J from [MySQL Connector/J download page](https://dev.mysql.com/downloads/connector/j/).

2. **Add Connector to Project**: Add the downloaded `mysql-connector-java-x.x.xx.jar` file to your project's classpath.

3. **Create Database Connection Class**:
   Create a class named `DatabaseConnection` to manage the database connection.

    ```java
    package Library_Management_System;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class DatabaseConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/library_management";
        private static final String USER = "root";
        private static final String PASSWORD = "your_password";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }
    ```

### Step 3: Running the Application

1. **Compile the Project**: Ensure all your Java files are compiled.

2. **Run the Application**: Execute the `LibraryManagementSystem` main class.

3. **Interact with the Console**: Follow the console prompts to add, update, delete, and search for books and members.

## Notes

- Make sure to replace `your_password` in the `DatabaseConnection` class with your actual MySQL root password.
- If your MySQL server is running on a different host or port, update the `URL` in the `DatabaseConnection` class accordingly.

## Author
- Shubham Belhekar (+91 7030346078)

## License
This project is licensed under the MIT License.

