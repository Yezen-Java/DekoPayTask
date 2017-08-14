package com.company;

import java.util.Date;

/**
 * Created by yezenalnafei on 14/08/2017.
 */
public class User implements Comparable<User>{

    private int userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String userType;
    private String lastLoginTIme;

    public User(int userId, String firstName, String lastName, String userName, String userType, String lastLoginTIme) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userType = userType;
        this.lastLoginTIme = lastLoginTIme;
    }

    @Override
    public int compareTo(User user) {
        if (this.userId > user.userId) return 1;
        else if(this.userId < user.userId) return -1;
        else return 0;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserType() {
        return userType;
    }

    public String getLastLoginTIme() {
        return lastLoginTIme;
    }
}
