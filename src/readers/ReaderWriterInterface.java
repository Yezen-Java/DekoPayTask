package readers;

import objects.User;

import java.util.List;

public interface ReaderWriterInterface {

     List<User> read();

     void write(List<User> users);
}
