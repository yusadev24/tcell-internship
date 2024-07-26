package org.atmosware.utils;

import org.atmosware.operations.AccountOperations;
import org.atmosware.operations.AddressOperations;
import org.atmosware.operations.UserOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataLoader {

    private static List<String> readFileLines(String filePath) {
        try (InputStream inputStream = DataLoader.class.getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + filePath, e);
        }
    }

    public static void loadUsersFromFile(String filePath) {
        List<String> userLines = readFileLines(filePath);
        System.out.println("\nCreating Users...");
        for (String userLine : userLines) {
            String[] userDetails = userLine.split(",");
            String username = userDetails[0];
            String email = userDetails[1];
            String password = userDetails[2];
            UserOperations.createUser(username, email, password);
        }
        System.out.println("\n");
    }

    public static void loadAccountsFromFile(String filePath) {
        List<String> accountLines = readFileLines(filePath);
        System.out.println("\nCreating Accounts...");
        for (String accountLine : accountLines) {
            String[] accountDetails = accountLine.split(",");
            int userId = Integer.parseInt(accountDetails[0]);
            BigDecimal balance = new BigDecimal(accountDetails[1]);
            AccountOperations.createAccount(userId, balance);
        }
        System.out.println("\n");

    }

    public static void loadAddressesFromFile(String filePath) {
        List<String> addressLines = readFileLines(filePath);
        System.out.println("\nCreating Addresses...");
        for (String addressLine : addressLines) {
            String[] addressDetails = addressLine.split(",");
            int accountId = Integer.parseInt(addressDetails[0]);
            String street = addressDetails[1];
            String city = addressDetails[2];
            String state = addressDetails[3];
            String zipCode = addressDetails[4];
            AddressOperations.createAddress(accountId, street, city, state, zipCode);
        }
        System.out.println("\n");

    }
}