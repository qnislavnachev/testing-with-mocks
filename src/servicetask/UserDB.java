package servicetask;

import java.util.Map;

public interface UserDB {

    void addUser(User user);

    User findUser(String name);
}
