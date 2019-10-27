import java.util.Scanner;

public class UserMenu {

    Library library = new Library();

    Scanner scanner = new Scanner(System.in);
    String menu;
    String title;

    public void printMenu(){
        do {
            System.out.println("Wybierz pozycję z MENU i zatwierdź klawiszem ENTER: \n" +
                    "1 - ZAMKNIJ PROGRAM\n" +
                    "2 - wyszukaj książkę w bibliotece\n" +
                    "3 - wyszukaj użytkownika w bibliotece\n" +
                    "4 - dodaj książkę do biblioteki...\n" +
                    "5 - dodaj użytkownika do biblioteki...\n" +
                    "6 - wypożycz książkę...");
            menu = scanner.nextLine();

            switch (menu){
                case "1":
                    System.out.println("Zakończyłeś działanie programu");
                    System.exit(0);
                    break;
                case "2":
                    System.out.println("Podaj ID książki: ");
                    System.out.println(
                            library.searchBookID(scanner.nextLong()).toString()
                    );
                    scanner.nextLine(); // clears scanner buffer from empty
                    System.out.println("");
                    break;
                case "3":
                    System.out.println("Podaj ID użytkownika: ");
                    System.out.println(
                        library.searchUserID(scanner.nextLong()).toString()
                    );
                    scanner.nextLine();  // clears scanner buffer from empty
                    System.out.printf("");
                    break;
                case "4":
                    System.out.println("Wprowadź dane aby dodać książkę:\n" +
                            "TYTUŁ: ");
                    title = scanner.nextLine();
                    System.out.println("AUTOR: ");
                    String author = scanner.nextLine();
                    System.out.println("ILOŚĆ EGZEMPLARZY: ");
                    int copies = scanner.nextInt();
                    library.addBook(new Book(title, author, copies));
                    System.out.println("Pomyślnie dodano nową książkę!\n");
                    scanner.nextLine(); // clears scanner buffer from empty
                    break;
                case "5":
                    System.out.println("Wprowadź dane użytkownika żeby dodać go do biblioteki:\n" +
                            "IMIĘ: ");
                    String firstName = scanner.nextLine();
                    System.out.println("NAZWISKO: ");
                    String lastName = scanner.nextLine();
                    System.out.println("E-MAIL");
                    String email = scanner.nextLine();
                    System.out.println("Podaj adres użytkownika: \n" +
                            "ULICA: ");
                    String street = scanner.nextLine();
                    System.out.println("MIASTO: ");
                    String city = scanner.nextLine();
                    System.out.printf("KOD POCZTOWY: ");
                    String postCode = scanner.nextLine();
                    System.out.println("NR. BUDYNKU: ");
                    String houseNumber = scanner.nextLine();
                    System.out.println("NR. MIESZKANIA: ");
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
            }
        } while (!menu.equals("1"));
    }



}
