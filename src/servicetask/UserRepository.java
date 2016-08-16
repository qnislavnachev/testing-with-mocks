package servicetask;

public class UserRepository {
    private final UserDB userDB;
    private final Validator validator;

    public UserRepository(UserDB userDB, Validator validator) {
        this.userDB = userDB;
        this.validator = validator;
    }

    public boolean registerUser(User user) {
        if (validator.validate(user)) {
            return userDB.addUser(user);
        } else {
            throw new InvalidUserException("Invalid user");
        }
    }

    public boolean isAdult(String name) {
        User user = userDB.findUser(name);
        if (Integer.parseInt(user.age) >= 18) {
            return true;
        }
        return false;
    }
}
