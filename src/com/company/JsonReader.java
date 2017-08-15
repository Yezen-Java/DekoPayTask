package com.company;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yezenalnafei on 15/08/2017.
 */
public class JsonReader extends IOFile {

    private String filePath;

    public JsonReader(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public void read() {

        try {
            User[] reviews = new Gson().fromJson(new FileReader(filePath), User[].class);
            List<User> asList = Arrays.asList(reviews);

            for ( User  user: asList) {
                System.out.println(user.getUserId());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void write() {

    }
}
