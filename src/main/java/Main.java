import java.io.FileNotFoundException;
import java.text.ParseException;
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, ParseException {

        JFrame introFrame = new JFrame("Library 1.0");
        JLabel welcomeText = new JLabel("<html>Program zarządza biblioteką książek<br /> za pomocą prostego MENU</html");
        introFrame.add(welcomeText, BorderLayout.CENTER);
        introFrame.pack();
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        introFrame.setBounds(((screenWidth / 2) - 150), ((screenHeight / 2) - 75), 300, 150);
        introFrame.setResizable(false);
        introFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("book.jpg"));
        introFrame.setDefaultCloseOperation(3);
        introFrame.setVisible(true);



        System.out.println("Library 1.0\n" +
                "Program zarządza biblioteką książek za pomocą prostego MENU\n" +
                "_______________________________________________________________\n");

        UserMenu userMenu = new UserMenu();
        userMenu.printMenu();



    }
}
