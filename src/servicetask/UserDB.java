package servicetask;

public interface UserDB {

    void addUser(User user);

    User findUser(String name);
}
