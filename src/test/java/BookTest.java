import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
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
        String bookRecord = "Tylko martwi nie kłamią Katarzyna Bonda 2 121";

        //then
        assertEquals(bookRecord, book1.toString());
    }

    @Test
    public void setIdBookTest(){
        //given



    }
}