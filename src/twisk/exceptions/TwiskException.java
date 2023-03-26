package twisk.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class TwiskException extends Exception {

    public TwiskException() {
    }

    public void getAlert(){
        Alert dialogException = new Alert(Alert.AlertType.ERROR);
        dialogException.setTitle("Erreur : l'arc ne peut pas être créé");
        dialogException.setHeaderText("Une étape ne peut pas être reliée à elle-même");
        dialogException.setContentText("créer un arc entre deux étapes différentes");
        dialogException.showAndWait();
    }
}
