import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testBookConstructor() {
        // given
        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 1);
        Book book2 = new Book("Pochłaniacz", "Katarzyna Bonda", 1);
        Book book3 = new Book("Okularnik", "Katarzyna Bonda", 1);
        // when
        // then
        assertEquals(java.util.Optional.of(1L), java.util.Optional.ofNullable(book1.getIdBook()));
        assertEquals(java.util.Optional.of(2L), java.util.Optional.ofNullable(book2.getIdBook()));
        assertEquals(java.util.Optional.of(3L), java.util.Optional.ofNullable(book3.getIdBook()));
    }

    @Test
    public void book(){
        //give
        Book bookgiven = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2,121L);
        //when

        //then
        assertEquals("Tylko martwi nie kłamią", bookgiven.getTitle());
        assertEquals("Katarzyna Bonda", bookgiven.getAuthor());
        assertEquals(2, bookgiven.getCopies());
        assertEquals(Long.valueOf(121L), bookgiven.getIdBook());
    }

    @Test
    public void bookStringRecord(){
        //given
        Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2,121L);

        //when
        String bookRecord = "| Tylko martwi nie kłamią | Katarzyna Bonda | 2 szt. | book ID: 121";

        //then
        assertEquals(bookRecord, book1.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNullIdBookTest(){

        // given
        Book book = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 2,121L);

        // when
        book.setIdBook(null);

    }
}