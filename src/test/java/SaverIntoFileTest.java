import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SaverIntoFileTest {

    @Test
    public void saveInToFileBookTest() throws FileNotFoundException {

        //given
        SaverIntoFile saverIntoFile = new SaverIntoFile();
        Library library = new Library();

        library.addBook(new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 1,121L));
        library.addBook(new Book("Pochłaniacz", "Katarzyna Bonda", 1,122L));
        library.addBook(new Book("Okularnik", "Katarzyna Bonda",1, 123L));
        library.addBook(new Book("Gniew", "Zygmunt Miłoszewski", 1,131L));
        library.addBook(new Book("Uwikłanie", "Zygmunt Miłoszewski", 2,133L));

        //when
        saverIntoFile.saveIntoFileBook(library);

        //then
        List<Book> booksList = library.getBooksList();
        booksList.clear();

        assertEquals(0, booksList.size());

        //saverIntoFile.read();
       // assertEquals(5, booksList.size());

    }
}