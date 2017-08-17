package readers;

import objects.User;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class XMLReaderTest {


    @BeforeClass
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

    @AfterClass
    public static void tearDown() throws IOException {
        FileUtils.deleteDirectory(new File("TestFolder"));

    }

    XMLReader xmlReader;
    List<User> results;
    @Test
    public void read() throws Exception {

        xmlReader =  new XMLReader("data/users.xml");
        results = xmlReader.read();
        assertEquals(results.size(), 3);
        assertEquals(results.get(0).getFirstName(), "John");
    }

    @Test
    public void write() throws Exception {

        xmlReader =  new XMLReader("TestFolder/users.xml");
        results = xmlReader.read();
        xmlReader.write(results);
        File f = new File("TestFolder/users.xml");
        assertEquals(f.exists(), true);
    }

}