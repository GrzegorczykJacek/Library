import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Adress {
    private String street;
    private String city;
    private String postCode;
    private String houseNumber;
    private String apartmentNumber;

    public String toString(){
        return "Kod pocztowy:  "+postCode+
                " \nMiasto: "+city+
                " \nUlica: "+street+
                " \nNr domu: "+houseNumber+
                " \nNr mieszkania "+apartmentNumber;

    }



}
