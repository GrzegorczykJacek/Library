import org.junit.Test;

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
    @Test
    public void testAddRental() {
        //given
        Library library = new Library();
        Adress adress1 = new Adress("Polna", "Lublin", "20-860", "22", "33");
        User user1 = new User(1L, "Jan", "Kowalski", "janek@wp.pl", adress1);
        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2,121L);

        //when
        library.addRental(book1, user1);

        //then
        assertEquals(1, library.getRentalsList().size());
    }

    @Test
    public void testRemoveRental(){
        // given
        Library library = new Library();
        Adress adress1 = new Adress("Polna", "Lublin", "20-860", "22", "33");
        User user1 = new User(1L, "Jan", "Kowalski", "janek@wp.pl", adress1);
        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2,121L);
        // when
        library.addRental(book1, user1);
        library.removeRental(book1);
        // then
        assertEquals(0, library.getRentalsList().size());

    }

    @Test
    public void testAddBook(){
        // given
        Library library = new Library();
        Adress adress1 = new Adress("Polna", "Lublin", "20-860", "22", "33");
        User user1 = new User(1L, "Jan", "Kowalski", "janek@wp.pl", adress1);
        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2,121L);
        Book book2 = new Book("Pochłaniacz", "Katarzyna Bonda", 1,122L);
        Book book3 = new Book("Okularnik", "Katarzyna Bonda",1, 123L);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        // when
        // then
        assertEquals(3,library.getBooksList().size());
        assertEquals("Tylko martwi nie kłamią", library.getBooksList().get(0).getTitle());
        assertTrue(library.getBooksList().contains(book1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateBook(){
        // given
        Library library = new Library();
        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2,121L);
        // when
        library.addBook(book1);
        library.addBook(book1);
        // then
    }
}
