import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {

    List<Rental> rentals = new ArrayList<>(); // Jacek
    List<User> users = new ArrayList<>(); // Paweł
    List<Book> books = new ArrayList<>(); // Olga

    public void addRental(Book book, User user){
        Rental rental = new Rental(user.getIdUser(), book.getIdBook());
        Optional<Rental> foundRental = rentals.stream()
                .filter(a -> a.getBookID().equals(book.getIdBook()))
                .findAny();
                if(!foundRental.isPresent()){
                    rentals.add(rental);
                    System.out.println("Nowe wypożyczenie!");
                }
    }

}
