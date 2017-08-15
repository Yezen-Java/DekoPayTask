package com.company;


import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Users users = new Users("data");
        users.traverseDirectory();

        System.out.println(users.users.size());



        for (User user: users.getStoredList()) {
            System.out.println(user.toString());
        }

    }
}
