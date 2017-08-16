package readers;

        import objects.User;
        import org.apache.commons.io.FileUtils;
        import org.junit.AfterClass;
        import org.junit.BeforeClass;
        import org.junit.Test;

        import java.io.File;
        import java.io.IOException;
        import java.util.List;

        import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
        import static org.junit.Assert.*;

/**
 * Created by yezenalnafei on 16/08/2017.
 */
public class CSVReaderTest {

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

    CSVReader csvReader;
    List<User>  results;
    @Test
    public void read() throws Exception {
        csvReader =  new CSVReader("data/users.csv");
        results = csvReader.read();
        assertEquals(results.size(), 2);
        assertEquals(results.get(0).getFirstName(), "David");
    }

    @Test
    public void write() throws Exception {
        csvReader =  new CSVReader("TestFolder/users.csv");
        results = csvReader.read();
        csvReader.write(results);
        File f = new File("TestFolder/users.csv");
        assertEquals(f.exists(), true);
    }

}