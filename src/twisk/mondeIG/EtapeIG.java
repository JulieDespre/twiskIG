package twisk.mondeIG;

import java.awt.*;

public abstract class EtapeIG {
    private String nom;
    private String identifiant;
    private double posX = 100;
    private double posY= 100;
    private int largeur;
    private int hauteur;

    public EtapeIG(String nom, int largeur, int hauteur){
            this.nom= nom;
            this.largeur= largeur;
            this.hauteur= hauteur;

    }

    public EtapeIG(String nom, Point point, int largeur, int hauteur){
        this.nom= nom;
        this.largeur= largeur;
        this.hauteur= hauteur;
        this.posX= point.getX();
        this.posY= point.getY();
    }

    //getters pour etape
    double getEtapePosX(){
        return this.posX;
    }

    double getEtapePosY(){
        return this.posY;
    }

    int getEtapeHauteur(){
        return this.hauteur;
    }

    int getEtapeLargeur(){
        return this.largeur;
    }

    String getNom(){
        return this.nom;
    }
 //setters pour Etapes
    double setEtapePosX(double newPosX ){
        return this.posX = newPosX;
 }

    double setEtapePosY(double newPosY){
        return this.posY = newPosY;
    }

    int setEtapeHauteur(int newHauteur){
        return this.hauteur= newHauteur;
    }

    int setEtapeLargeur(int newLargeur){
        return this.largeur= newLargeur;
    }

    String setNom(String newNom){
        return this.nom= newNom;
    }
}
