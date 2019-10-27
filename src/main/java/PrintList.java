import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrintList {


    // Prints list of books in library to screen
    public void printBookList(List<Book> bookList){
        // Table header
        System.out.format(
                "| %-45s | %-30s | %-6s | %4s |\n",
                "TYTUŁ",
                "AUTOR",
                "KOPIE",
                "ID"
        );
        // Table horizontal separator
        System.out.println("--------------------------------------------------------------------------------------------------");
        // Table record
        for(Book book : bookList){
            System.out.format(
                    "| %-45s | %-30s | %-6s | %4s |\n",
                    bookList.get(bookList.indexOf(book)).getTitle(),
                    bookList.get(bookList.indexOf(book)).getAuthor(),
                    bookList.get(bookList.indexOf(book)).getCopies(),
                    bookList.get(bookList.indexOf(book)).getIdBook()
            );
        }
        System.out.println("\n");

    }

    // Prints list of users in library to screen
    public void printUserList(Library library){
        // Table header
        System.out.format(
                "| %-20s | %-20s | %12s | %4s |\n",
                "IMIĘ",
                "NAZWISKO",
                "WYPOŻYCZENIA",
                "ID"
        );
        // Table horizontal separator
        System.out.println("---------------------------------------------------------------------");
        // Table record
        List<User> usersList = library.getUsersList();

        for(User user : usersList){
            System.out.format(
                    "| %-20s | %-20s | %12s | %4s |\n",
                    usersList.get(usersList.indexOf(user)).getFirstName(),
                    usersList.get(usersList.indexOf(user)).getLastName(),
                    library.getNumOfRentals(user),
                    usersList.get(usersList.indexOf(user)).getIdUser()
            );
        }
        System.out.println("\n");

    }

    // Prints list of users in library to screen
    public void printRenatalsList(List<Rental> rentalsList){
        // Table header
        System.out.format(
                "| %-10s | %-10s | %-20s | %-15s |\n",
                "UŻYTKOWNIK",
                "KSIĄŻKA",
                "DATA WYPOŻYCZENIA",
                "DATA ZWROTU"
        );
        // Table horizontal separator
        System.out.println("---------------------------------------------------------------------");
        // Table record
        for(Rental rental : rentalsList){
            System.out.format(
                    "| %-10s | %-10s | %-20s | %-15s |\n",
                    rentalsList.get(rentalsList.indexOf(rental)).getUserID(),
                    rentalsList.get(rentalsList.indexOf(rental)).getBookID(),
                    rentalsList.get(rentalsList.indexOf(rental)).getRentalStart(),
                    rentalsList.get(rentalsList.indexOf(rental)).getRentalDeadline()
            );
        }
        System.out.println("\n");

    }


}
