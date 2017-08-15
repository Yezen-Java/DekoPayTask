package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yezenalnafei on 14/08/2017.
 */
public abstract class FileReader {

private List<User> users = new ArrayList<>();

    public abstract List<User> read();
    public abstract void write();


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
