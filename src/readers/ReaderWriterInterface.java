package readers;

import objects.User;

import java.util.List;

/**
 * Created by yezenalnafei on 16/08/2017.
 */
public interface ReaderWriterInterface {

     List<User> read();

     void write(List<User> users);
}
