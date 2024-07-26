package org.atmosware;

import org.atmosware.database.DatabaseConnection;

import java.sql.*;

public class Table {
    public void createTables() {
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "username VARCHAR(255) NOT NULL, " +
                "email VARCHAR(255) NOT NULL, " +
                "password VARCHAR(255) NOT NULL)";

        String createAccountsTable = "CREATE TABLE IF NOT EXISTS accounts (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "user_id INT, " +
                "balance DECIMAL(15, 2), " +
                "FOREIGN KEY (user_id) REFERENCES users(id))";

        String createTransactionsTable = "CREATE TABLE IF NOT EXISTS transactions (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "account_id INT, " +
                "amount DECIMAL(15, 2), " +
                "transaction_date TIMESTAMP, " +
                "FOREIGN KEY (account_id) REFERENCES accounts(id))";

        String createAddressTable = "CREATE TABLE IF NOT EXISTS address (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "account_id INT, " +
                "street VARCHAR(255), " +
                "city VARCHAR(255), " +
                "state VARCHAR(255), " +
                "zip_code VARCHAR(10), " +
                "FOREIGN KEY (account_id) REFERENCES accounts(id))";

        String createLogsTable = "CREATE TABLE IF NOT EXISTS logs (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "log_message VARCHAR(255), " +
                "log_date TIMESTAMP)";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createUsersTable);
            stmt.execute(createAccountsTable);
            stmt.execute(createTransactionsTable);
            stmt.execute(createAddressTable);
            stmt.execute(createLogsTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
