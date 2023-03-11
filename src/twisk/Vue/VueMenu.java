package twisk.Vue;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
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

            /*Button setNom = new Button();
            setNom.setStyle("-fx-border-color: slategrey; -fx-border-width: 2px;");
            Image image = new Image(getClass().getResourceAsStream("/addAct.png"), 65, 65, true, true);
            ImageView icon = new ImageView(image);
            setNom.setGraphic(icon);
            setNom.setOnAction(new EcouteurBouton(monde));
            Tooltip tool = new Tooltip("Modifier le nom de l'activité");
            tool.setFont(Font.font("Verdana", FontPosture.REGULAR, 13));
            tool.setTextAlignment(TextAlignment.CENTER);
            setNom.setTooltip(tool);*/

            menu.getItems().addAll(nouveau, quitter);
            this.getMenus().addAll(menu);

        }


        @Override
        public void reagir() {

        }
    }


