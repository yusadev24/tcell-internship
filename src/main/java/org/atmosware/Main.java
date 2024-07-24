package org.atmosware;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.create();
        user.insert("Ali");
        user.insert("Ayşe");


        System.out.println("All the users in the database:");
        user.readAll();

        System.out.println("User with the id number of 1:");
        user.read(1);


        user.update(1, "Veli");
        System.out.println("Users after update:");
        user.readAll();

        user.delete(2);
        System.out.println("Users after deletion:");
        user.readAll();
    }
}