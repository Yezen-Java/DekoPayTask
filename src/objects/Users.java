package objects;

import readers.CSVReader;
import readers.JSONReader;
import readers.XMLReader;

import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Users {

    public List<User> users;

    public void setUsers(List<User> users) {

        Collections.sort(users);
        this.users = users;
    }


    public void traverseDirectory(String path){

        List<User> users = new ArrayList<>();
        File fileDic = new File(path);

        if (fileDic.isDirectory()){

            String[] files = fileDic.list();

            for (String fileName: files){

                String filePath = "data" +"/"+fileName;
                String ext = FilenameUtils.getExtension(fileName).toLowerCase();
                List<User> tempUsers;
                switch (ext){
                    case "json": tempUsers = new JSONReader(filePath).read();
                        break;
                    case "xml": tempUsers = new XMLReader(filePath).read();
                        break;
                    case "csv": tempUsers = new CSVReader(filePath).read();
                        break;
                    default: tempUsers = null;
                }

                users.addAll(tempUsers);
            }

        }else{
            try {
                throw new NotDirectoryException("Path is not a directory");
            } catch (NotDirectoryException e) {
                e.printStackTrace();
            }
        }

        setUsers(users);
    }

    public void generateFiles(){

        String path = "output/users";

        new XMLReader(path+".xml").write(users);
        new JSONReader(path+".json").write(users);
        new CSVReader(path+".csv").write(users);
    }

    public List<User> getUsers(){
        return users;
    }
}
