import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Library 1.0\n" +
                "Program zarządza biblioteką książek za pomocą prostego MENU\n" +
                "_______________________________________________________________");

        UserMenu userMenu = new UserMenu();
        userMenu.printMenu();

    }
}
