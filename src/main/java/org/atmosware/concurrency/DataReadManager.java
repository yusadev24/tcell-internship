package org.atmosware.concurrency;

public class DataReadManager {

    public static void startDataReadThreads() {
        // Create and start threads for concurrent operations
        Thread readUsersThread = new Thread(new DataReadTask("readUsers"));
        Thread readAccountsThread = new Thread(new DataReadTask("readAccounts"));
        Thread readAddressesThread = new Thread(new DataReadTask("readAddresses"));

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
