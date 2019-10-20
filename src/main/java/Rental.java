import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class Rental {

    private Long userID;
    private Long bookID;
    private LocalDate rentalStart;
    private Date rentalDeadline;

    // Adds new book rental
    public Rental(Long userID, Long bookID){
        this.userID = userID;
        this.bookID = bookID;
        this.rentalStart = LocalDate.now();
        this.rentalDeadline = java.sql.Date.valueOf(rentalStart.plusDays(30));
    }

    // Returns String with rental info
    public String toString(){
        return "Wypożyczono książkę o id: " + bookID + " użytkownikowi o id: " + userID;
    }

}
