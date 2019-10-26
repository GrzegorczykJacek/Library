//import java.awt.*;
//
//public class IdBookValidator extends Library {
//    public boolean validate(Long idBook) {
//
//        // idBook nie może zostać puste
//        if (idBook == null) {
//            return false;
//        }else{
//
//            // idBook nie może się powtórzyć
//            boolean idExist = booksList.stream()
//                    .filter(a -> a.getIdBook().equals(idBook))
//                    .findAny().isPresent();
//
//            if (idExist) {
//                return false;
//            }
//        }
//        return true;
//    }
//}