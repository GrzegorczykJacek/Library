public class Main {
    public static void main(String[] args) {

        System.out.println("Library 1.0\n" +
                "Program zarządza biblioteką książek za pomocą prostego MENU\n" +
                "_______________________________________________________________");

//        UserMenu userMenu = new UserMenu();
//        userMenu.printMenu();

        Library library = new Library();
        Book book = new Book("Pan Tadeusz", "Adam Mickiewicz", 2);
        Book book2 = new Book("Ogniem i mieczem", "Henryk Sienkiewicz", 4);

        Adress adress1 = new Adress("Polna", "Lublin", "20-860", "22", "33");
        User user1 = new User("Jan", "Kowalski", "janek@wp.pl", adress1);
        Adress adress2 = new Adress("Krakowskie", "Lublin", "22-900", "14", "90");
        User user2 = new User("Andrzej", "Smith", "andrzej@wp.pl", adress2);

        library.addBook(book);
        library.addBook(book2);
        library.addUser(user1);
        library.addUser(user2);
        PrintList printList = new PrintList();
        printList.printBookList(library.getBooksList());
        printList.printUserList(library);

        library.addRental(book, user1);
        library.addRental(book2, user2);
        printList.printRenatalsList(library.getRentalsList());
    }
}
