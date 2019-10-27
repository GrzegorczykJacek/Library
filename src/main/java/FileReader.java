import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public void readBookFile(Library library) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("Books.csv"));

        while (reader.hasNextLine()){
           String line =  reader.nextLine();
           String tab[] = line.split(";");
           Long idBook = Long.valueOf(tab[0]);
           int copies = Integer.valueOf(tab[1]);
           String title = tab[2];
           String author = tab[3];
           Book tmp = new Book(title,author,copies,idBook);
           library.addBook(tmp);
        }
    }
}
