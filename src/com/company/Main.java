package com.company;

public class Main {

    public static void main(String[] args) {

        Users users = new Users();
        users.traverseDirectory("data");
        users.generateFiles();

    }
}

