import java.io.FileNotFoundException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {

        System.out.println("Library 1.0\n" +
                "Program zarządza biblioteką książek za pomocą prostego MENU\n" +
                "_______________________________________________________________\n");

        UserMenu userMenu = new UserMenu();
        userMenu.printMenu();

    }
}
