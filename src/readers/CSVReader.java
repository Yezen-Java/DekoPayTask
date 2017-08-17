package readers;

import objects.User;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader extends FileReader implements ReaderWriterInterface{

    public CSVReader(String filePath) {
        super(filePath);
    }

    @Override
    public List<User> read() {
        try (Scanner scanner = new Scanner(new java.io.FileReader(getFilePath()))) {
            scanner.nextLine(); // to get ride of headers
            while (scanner.hasNext()) {
                String[] fields = scanner.nextLine().split(",");
                super.addUser(new User(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.getUsers();
    }

    @Override
    public void write(List<User> users) {

        Object[] columns = {"User ID","First Name","Last Name","Username","User Type","Last Login Time"};

        FileWriter fileWriter = null;

        CSVPrinter csvFilePrinter = null;

        // Create the CSVFormat object with "\n" as a record delimiter
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");

        try {

            // initialize FileWriter object
            fileWriter = new FileWriter(getFilePath());

            // initialize CSVPrinter object
            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

            // Create CSV file header
            csvFilePrinter.printRecord(columns);

            //Write a new student object list to the CSV file
            for (User user : users) {
                List userTemp = new ArrayList(); // auto unboxing
                userTemp.add(user.getUserId());
                userTemp.add(user.getFirstName());
                userTemp.add(user.getLastName());
                userTemp.add(user.getUserName());
                userTemp.add(user.getUserType());
                userTemp.add(user.getLastLoginTIme());
                csvFilePrinter.printRecord(userTemp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvFilePrinter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
