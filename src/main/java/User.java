import lombok.Getter;

@Getter

public class User {
    private static Long currentIdUser = 0L;
    private Long idUser;
    private String firstName;
    private String lastName;
    private String email;
    private Adress adress;

    public User(String firstName, String lastName, String email, Adress adress){
        this.idUser = ++currentIdUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.adress = adress;
    }

    public String toString(){
        return "ID:  "+idUser+
                " \nImie: "+firstName+
                " \nNazwisko: "+lastName+
                " \nEmail: "+email+
                " \n"+adress.toString();
    }

}
