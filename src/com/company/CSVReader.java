package com.company;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yezenalnafei on 15/08/2017.
 */
public class CSVReader extends FileReader {

    private String filePath;

    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<User> read() {
        try (Scanner scanner = new Scanner(new java.io.FileReader(filePath))) {
            scanner.nextLine(); // to get ride of headers
            while (scanner.hasNext()) {
                String[] fields = scanner.nextLine().split(",");
                super.addUser(new User(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.getUsers();

    }

    @Override
    public void write() {

    }
}
