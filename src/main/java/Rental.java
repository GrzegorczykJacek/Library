import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class Rental {

    private Long userID;
    private Long bookID;
    private LocalDate rentalStart;
    private Date rentalEnd = null;

    public Rental(Long userID, Long bookID){
        this.userID = userID;
        this.bookID = bookID;
        this.rentalStart = LocalDate.now();
    }

}
