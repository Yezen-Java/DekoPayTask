package objects;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class User implements Comparable<User>{

    @SerializedName(value = "user_id")
    private String userId;

    @SerializedName(value = "first_name")
    private String firstName;

    @SerializedName(value = "last_name")
    private String lastName;

    @SerializedName(value = "username")
    private String userName;

    @SerializedName(value = "user_type")
    private String userType;

    @SerializedName(value = "last_login_time")
    private String lastLoginTIme;

    public User(String userId, String firstName, String lastName, String userName, String userType, String lastLoginTIme) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userType = userType;
        this.lastLoginTIme = lastLoginTIme;
    }

    public String getUserId() {
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

    public String getLastLoginTIme() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ssZ");

        return sdf2.format(sdf.parse(lastLoginTIme));

    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setLastLoginTIme(String lastLoginTIme) {
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
