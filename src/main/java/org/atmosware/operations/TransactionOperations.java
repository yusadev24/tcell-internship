package org.atmosware.operations;

import org.atmosware.database.DatabaseConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TransactionOperations {
    public static synchronized void createTransaction(int accountId, BigDecimal amount, Timestamp transactionDate) {
        String sql = "INSERT INTO transactions (account_id, amount, transaction_date) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, accountId);
            pstmt.setBigDecimal(2, amount);
            pstmt.setTimestamp(3, transactionDate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getTransaction(int id) {
        String sql = "SELECT * FROM transactions WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Account ID: " + rs.getInt("account_id"));
                System.out.println("Amount: " + rs.getBigDecimal("amount"));
                System.out.println("Transaction Date: " + rs.getTimestamp("transaction_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readAllTransactions() {
        String sql = "SELECT * FROM transactions";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            System.out.println("---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Account ID: " + rs.getInt("account_id"));
                System.out.println("Amount: " + rs.getBigDecimal("amount"));
                System.out.println("Transaction Date: " + rs.getTimestamp("transaction_date"));
                System.out.println("---");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void updateTransaction(int id, BigDecimal newAmount, Timestamp newTransactionDate) {
        String sql = "UPDATE transactions SET amount = ?, transaction_date = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBigDecimal(1, newAmount);
            pstmt.setTimestamp(2, newTransactionDate);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void deleteTransaction(int id) {
        String sql = "DELETE FROM transactions WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
