package twisk.mondeIG;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.util.HashMap;

public class TailleComposants {
    private static TailleComposants instance;

private TailleComposants(){

}
    public static TailleComposants getInstance() {
        if (instance == null) {
            instance = new TailleComposants();
        }
        return instance;
    }

    public int getHauteur(EtapeIG etape){
        int hauteur = 0;
        switch (etape.getComposant()){
            case ACTIVITE:
                hauteur = 120;
                break;
            case GUICHET:
                hauteur = 70;
                break;
            case ACTIVITERESTREINTE:
                hauteur = 115;
                break;
            default:
                System.out.println("Le composant choisit n'existe pas");
        }
        return hauteur;
    }

    public int getLargeur(EtapeIG etape){
        int largeur = 0;
        switch (etape.getComposant()){
            case ACTIVITE:
                largeur = 300;
                break;
            case GUICHET:
                largeur = 300;
                break;
            case ACTIVITERESTREINTE:
                largeur = 300;
                break;
            default:
                System.out.println("Le composant choisit n'existe pas");
        }
        return largeur;
    }
}

