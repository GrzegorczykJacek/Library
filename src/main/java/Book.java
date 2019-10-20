import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor

public class Book {

    private String title;
    private String author;
    @Setter
    protected int copies;
    private Long idBook;

    public String toString(){
        return title +" "+ author +" "+ idBook + copies;
    }

}
