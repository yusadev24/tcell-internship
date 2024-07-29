package org.atmosware.operations;

import org.atmosware.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class LogOperations {

    // You should ensure that these resources are closed in a finally block
    // or by using the try-with-resources statement in Java,
    // which automatically closes resources when they are no longer needed.

    public static synchronized void createLog(String logMessage, Timestamp logDate) {
        String sql = "INSERT INTO logs (log_message, log_date) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, logMessage);
            pstmt.setTimestamp(2, logDate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getLog(int id) {
        String sql = "SELECT * FROM logs WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Log Message: " + rs.getString("log_message"));
                System.out.println("Log Date: " + rs.getTimestamp("log_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readAllLogs() {
        String sql = "SELECT * FROM logs";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            System.out.println("---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Log Message: " + rs.getString("log_message"));
                System.out.println("Log Date: " + rs.getTimestamp("log_date"));
                System.out.println("---");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void updateLog(int id, String newLogMessage, Timestamp newLogDate) {
        String sql = "UPDATE logs SET log_message = ?, log_date = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newLogMessage);
            pstmt.setTimestamp(2, newLogDate);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void deleteLog(int id) {
        String sql = "DELETE FROM logs WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
