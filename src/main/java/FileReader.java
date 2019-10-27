
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class FileReader {

    public void readBookFile(Library library) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("Books.csv"));
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String tab[] = line.split(";");
            Long idBook = Long.valueOf(tab[0]);
            int copies = Integer.valueOf(tab[1]);
            String title = tab[2];
            String author = tab[3];
            Book tmp = new Book(title, author, copies, idBook);
            library.addBook(tmp);
        }
    }

    public void readUserFile(Library library) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("User.csv"));
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String tab[] = line.split(";");
            Long idUser = Long.valueOf(tab[0]);
            String firstName = tab[1];
            String lastName = tab[2];
            String email = tab[3];

            //Adress
            String postCode = tab[4];
            String city = tab[5];
            String street = tab[6];
            String houseNumber = tab[7];
            String apartmentNumber = tab[8];
            Adress adress = new Adress(street, city, postCode, houseNumber, apartmentNumber);

            User user = new User(firstName, lastName, email, adress);
            library.addUser(user);
        }
    }
// !!!!!!!!!!!!!!!!!!!!!! Dokończyć tą metodę !!!!!!!!!!!!
    public void readRentalFile(Library library) throws FileNotFoundException, ParseException {
        Scanner reader = new Scanner(new File("Rental.csv"));
        while (reader.hasNextLine()){
            String line = reader.nextLine();
            String tab[] = line.split(";");
            Long userID = Long.valueOf(tab[0]);
            Long bookID = Long.valueOf(tab[1]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localStart = LocalDate.from(formatter.parse(tab[2]));
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
            Date rentalDeadline = formatter2.parse(tab[3]);

            Rental rental = new Rental(userID,bookID,localStart,rentalDeadline);
       //     library.addRental(rental);
        }

    }
}
