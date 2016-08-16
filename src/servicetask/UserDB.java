package servicetask;

import java.util.Map;

public interface UserDB {

    boolean addUser(User user);

    User findUser(String name);
}
