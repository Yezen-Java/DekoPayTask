package com.company;


public class Main {

    public static void main(String[] args) {
	// write your code here

     CSVReader json = new CSVReader("data/users.csv");
     json.read();

        for (User user: json.getUsers()) {
            System.out.println(user.toString());
        }

    }
}
