import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class UserMenu {

    Library library = new Library(); // generates Library with Lists of: users, books and rentals
    PrintList printList = new PrintList(); // prints to screen: users, books and rentals
    SaverIntoFile saverIntoFile = new SaverIntoFile(); // saves data to hard drive
    FileReader fileReader = new FileReader();


    Scanner scanner = new Scanner(System.in);
    String menu;
    String title;

    public void printMenu() throws FileNotFoundException, ParseException {

        fileReader.readBookFile(library);
        fileReader.readUserFile(library);
        fileReader.readRentalFile(library);

        do {
            System.out.println("Wybierz pozycję z MENU i zatwierdź klawiszem ENTER: \n" +
                    "1 - ZAMKNIJ PROGRAM (i zapisz bazę na dysk)\n" +
                    "2 - wyszukaj książkę w bibliotece\n" +
                    "3 - wyszukaj użytkownika w bibliotece\n" +
                    "4 - dodaj książkę do biblioteki...\n" +
                    "5 - dodaj użytkownika do biblioteki...\n" +
                    "6 - wypożycz książkę...\n" +
                    "7 - pokaż książki w bibliotece\n" +
                    "8 - pokaż użytkowników w bibliotece\n" +
                    "9 - pokaż aktualną listę wypożyczeń");
            menu = scanner.nextLine();

            switch (menu){
                case "1":
                    saverIntoFile.saveIntoFileBook(library);
                    saverIntoFile.saveIntoFileUser(library);
                    saverIntoFile.saveIntoFileRental(library);
                    // dodaj zapis bazy na dysk (z komunikatem o zapisie)
                    System.out.println("Zakończyłeś działanie programu");
                    System.exit(0);
                    break;
                case "2":
                    System.out.println("Podaj ID książki: ");
                    Book foundBook = library.searchBookID(scanner.nextLong());
                    if(foundBook!=null){
                        System.out.println(foundBook.toString());
                    } else {
                        System.out.println("Nie znaleziono książki o podanym ID!");
                    }
                    scanner.nextLine(); // clears scanner buffer from empty
                    System.out.println("");
                    break;
                case "3":
                    System.out.println("Podaj ID użytkownika: ");
                    User foundUser = library.searchUserID(scanner.nextLong());
                    if(foundUser!=null){
                        System.out.println(foundUser.toString());
                    } else {
                        System.out.println("Nie znaleziono użytkownika o podanym ID");
                    }
                    scanner.nextLine();  // clears scanner buffer from empty
                    System.out.printf("");
                    break;
                case "4":
                    System.out.printf("Wprowadź dane aby dodać książkę:\n" +
                            "TYTUŁ: ");
                    title = scanner.nextLine();
                    System.out.printf("AUTOR: ");
                    String author = scanner.nextLine();
                    System.out.printf("ILOŚĆ EGZEMPLARZY: ");
                    int copies = scanner.nextInt();
                    library.addBook(new Book(title, author, copies));
                    System.out.println("Pomyślnie dodano nową książkę!\n");
                    scanner.nextLine(); // clears scanner buffer from empty
                    break;
                case "5":
                    System.out.printf("Wprowadź dane użytkownika żeby dodać go do biblioteki:\n" +
                            "IMIĘ: ");
                    String firstName = scanner.nextLine();
                    System.out.printf("NAZWISKO: ");
                    String lastName = scanner.nextLine();
                    System.out.printf("E-MAIL: ");
                    String email = scanner.nextLine();
                    System.out.println("Podaj adres użytkownika: \n" +
                            "ULICA: ");
                    String street = scanner.nextLine();
                    System.out.printf("MIASTO: ");
                    String city = scanner.nextLine();
                    System.out.printf("KOD POCZTOWY: ");
                    String postCode = scanner.nextLine();
                    System.out.printf("NR. BUDYNKU: ");
                    String houseNumber = scanner.nextLine();
                    System.out.printf("NR. MIESZKANIA: ");
                    String apartmentNumber = scanner.nextLine();
                    library.addUser(
                            new User(firstName, lastName, email, new Adress(street, city, postCode, houseNumber, apartmentNumber))
                    );
                    System.out.println("Pomyślnie dodano użytkownika!\n");
                    break;
                case "6":
                    System.out.println("Podaj tytuł książki jaką chcesz wypożyczyć: ");
                    title = scanner.nextLine();
                    System.out.println("Podaj ID użytkownika, który wypożycza książkę: ");
                    Long userID = scanner.nextLong();
                    library.addRental(library.searchBookTitle(title), library.searchUserID(userID));
                    System.out.println("Poprawnie wypożyczono książkę!");
                    scanner.nextLine(); // clears scanner buffer from empty
                    break;
                case "7":
                    printList.printBookList(library.getBooksList());
                    break;
                case "8":
                    printList.printUserList(library);
                    break;
                case "9":
                    printList.printRenatalsList(library.getRentalsList());
                    break;
            }
        } while (!menu.equals("1"));
    }



}
