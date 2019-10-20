import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Book {

    private String title;
    private String author;
    private Long idBook;

    public String toString(){
        return title +" "+ author +" "+ idBook;
    }

}
