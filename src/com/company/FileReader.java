package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yezenalnafei on 14/08/2017.
 */
public abstract class FileReader {

private List<User> users = new ArrayList<>();

    private final String filePath;

    public abstract List<User> read();

    public abstract void write(List<User> users);


    public FileReader(String filePath){
        this.filePath = filePath;
    }


    public void outputToFile(String content){
        File file;
        FileWriter fooWriter = null;
        try {
         file = new File(filePath);
         fooWriter= new FileWriter(file, false);
            fooWriter.write(content);
            fooWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getFilePath(){
        return filePath;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void setUsers(List<User> users){
        this.users = users;
    }

    public List<User> getUsers(){
        return users;
    }


}
