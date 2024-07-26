package org.atmosware;

import org.atmosware.operations.AccountOperations;
import org.atmosware.operations.AddressOperations;
import org.atmosware.operations.UserOperations;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        table.createTables();

        // User Operations
        System.out.println("Creating Users:");
        UserOperations.createUser("mehmet", "mehmet@gmail.com", "password123");
        UserOperations.createUser("ahmet", "ahmet@gmail.com", "placeholder213");

        System.out.println("Reading Users:");
        UserOperations.getUser(1);
        UserOperations.getUser(2);

        System.out.println("Updating User 1:");
        UserOperations.updateUser(1, "mehmetali", "mehmetali@gmail.com","newpassword123");

        System.out.println("Reading Updated User 1:");
        UserOperations.getUser(1);

        System.out.println("Deleting User 2:");
        UserOperations.deleteUser(2);

        // Account Operations
        System.out.println("\nCreating Accounts:");
        AccountOperations.createAccount(1, new BigDecimal("2000.00"));

        System.out.println("Reading Accounts:");
        AccountOperations.getAccount(1);

        System.out.println("Updating Account 1 Balance:");
        AccountOperations.updateAccount(1, new BigDecimal("1500.00"));

        System.out.println("Reading Updated Account 1:");
        AccountOperations.getAccount(1);

//        System.out.println("Deleting Account 1:");
//        AccountOperations.deleteAccount(1);

        // Address Operations
        System.out.println("\nCreating Addresses:");
        AddressOperations.createAddress(1, "18/9 Virajlı sok.", "Çankaya/Ankara", "Türkiye", "60606");

        System.out.println("Reading Addresses:");
        AddressOperations.getAddress(1);

        System.out.println("Updating Address 1:");
        AddressOperations.updateAddress(1, " 12/5 Elma sokak", "Beylikdüzü/İstanbul", "Türkiye", "62705");

        System.out.println("Reading Updated Address 1:");
        AddressOperations.getAddress(1);

        System.out.println("Deleting Address 1:");
        AddressOperations.deleteAddress(1);
    }
}