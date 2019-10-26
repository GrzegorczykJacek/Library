import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaverIntoFile {
    private List<Book> bookList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private List<Rental> rentalList = new ArrayList<>();

    public void saveIntoFileBook() throws FileNotFoundException {
        PrintWriter saveBook = new PrintWriter("Books.txt");
        bookList.forEach(Book -> {
            //save.println("=================");
            Long idBook = Book.getIdBook();
            int copies = Book.getCopies();
            String title = Book.getTitle();
            String author = Book.getAuthor();
            saveBook.print(idBook);
            saveBook.print(";");
            saveBook.print(copies);
            saveBook.print(";");
            saveBook.print(title);
            saveBook.print(";");
            saveBook.println(author);
        });
        saveBook.close();
    }

    public void saveIntoFileUser() throws FileNotFoundException {
        PrintWriter saveUser = new PrintWriter("User.txt");
        userList.forEach(User -> {
            Long idUser = User.getIdUser();
            String firstName = User.getFirstName();
            String lastName = User.getLastName();
            String email = User.getEmail();
            String adressStreet = User.getAdress().getStreet();
            String adressHouseNumber = User.getAdress().getHouseNumber();
            String adressApartmentNumber = User.getAdress().getApartmentNumber();
            String adressCity = User.getAdress().getCity();
            String adressPostcode = User.getAdress().getPostCode();
            saveUser.print(idUser);
            saveUser.print(";");
            saveUser.print(firstName);
            saveUser.print(";");
            saveUser.print(lastName);
            saveUser.print(";");
            saveUser.print(email);
            saveUser.print(";");
            saveUser.print(adressPostcode);
            saveUser.print(";");
            saveUser.print(adressCity);
            saveUser.print(";");
            saveUser.print(adressStreet);
            saveUser.print(";");
            saveUser.print(adressHouseNumber);
            saveUser.print(";");
            saveUser.println(adressApartmentNumber);
        });
        saveUser.close();
    }

    public void saveIntoFileRental() throws FileNotFoundException {
        PrintWriter saveRental = new PrintWriter("User.txt");
        rentalList.forEach(Rental -> {
            Long userID = Rental.getUserID();
            Long bookID = Rental.getBookID();
            LocalDate localStart = Rental.getRentalStart();
            Date rentalDeadline = Rental.getRentalDeadline();
            saveRental.print(userID);
            saveRental.print(";");
            saveRental.print(bookID);
            saveRental.print(";");
            saveRental.print(localStart);
            saveRental.print(";");
            saveRental.println(rentalDeadline);
        });
        saveRental.close();
    }
}