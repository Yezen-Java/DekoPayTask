package readers;

        import objects.User;
        import org.junit.Test;

        import java.util.List;

        import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
        import static org.junit.Assert.*;

/**
 * Created by yezenalnafei on 16/08/2017.
 */
public class CSVReaderTest {

    CSVReader csvReader;
    @Test
    public void read() throws Exception {
        csvReader =  new CSVReader("data/users.csv");
        List<User>  results = csvReader.read();
        assertEquals(results.size(), 2);
        assertEquals(results.get(0).getFirstName(), "David");

    }

//    @Test
//    public void write() throws Exception {
//        csvReader = new CSVReader("output.")
//
//    }

}