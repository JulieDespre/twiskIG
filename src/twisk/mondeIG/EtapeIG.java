package twisk.mondeIG;

import twisk.outils.FabriqueIdentifiant;

import java.awt.*;

public abstract class EtapeIG extends SujetObserve {
    private String nom;
    private final int  identifiant;
    private double posX = 100;
    private double posY= 100;
    private final int largeur;
    private final int hauteur;

    public EtapeIG(String nom, int largeur, int hauteur){
        this.nom= nom;
        this.largeur= largeur;
        this.hauteur= hauteur;
        FabriqueIdentifiant maFabrique=FabriqueIdentifiant.getInstance();
        this.identifiant= maFabrique.getNumero();
    }

    public EtapeIG(String nom, Point point, int largeur, int hauteur){
        this.nom= nom;
        this.largeur= largeur;
        this.hauteur= hauteur;
        this.posX= point.getX();
        this.posY= point.getY();
        FabriqueIdentifiant maFabrique=FabriqueIdentifiant.getInstance();
        this.identifiant= maFabrique.getNumero();
    }

    //getters pour etape
    public int getIdentifiant(){
        return identifiant;
    }

    public double getPosX(){
        return this.posX;
    }

    public double getPosY(){
        return this.posY;
    }

    public int getHauteur(){
        return this.hauteur;
    }

    public int getLargeur(){
        return this.largeur;
    }

    public String getNom(){
        return this.nom;
    }
 //setters pour Etapes

    public void setEtapePosX(double newPosX ){
        this.posX = newPosX;
        notifierObservateurs();
    }

    public void setEtapePosY(double newPosY){
        this.posY = newPosY;
        notifierObservateurs();
    }


    public void setNom(String newNom){
        this.nom = newNom;
        notifierObservateurs();
    }
}
