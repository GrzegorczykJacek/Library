import org.junit.Test;

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

}