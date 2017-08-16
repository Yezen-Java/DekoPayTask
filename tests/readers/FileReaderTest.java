package readers;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by yezenalnafei on 17/08/2017.
 */
public class FileReaderTest {

    @BeforeClass
    public static void setUpClass() {
        File file = new File("FolderTest");
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
        FileUtils.deleteDirectory(new File("FolderTest"));

    }
    @Test
    public void outputToFile() throws Exception {

        CSVReader fileReader1 = new CSVReader("data/users.csv");
        CSVReader fileReader2 = new CSVReader("FolderTest/users.csv");
        fileReader2.write(fileReader1.read());

        File file = new File("FolderTest/users.csv");

        assertEquals(file.exists(), true);


    }

    @Test
    public void getFilePath() throws Exception {
    }

    @Test
    public void addUser() throws Exception {
    }

}