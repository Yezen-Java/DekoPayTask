package readers;

import objects.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class JSONReader extends FileReader implements ReaderWriterInterface {

    private Gson gson;

    public JSONReader(String filePath) {
        super(filePath);
        this.gson = new Gson();
    }

    @Override
    public List<User> read() {

        try {
            User[] reviews = gson.fromJson(new java.io.FileReader(getFilePath()), User[].class);
            List<User> users = Arrays.asList(reviews);
            setUsers(users);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return super.getUsers();
    }

    @Override
    public void write(List<User> users) {

        gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(users);

        outputToFile(jsonString);
    }
}
