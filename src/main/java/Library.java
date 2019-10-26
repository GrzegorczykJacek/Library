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
        } else {
            throw new IllegalArgumentException("Użytkownik o podanym ID: " + user.getIdUser() + " już jest w bazie ! ! !");
        }
    }

    public void removeUser(User user) {
        Optional<User> userExist = usersList.stream()
                .filter(a -> a.getIdUser().equals(user.getIdUser()))
                .findAny();
        if (!userExist.isPresent()) {
            throw new IllegalArgumentException("Użytkownik, którego próbujesz usunąć nie istnieje w bazie ! ! !");
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
            System.out.println(book.toString());
        } else {
            throw new IllegalArgumentException("Książka, którą próbujesz wypożyczyć nie została jeszcze zwrócona ! ! !");
        }
    }

    // Removes rental after a book return
    public void removeRental(Book book) {
        Optional<Rental> foundRental = rentalsList.stream()
                .filter(a -> a.getBookID().equals(book.getIdBook()))
                .findAny();
        if (!foundRental.isPresent()) {
            throw new IllegalArgumentException("Nie znaleziono wypożyczenia o podanym ID książki: " + book.getIdBook() + "!!!");
        } else {
            rentalsList.remove(foundRental.get()); // foundRental jest Optionalem - metoda get() zwraca jego zawartość
            System.out.println("Książka została poprawnie zwrócona!!!");
        }
    }

    // dodawanie nowych książek do zbioru biblioteki
    public void addBook(Book book) {
        List<Book> foundBook = booksList.stream()
                .filter(a -> a.getTitle().equals(book.getTitle()))
                .collect(Collectors.toList());
        if (foundBook.size() == 0) {
            booksList.add(book);
        } else {
            book.setCopies(foundBook.size() + 1);
            booksList.add(book);
        }
    }

    public void removeBook(Book book) {
        Optional<Book> foundBook = booksList.stream()
                .filter(a -> a.getIdBook().equals(book.getIdBook()))
                .findAny();
        if (!foundBook.isPresent()) {
            throw new IllegalArgumentException("Nie znaleziono książki o podanym ID książki: " + book.getIdBook() + "!!!");
        } else {
            booksList.remove(foundBook.get()); // foundBook jest Optionalem - metoda get() zwraca jego zawartość
            System.out.println("Książka została poprawnie usunięta z listy biblioteki!!!");
        }
    }

    // Returns User found by ID in users list
    public User searchUserID(Long queryUserID) {
        return usersList.stream()
                .filter(a -> a.getIdUser().equals(queryUserID))
                .findAny().orElse(null);
    }

    // Returns Book found by ID in books list
    public Book searchBookID(Long queryBookID) {
        return booksList.stream()
                .filter(a -> a.getIdBook().equals(queryBookID))
                .findAny().orElse(null);
    }


}
