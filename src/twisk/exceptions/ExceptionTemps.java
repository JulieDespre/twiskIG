package twisk.exceptions;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class ExceptionTemps extends Exception {

    public ExceptionTemps() {
    }

    public void getAlert(){
        Alert tpsExcep = new Alert(Alert.AlertType.ERROR);
        tpsExcep.setTitle("Erreur : le temps d'une étape dois être compris entre 5-10 sec");
        tpsExcep.setHeaderText("Erreur : le temps d'une étape dois être compris entre 5-10 sec");
        tpsExcep.setContentText("Choisir une autre durée pour l'étape");
        tpsExcep.show();
        PauseTransition wait = new PauseTransition(Duration.seconds(4));
        wait.setOnFinished((e) -> tpsExcep.close());
        wait.play();
    }
}
