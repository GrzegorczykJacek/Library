import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {



    //given
    Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 1,121L);
    Book book2 = new Book("Pochłaniacz", "Katarzyna Bonda", 1,122L);
    Book book3 = new Book("Okularnik", "Katarzyna Bonda",1, 123L);
    Book book4 = new Book("Gniew", "Zygmunt Miłoszewski", 1,131L);
    Book book5 = new Book("Ziarno prawdy", "Zygmunt Miłoszewski", 1,132L);
    Book book6 = new Book("Uwikłanie", "Zygmunt Miłoszewski", 2,133L);



    @Test
    public void testAddUser(){
        // given
        Adress address = new Adress("Racławickie", "Lublin", "12-345","8","12");
        User givUser = new User(1001L, "Jan", "Kowalski", "jan.kowalski@mail.pl", address);
        Library library = new Library();
        library.addUser(givUser);
        // when
        // then

        assertEquals(1, library.getUsersList().size());
        assertEquals("Jan", library.getUsersList().get(0).getFirstName());
        assertEquals("Kowalski", library.getUsersList().get(0).getLastName());
        assertEquals("jan.kowalski@mail.pl", library.getUsersList().get(0).getEmail());
        assertEquals("Racławickie", library.getUsersList().get(0).getAdress().getStreet());
    }
}
