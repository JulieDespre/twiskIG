package twisk.exceptions;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class ExceptionDelais extends Exception {

    public ExceptionDelais() {
    }

    public void getAlert(){
        Alert delExcep = new Alert(Alert.AlertType.ERROR);
        delExcep.setTitle("Erreur : le delais d'une étape dois être compris entre 2-4 sec");
        delExcep.setHeaderText("Erreur : le delais d'une étape dois être compris entre 2-4 sec");
        delExcep.setContentText("Choisir une autre delais pour l'étape");
        delExcep.show();
        PauseTransition wait = new PauseTransition(Duration.seconds(4));
        wait.setOnFinished((e) -> delExcep.close());
        wait.play();
    }
}
