package com.company;

import java.util.Date;

/**
 * Created by yezenalnafei on 14/08/2017.
 */
public class User implements Comparable<User>{

    private String userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String userType;
    private String lastLoginTIme;

    public User(String userId, String firstName, String lastName, String userName, String userType, String lastLoginTIme) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userType = userType;
        this.lastLoginTIme = lastLoginTIme;
    }

    @Override
    public int compareTo(User user) {
      int thisObject =  Integer.parseInt(this.userId);
      int otherObject = Integer.parseInt(user.userId);
        if (thisObject > otherObject) return 1;
        else if(thisObject < otherObject) return -1;
        else return 0;
    }

    public int getUserId() {
        return Integer.parseInt(userId);
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


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", userType='" + userType + '\'' +
                ", lastLoginTIme='" + lastLoginTIme + '\'' +
                '}';
    }
}
