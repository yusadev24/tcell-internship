package org.atmosware;

import org.atmosware.operations.AccountOperations;
import org.atmosware.operations.AddressOperations;
import org.atmosware.operations.UserOperations;
import org.atmosware.utils.DataLoader;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        table.createTables();

        // Load data from files
        DataLoader.loadUsersFromFile("/files/users.txt");
        DataLoader.loadAccountsFromFile("/files/accounts.txt");
        DataLoader.loadAddressesFromFile("/files/addresses.txt");

        // User Operations
        System.out.println("\nReading Users:");
        UserOperations.getUser(1);
        UserOperations.getUser(2);

        System.out.println("\nUpdating User 1...");
        UserOperations.updateUser(1, "mehmetali", "mehmetali@gmail.com","newpassword123");

        System.out.println("\nReading all the Users:");
        UserOperations.readAllUsers();

        // Account Operations
        System.out.println("\nReading Accounts:");
        AccountOperations.getAccount(1);

        System.out.println("\nUpdating Account 1 Balance...");
        AccountOperations.updateAccount(1, new BigDecimal("1500.00"));

        System.out.println("\nReading Updated Account 1:");
        AccountOperations.getAccount(1);

        System.out.println("\nReading all the Accounts:");
        AccountOperations.readAllAccounts();

        // Address Operations
        System.out.println("\nReading Addresses:");
        AddressOperations.getAddress(1);

        System.out.println("\nUpdating Address 1...");
        AddressOperations.updateAddress(1, " 6/29", "Nilüfer/Bursa", "Türkiye", "61616");

        System.out.println("\nReading Updated Address 1:");
        AddressOperations.getAddress(1);

        System.out.println("\nDeleting Address 1...");
        AddressOperations.deleteAddress(1);

        System.out.println("\nDeleting Account 1...");
        AccountOperations.deleteAccount(1);

        System.out.println("\nDeleting User 2...");
        UserOperations.deleteUser(2);

        System.out.println("\nCreating new User:");
        UserOperations.createUser("ayse", "ayse@gmail.com", "sifre123");

        System.out.println("\nReading all the Users:");
        UserOperations.readAllUsers();

        System.out.println("\nReading all the Accounts:");
        AccountOperations.readAllAccounts();

        System.out.println("\nReading all the Addresses:");
        AddressOperations.readAllAddresses();

    }
}