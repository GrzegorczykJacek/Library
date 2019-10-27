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


    /*

      public void read() throws FileNotFoundException {
        Scanner odczyt = new Scanner(new File("Biblioteka.txt"));
        int licznik = 0;
        PlytaCD tmp;
        List<Utwor> utwory = null;
        String title = null;
        String year = null;
        while (odczyt.hasNextLine()) {
            String line = odczyt.nextLine();
            switch (line) {
                case "---":
                    licznik = 0;
                    utwory = new ArrayList<>();
                    break;
                default:
                    if (licznik == 0) {
                        title = line;
                    } else if (licznik == 1) {
                        year = line;
                        tmp = new PlytaCD(title, year, utwory);
                        listaPlyt.add(tmp);
                    } else {
                        String[] tab = line.split("%");
                        utwory.add(new Utwor(tab[0], tab[1], Double.valueOf(tab[2])));
                    }
                    licznik++;
            }
        }
    }
     */
}
