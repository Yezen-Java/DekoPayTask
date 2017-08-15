package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yezenalnafei on 14/08/2017.
 */
public abstract class IOFile {

private List<User> users = new ArrayList<>();

    public abstract void read();
    public abstract void write();


    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers(){
        return users;
    }

}
