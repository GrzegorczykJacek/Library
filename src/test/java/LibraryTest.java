import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {

    //given
//    Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 1,121L);
//    Book book2 = new Book("Pochłaniacz", "Katarzyna Bonda", 1,122L);
//    Book book3 = new Book("Okularnik", "Katarzyna Bonda",1, 123L);
//    Book book4 = new Book("Gniew", "Zygmunt Miłoszewski", 1,131L);
//    Book book5 = new Book("Ziarno prawdy", "Zygmunt Miłoszewski", 1,132L);
//    Book book6 = new Book("Uwikłanie", "Zygmunt Miłoszewski", 2,133L);

    @Test
    public void testAddUser() {
        // given
        Adress address = new Adress("Racławickie", "Lublin", "12-345", "8", "12");
        User givUser = new User("Jan", "Kowalski", "jan.kowalski@mail.pl", address);
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
    public void testRemoveUser() {
        //given
        Adress address = new Adress("Racławickie", "Lublin", "12-345", "8", "12");
        User givUser = new User("Jan", "Kowalski", "jan.kowalski@mail.pl", address);
        Library library = new Library();
        List<User> usersList = new ArrayList<>();
        library.addUser(givUser);
        //when
        library.removeUser(givUser);
        //then
        assertEquals(0, library.getUsersList().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingUser() {
        //given
        Adress address = new Adress("Racławickie", "Lublin", "12-345", "8", "12");
        User givUser = new User("Jan", "Kowalski", "jan.kowalski@mail.pl", address);
        Library library = new Library();
        List<User> usersList = new ArrayList<>();
        library.addUser(givUser);
        //when
        library.removeUser(givUser);
        library.removeUser(givUser);
        //then
    }

    @Test
    public void testAddRental() {
        //given
        Library library = new Library();
        Adress adress1 = new Adress("Polna", "Lublin", "20-860", "22", "33");
        User user1 = new User("Jan", "Kowalski", "janek@wp.pl", adress1);
        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2, 121L);

        //when
        library.addRental(book1, user1);

        //then
        assertEquals(1, library.getRentalsList().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateRental() {
        //given
        Library library = new Library();
        Adress adress1 = new Adress("Polna", "Lublin", "20-860", "22", "33");
        User user1 = new User("Jan", "Kowalski", "janek@wp.pl", adress1);
        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2, 121L);
        //when
        library.addRental(book1, user1);
        library.addRental(book1, user1);
        //then
    }

    @Test
    public void testRemoveRental() {
        // given
        Library library = new Library();
        Adress adress1 = new Adress("Polna", "Lublin", "20-860", "22", "33");
        User user1 = new User("Jan", "Kowalski", "janek@wp.pl", adress1);
        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2, 121L);
        // when
        library.addRental(book1, user1);
        library.removeRental(book1);
        // then
        assertEquals(0, library.getRentalsList().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingRental() {
        // given
        Library library = new Library();
        Adress adress1 = new Adress("Polna", "Lublin", "20-860", "22", "33");
        User user1 = new User("Jan", "Kowalski", "janek@wp.pl", adress1);
        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2, 121L);
        Book book2 = new Book("Gniew", "Zygmunt Miłoszewski", 1, 122L);
        // when
        library.addRental(book1, user1);
        library.removeRental(book2);
        // then
    }

    @Test
    public void testAddBook() {
        // given
        Library library = new Library();
        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2, 121L);
        Book book2 = new Book("Pochłaniacz", "Katarzyna Bonda", 1, 122L);
        Book book3 = new Book("Okularnik", "Katarzyna Bonda", 1, 123L);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        // when
        // then
        assertEquals(3, library.getBooksList().size());
        assertEquals("Tylko martwi nie kłamią", library.getBooksList().get(0).getTitle());
        assertTrue(library.getBooksList().contains(book1));
        System.out.println(library.getBooksList());
    }

    @Test
    public void testAddDuplicateBook() {
        // given
        Library library = new Library();
        Book book = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2, 121L);
        Book book2 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 1, 121L);

        // when
        library.addBook(book);
        library.addBook(book2);

        // then
        assertEquals(1, library.getBooksList().size());

    }

    @Test
    public void testRemoveBook() {
        // given
        Library library = new Library();
        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2, 121L);
        Book book2 = new Book("Pochłaniacz", "Katarzyna Bonda", 1, 123L);
        Book book3 = new Book("Okularnik", "Katarzyna Bonda", 1, 124L);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        // when
        // then
        assertEquals(3, library.getBooksList().size());
        library.removeBook(book1);
        assertEquals(2, library.getBooksList().size());
        library.removeBook(book2);
        assertEquals(1, library.getBooksList().size());
        library.removeBook(book3);
        assertEquals(0, library.getBooksList().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingBook() {
        // given
        Library library = new Library();
        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2, 121L);
        Book book2 = new Book("Pochłaniacz", "Katarzyna Bonda", 1, 122L);
        Book book3 = new Book("Okularnik", "Katarzyna Bonda", 1, 123L);
        Book nonExistingBook = new Book("Okularnik", "Katarzyna Bonda", 1, 124L);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        // when
        // then
        assertEquals(3, library.getBooksList().size());
        library.removeBook(book1);
        assertEquals(2, library.getBooksList().size());
        library.removeBook(book2);
        assertEquals(1, library.getBooksList().size());
        library.removeBook(book3);
        assertEquals(0, library.getBooksList().size());
        library.removeBook(nonExistingBook);
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void testAddDuplicateBook(){
//        // given
//        Library library = new Library();
//        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2, 121L);
//        // when
//        library.addBook(book1);
//        library.addBook(book1);
//        // then
//    }

    @Test
    public void testSearchUserID() {
        // given
        Library library = new Library();
        Adress adress1 = new Adress("Polna", "Lublin", "20-860", "22", "33");
        User user1 = new User("Jan", "Kowalski", "janek@wp.pl", adress1);
        User user2 = user1;
        // when
        library.addUser(user1);
        // then
        assertEquals(user2, library.searchUserID(8L));
        assertEquals(null, library.searchUserID(123L));
    }

    @Test
    public void testSearchBookID() {
        // given
        Library library = new Library();
        Book bookToFind = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2, 121L);
        Long bookID = bookToFind.getIdBook();
        library.addBook(bookToFind);
        // when
        // then
        System.out.println("Test search bookID: " + bookID);
        assertEquals(bookToFind, library.searchBookID(bookID));
        assertEquals(null, library.searchBookID(123L));
    }

    @Test
    public void testSearchBookTitle() {
        // given
        Library library = new Library();
        Book book1 = new Book("Okularnik", "Katarzyna Bonda", 1, 121L);
        Book book2 = new Book("Gniew", "Zygmunt Miłoszewski", 1, 122L);
        Book book3 = new Book("Ziarno prawdy", "Zygmunt Miłoszewski", 1, 123L);
        Book book4 = new Book("Uwikłanie", "Zygmunt Miłoszewski", 2, 124L);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        // when
        // then
        assertEquals(book2, library.searchBookTitle("Gniew"));
        assertEquals(book3, library.searchBookTitle("Ziarno prawdy"));
        assertEquals(book1, library.searchBookTitle("Okularnik"));
        assertEquals(book4, library.searchBookTitle("Uwikłanie"));
    }
}
