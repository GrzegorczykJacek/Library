import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Rental> rentals = new ArrayList<>(); // Jacek
    List<User> users = new ArrayList<>(); // Paweł


    private List<Book> books = new ArrayList<>(); // Olga

    //dodawanie nowych książek do zbioru dostępnych w bibliotece
    public void addBook(Book book){
        books.add(book);
    }

    //usuwanie książek ze zbioru dostępnych w bibliotece
    public void removeBook(Book book){
        books.remove(book);
    }

}
