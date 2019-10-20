import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {



    //given
    Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 121L);
    Book book2 = new Book("Pochłaniacz", "Katarzyna Bonda", 122L);
    Book book3 = new Book("Okularnik", "Katarzyna Bonda", 123L);
    Book book4 = new Book("Gniew", "Zygmunt Miłoszewski", 131L);
    Book book5 = new Book("Ziarno prawdy", "Zygmunt Miłoszewski", 132L);
    Book book6 = new Book("Uwikłanie", "Zygmunt Miłoszewski", 133L);

    @Test
    public void testAddRental(){
        //given
        Library library = new Library();
        Adress adress1 = new Adress("Polna","Lublin","20-860","22","33");
        User user1 = new User(1L,"Jan","Kowalski","janek@wp.pl",adress1);
        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 121L);


        //when
        library.addRental(book1,user1);

        //then
        assertEquals(1,library.rentalsList.size());




    }
}
