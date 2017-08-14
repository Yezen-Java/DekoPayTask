package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yezenalnafei on 14/08/2017.
 */
public class Reader {

private List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers(){
        return users;
    }

}
