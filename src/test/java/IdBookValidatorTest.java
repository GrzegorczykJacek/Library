
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IdBookValidatorTest {

    @Test
    public void TestIdBookNull(){
        //given

        Long idBook = null;
        IdBookValidator idBookValidator = new IdBookValidator();

        //when
        boolean result = idBookValidator.validate(idBook);

        //then
        assertFalse(result);
    }

    @Test
    public void TestDuplicateIdBook(){
        //given
       Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 1,121L);
       List<Book> booksList = new ArrayList<>();
       Long idBook = 121L;
       IdBookValidator idBookValidator = new IdBookValidator();

        //when
        boolean result = idBookValidator.validate(idBook);

        //then
        assertTrue(result);
    }
}