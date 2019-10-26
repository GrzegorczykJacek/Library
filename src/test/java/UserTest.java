import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testUserConstrustor(){
        // given
        Adress adress = new Adress("Racławickie", "Lublin", "12-345", "8","10");
        Adress adress1 = new Adress("Krakowskie", "Lublin", "12-345", "10","12");
        Adress adress2 = new Adress("Orkana", "Lublin", "12-345", "1","2");
        User user = new User("Janek", "Dzbanek", "janek.dzbanek@amail.pl", adress );
        User user1 = new User("Janina", "Dzbanek", "janina.dzbanek@amail.pl", adress1 );
        User user2 = new User("Janek", "Dzbanek", "janek.dzbanek@amail.pl", adress2 );
        // when
        // then

        assertNotNull(java.util.Optional.ofNullable(user.getIdUser()));
        assertNotNull(java.util.Optional.ofNullable(user1.getIdUser()));
        assertNotNull(java.util.Optional.ofNullable(user2.getIdUser()));

    }
}