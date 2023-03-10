package twisk.mondeIG;

import twisk.outils.FabriqueIdentifiant;

import java.awt.*;

public abstract class EtapeIG extends SujetObserve {
    private String nom;
    private int  identifiant;
    private double posX = 100;
    private double posY= 100;
    private int largeur;
    private int hauteur;
    private int temps;
    private int delais;
    private Composant composant;

    public EtapeIG(String nom, int largeur, int hauteur, int temps, int delais){
        this.nom= nom;
        this.largeur= largeur;
        this.hauteur= hauteur;
        this.temps= temps;
        this.delais= delais;
        FabriqueIdentifiant maFabrique=FabriqueIdentifiant.getInstance();
        this.identifiant= maFabrique.getNumero();
    }

    public EtapeIG(String nom, int temps, int delais){
        this.nom= nom;
        this.temps= temps;
        this.delais= delais;
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

    public int getTemps(){
        return this.temps;
    }

    public int getDelais(){
        return this.delais;
    }

    public String getNom(){
        return this.nom;
    }

    public Composant getComposant(){
        return this.composant;
    }
 //setters pour Etapes
    public void setComposant(Composant composant){
        this.composant=composant;
    }
    public void setPosX(double newPosX ){
        this.posX = newPosX;
        notifierObservateurs();
    }

    public void setPosY(double newPosY){
        this.posY = newPosY;
        notifierObservateurs();
    }


    public void setNom(String newNom){
        this.nom = newNom;
        notifierObservateurs();
    }
}
