import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Rental> rentals = new ArrayList<>();
    List<User> users = new ArrayList<>();


    List<Book> booksList = new ArrayList<>();

    //given
    Book book1 = new Book("Tylko martwi nie kłamią", "Katarzyna Bonda", 1,121L);
    Book book2 = new Book("Pochłaniacz", "Katarzyna Bonda", 1,122L);
    Book book3 = new Book("Okularnik", "Katarzyna Bonda", 1,123L);
    Book book4 = new Book("Gniew", "Zygmunt Miłoszewski", 1,131L);
    Book book5 = new Book("Ziarno prawdy", "Zygmunt Miłoszewski", 1,132L);
    Book book6 = new Book("Uwikłanie", "Zygmunt Miłoszewski", 2,133L);

}
