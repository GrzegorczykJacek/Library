import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class User {
    private Long idUser;
    private String firstName;
    private String lastName;
    private String email;
    private Adress adress;

    public String toString(){
        return "ID:  "+idUser+
                " \nImie: "+firstName+
                " \nNazwisko: "+lastName+
                " \nEmail: "+email+
                " \n: "+adress.toString();
    }

}
