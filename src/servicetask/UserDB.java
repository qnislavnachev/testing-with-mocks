package servicetask;

public interface UserDB {
    /**
     *Add user in database.
     */
    void add(User user);

    /**
     *Search user by name in data base and return object user.
     */
    User findUser(String name);
}
