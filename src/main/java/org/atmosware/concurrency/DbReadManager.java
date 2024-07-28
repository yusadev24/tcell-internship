package org.atmosware.concurrency;

public class DbReadManager {

    public static void startDbReadThreads() {

        // Create and start threads for concurrent operations
        Thread readUsersThread = new Thread(new DbReadTask("readUsers"));
        Thread readAccountsThread = new Thread(new DbReadTask("readAccounts"));
        Thread readAddressesThread = new Thread(new DbReadTask("readAddresses"));

        try {
            readUsersThread.start();
            readUsersThread.join();
            readAccountsThread.start();
            readAccountsThread.join();
            readAddressesThread.start();
            readAddressesThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // synchronized ()
        /*

        Thread readUsersThread = new Thread(new DataReadTask("readUsers"));
        Thread readAccountsThread = new Thread(new DataReadTask("readAccounts"));
        Thread readAddressesThread = new Thread(new DataReadTask("readAddresses"));

        try(ExecutorService executorService = Executors.newFixedThreadPool(3)) {

            executorService.execute(() -> new DataReadTask("readUsers"));
            executorService.execute(() -> new DataReadTask("readAccounts"));
            executorService.execute(() -> new DataReadTask("readAddresses"));
            // readUsersThread.start();
            // readUsersThread.join();
            // readAccountsThread.start();
            // readAccountsThread.join();
            // readAddressesThread.start();
            // readAddressesThread.join();
        }
         */
    }
}
