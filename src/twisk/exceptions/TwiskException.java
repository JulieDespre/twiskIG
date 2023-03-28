package twisk.exceptions;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;


public class TwiskException extends Exception {

    public TwiskException() {
    }

    public void getAlert(){
        Alert dialogException = new Alert(Alert.AlertType.ERROR);
        dialogException.setTitle("Erreur : l'arc ne peut pas être créé");
        dialogException.setHeaderText("Une étape ne peut pas être reliée à elle-même");
        dialogException.setContentText("créer un arc entre deux étapes différentes");
        dialogException.show();
        PauseTransition wait = new PauseTransition(Duration.seconds(3));
        wait.setOnFinished((e) -> dialogException.close());
        wait.play();
    }


}
