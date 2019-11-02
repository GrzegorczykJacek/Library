
public class IdBookValidator extends Library {
    public boolean validate(Long idBook) {

        // idBook nie może zostać puste
        if (idBook == null) {
            return false;
        } else {

            // idBook nie może się powtórzyć
            boolean idExist = getBooksList().stream()
                    .filter(a -> a.getIdBook().equals(idBook))
                    .findAny().isPresent();

            if (idExist) {
                System.out.println("Podane IdBook już istnieje");
                return false;
            }
        }
        return true;
    }
}