package twisk.exceptions;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class ExceptionEtape extends Exception {

    public ExceptionEtape() {
    }

    public void getAlert(){
        Alert etapeExcep = new Alert(Alert.AlertType.ERROR);
        etapeExcep.setTitle("Erreur : l'étape est déjà une entrée ou une sortie'");
        etapeExcep.setHeaderText("Une étape ne peut pas être choisi deux fois comme entrée ou sortie");
        etapeExcep.setContentText("Choisir une autre étape");
        etapeExcep.show();
        PauseTransition wait = new PauseTransition(Duration.seconds(4));
        wait.setOnFinished((e) -> etapeExcep.close());
        wait.play();
    }
}
