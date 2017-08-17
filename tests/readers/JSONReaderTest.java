package readers;

import objects.User;
import objects.Users;
import org.apache.commons.io.FileUtils;
import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class JSONReaderTest {

    @Before
    public static void setUpClass() {
        File file = new File("TestFolder");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }

    }

    @After
    public static void tearDown() throws IOException {
        FileUtils.deleteDirectory(new File("TestFolder"));

    }

    @Test
    public void read() throws Exception {

        JSONReader jsonReader = new JSONReader("data/users.json");
        List<User> results = jsonReader.read();

        assertEquals(results.size(), 5);
        assertEquals(results.get(0).getFirstName(), "Joe");
    }

    @Test
    public void write() throws Exception {

        JSONReader jsonReader = new JSONReader("data/users.json");
        List<User> results = jsonReader.read();
        JSONReader jsonReader2 = new JSONReader("TestFolder/users.json");
        jsonReader.write(results);

        File file = new File("TestFolder/users.json");

        assertEquals(file.exists(), true);



    }

}