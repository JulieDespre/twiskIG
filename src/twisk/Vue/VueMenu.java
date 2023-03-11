package twisk.Vue;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;
import twisk.mondeIG.MondeIG;

public class VueMenu extends MenuBar implements Observateur {
        private MondeIG monde;


        public VueMenu (MondeIG monde) {
            super();
            this.monde = monde;


            Menu menu = new Menu("Menu");
            menu.setStyle("-fx-font: 20 helvetica; -fx-font-color: grey ; -fx-background: lightgrey");

            MenuItem nouveau = new MenuItem("Nouveau");
            nouveau.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
            nouveau.setOnAction(new EcouteurNouveau(monde));


            MenuItem quitter = new MenuItem("Quitter");
            quitter.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
            quitter.setOnAction(event -> Platform.exit());

            Menu taillePlateau = new Menu("Taille du plateau :");
            taillePlateau.setStyle("-fx-font: 20 helvetica; -fx-font-color: grey ; -fx-background: lightgrey");
            Menu menuTaille = new Menu();
            menuTaille.setStyle("-fx-font: 20 helvetica; -fx-font-color: grey ; -fx-background: lightgrey");

            menu.getItems().addAll(nouveau, quitter);
            this.getMenus().addAll(menu);

        }

        @Override
        public void reagir() {

        }
    }


