package com.company;


import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yezenalnafei on 15/08/2017.
 */
public class JSONReader extends FileReader {

    private String filePath;

    public JSONReader(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public List<User> read() {

        try {
            User[] reviews = new Gson().fromJson(new java.io.FileReader(filePath), User[].class);
            List<User> users = Arrays.asList(reviews);
            super.setUsers(users);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return super.getUsers();

    }

    @Override
    public void write() {

    }
}
