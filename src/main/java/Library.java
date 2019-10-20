import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class Library {

    private final List<Rental> rentalsList = new ArrayList<>(); // Jacek
    private final List<User> usersList = new ArrayList<>(); // Paweł
    private final List<Book> booksList = new ArrayList<>(); // Olga

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
    }

    //dodawanie nowych książek do zbioru biblioteki

    public void addBook(Book book){
        List<Book> foundBook = booksList.stream()
                .filter(a-> a.getTitle().equals(book.getTitle()))
                .collect(Collectors.toList());
        if (foundBook.size() == 0){
            booksList.add(book);
        }else{
            book.setCopies(foundBook.size() + 1);
            booksList.add(book);
        }
    }

    //usuwanie książek ze zbioru biblioteki
    public void removeBook(Book book){
        booksList.remove(book);
    }
}
