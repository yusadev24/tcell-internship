package org.atmosware.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DbReadManager {

    public static void startDbReadThreads() {

        try(ExecutorService executorService = Executors.newFixedThreadPool(3)) {

            executorService.execute(() -> new DbReadTask("readUsers"));
            executorService.execute(() -> new DbReadTask("readAccounts"));
            executorService.execute(() -> new DbReadTask("readAddresses"));

        } catch(Exception e){
            e.printStackTrace();
        }

        //

//        Thread readUsersThread = new Thread(new DbReadTask("readUsers"));
//        Thread readAccountsThread = new Thread(new DbReadTask("readAccounts"));
//        Thread readAddressesThread = new Thread(new DbReadTask("readAddresses"));
//
//        try {
//            readUsersThread.start();
//            readUsersThread.join();
//            readAccountsThread.start();
//            readAccountsThread.join();
//            readAddressesThread.start();
//            readAddressesThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
