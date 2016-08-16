package testUserRepository;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import servicetask.*;

import static org.junit.Assert.*;

public class UserTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    private Validator validator = context.mock(Validator.class);
    private UserDB userDB = context.mock(UserDB.class);
    private UserRepository userRepository = new UserRepository(userDB, validator);

    @Test
    public void registerUser() throws Exception {
        User iani = new User("iani", "23");

        context.checking(new Expectations() {{
            oneOf(validator).validate(iani);
            will(returnValue(true));

            oneOf(userDB).addUser(iani);
            will(returnValue(true));
        }});

        assertTrue(userRepository.registerUser(iani));
    }

    @Test(expected = UserException.class)
    public void registerUserIsTooOld() throws Exception {
        User iani = new User("iani", "101");

        context.checking(new Expectations() {{
            oneOf(validator).validate(iani);
            will(returnValue(false));
        }});

        userRepository.registerUser(iani);
    }

    @Test
    public void isAdult() throws Exception {
        User iani = new User("iani", "23");

        context.checking(new Expectations() {{
            oneOf(userDB).findUser(iani.name);
            will(returnValue(iani));
        }});

        assertTrue(userRepository.isAdult("iani"));
    }

    @Test
    public void isntAdult() throws Exception {
        User iani = new User("iani", "14");

        context.checking(new Expectations() {{
            oneOf(userDB).findUser(iani.name);
            will(returnValue(iani));
        }});

        assertFalse(userRepository.isAdult("iani"));
    }
}
