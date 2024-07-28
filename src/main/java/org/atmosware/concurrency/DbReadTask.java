package org.atmosware.concurrency;

import org.atmosware.operations.AccountOperations;
import org.atmosware.operations.AddressOperations;
import org.atmosware.operations.UserOperations;

public class DbReadTask implements Runnable{
    private final String operationType;

    public DbReadTask(String opeartionType) {
        this.operationType = opeartionType;
    }

    @Override
    public void run() {
        switch (operationType) {
            case "readUsers":
                System.out.println("\nReading all the Users:");
                UserOperations.readAllUsers();
                break;
            case "readAccounts":
                System.out.println("\nReading all the Accounts:");
                AccountOperations.readAllAccounts();
                break;
            case "readAddresses":
                System.out.println("\nReading all the Addresses:");
                AddressOperations.readAllAddresses();
                break;
        }
    }
}
