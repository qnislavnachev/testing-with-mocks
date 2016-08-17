package servicetask;

public class UserRepository {
    private final UserDB userDB;
    private final Validator validator;

    public UserRepository(UserDB userDB, Validator validator) {
        this.userDB = userDB;
        this.validator = validator;
    }

    /**
     * This method register user in database.
     * If user is not valid it throw exception.
     */
    public void registerUser(User user) {
        if (!validator.validate(user)) {
            throw new UserException("Invalid user");
        }
        userDB.add(user);
    }

    /**
     * This method check for user in database
     * if he is adult return true, if not return false.
     */
    public boolean isAdult(String name) {
        User user = userDB.findUser(name);
        if (user == null) {
            throw new UserException("User does not exist in DB");
        }
        return (Integer.parseInt(user.age) >= 18);
    }
}
