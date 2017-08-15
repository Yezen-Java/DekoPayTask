package com.company;

import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

/**
 * Created by yezenalnafei on 15/08/2017.
 */
public class Users {

    private String directory;
    public List<User> users;

    public Users(String directory){
        this.directory = directory;
        users = new ArrayList<>();
    }

    public void traverseDirectory(){

        File fileDic = new File(directory);

        if (fileDic.isDirectory()){

            String[] files = fileDic.list();

            for (String fileName: files){
                String filePath = directory +"/"+fileName;
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

                System.out.println(users.size());
            }

        }else{
            try {
                throw new NotDirectoryException(directory+" Is not a directory");
            } catch (NotDirectoryException e) {
                e.printStackTrace();
            }
        }
    }


    public List<User> getStoredList(){
        Collections.sort(users);
        return users;
    }
}
