package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by yezenalnafei on 15/08/2017.
 */
public class CSVReader extends IOFile {

    private String filePath;

    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void read() {
        String line;
        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
            scanner.nextLine(); // to get ride of headers
            while (scanner.hasNext()) {
                String[] fields = scanner.nextLine().split(",");
                super.addUser(new User(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void write() {

    }
}
