package readers;

import objects.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yezenalnafei on 14/08/2017.
 */
public class FileReader {

private List<User> users = new ArrayList<>();

    private final String filePath;

    public FileReader(String filePath){
        this.filePath = filePath;
    }

    public void outputToFile(String content){

        File file;
        FileWriter fileWriter = null;

        try {
         file = new File(filePath);
            fileWriter= new FileWriter(file, false);
            fileWriter.write(content);
            fileWriter.close();
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
