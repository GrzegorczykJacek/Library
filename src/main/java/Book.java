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
    private static Long currentIdBook = 0L;
    private Long idBook;

    public Book(String title, String author, int copies){
        this.title = title;
        this.author = author;
        this.copies = copies;
        this.idBook = ++currentIdBook;
    }

    public String toString(){
        return "| " + title + " | " + author + " | " + copies + " szt. | book ID: " + idBook;
    }

    public void setIdBook(Long idBook) {
        IdBookValidator idBookValidator = new IdBookValidator();
        boolean validate = idBookValidator.validate(idBook);
        if (validate) {
            this.idBook = idBook;
        } else {

            throw new IllegalArgumentException("Niepoprawny IdBook!");
        }
    }
}
