
import java.io.File;
import java.io.FileNotFoundException;
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

    public void readRentalFile(Library library){

    }
}
