package Library_Management_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Gets all books from the database.
 *
 * @return a list of all books
 */

public class MemberDao {
    private Connection con;

    /**
     * Constructs a MemberDao and establishes a database connection.
     */
    
    public MemberDao() throws SQLException {
        con = DatabaseConnection.getConnection();
    }

    /**
     * Adds a member to the database.
     *
     * @param member the member to add
     */
    
    public boolean addMember(Member member) {
        String query = "INSERT INTO members (name, email, phone) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPhone());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding member:");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Updates a member in the database.
     *
     * @param member the member to update
     */
    
    public boolean updateMember(Member member) {
        String query = "UPDATE members SET name=?, email=?, phone=? WHERE member_id=?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPhone());
            pstmt.setInt(4, member.getMemberId());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating member:");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deletes a member from the database.
     *
     * @param memberId the ID of the member to delete
     */
    
    public boolean deleteMember(int memberId) {
        String query = "DELETE FROM members WHERE member_id=?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, memberId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting member:");
            e.printStackTrace();
            return false;
        }
    }
}
