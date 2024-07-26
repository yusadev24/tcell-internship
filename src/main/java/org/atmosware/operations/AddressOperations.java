package org.atmosware.operations;

import org.atmosware.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressOperations {
    public static void createAddress(int accountId, String street, String city, String state, String zipCode) {
        String sql = "INSERT INTO address (account_id, street, city, state, zip_code) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, accountId);
            pstmt.setString(2, street);
            pstmt.setString(3, city);
            pstmt.setString(4, state);
            pstmt.setString(5, zipCode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void getAddress(int id) {
        String sql = "SELECT * FROM address WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Account ID: " + rs.getInt("account_id"));
                System.out.println("Street: " + rs.getString("street"));
                System.out.println("City: " + rs.getString("city"));
                System.out.println("State: " + rs.getString("state"));
                System.out.println("Zip Code: " + rs.getString("zip_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateAddress(int id, String newStreet, String newCity, String newState, String newZipCode) {
        String sql = "UPDATE address SET street = ?, city = ?, state = ?, zip_code = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newStreet);
            pstmt.setString(2, newCity);
            pstmt.setString(3, newState);
            pstmt.setString(4, newZipCode);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAddress(int id) {
        String sql = "DELETE FROM address WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
