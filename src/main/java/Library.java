import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Rental> rentalsList = new ArrayList<>(); // Jacek
    List<User> usersList = new ArrayList<>(); // Paweł
    List<Book> booksList = new ArrayList<>(); // Olga

    public void addUser(User user) {
        boolean userExist = usersList.stream()
                .filter(a -> a.getIdUser().equals(user.getIdUser()))
                .findAny().isPresent();
        if (!userExist) {
            usersList.add(user);
        }
    }


    public void removeUser(User user) {
        Optional<User> userExist = usersList.stream()
                .filter(a -> a.getIdUser().equals(user.getIdUser()))
                .findAny();
        if (!userExist.isPresent()) {
            throw new IllegalArgumentException();
        } else {
            usersList.remove(userExist.get());
        }
    }


    public void addRental(Book book, User user) {
        Rental rental = new Rental(user.getIdUser(), book.getIdBook());
        Optional<Rental> foundRental = rentalsList.stream()
                .filter(a -> a.getBookID().equals(book.getIdBook()))
                .findAny();
        if (!foundRental.isPresent()) {
            rentalsList.add(rental);
            System.out.println("Nowe wypożyczenie!");
        }
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
