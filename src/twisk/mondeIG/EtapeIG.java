package twisk.mondeIG;

import twisk.outils.FabriqueIdentifiant;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class EtapeIG extends SujetObserve implements Iterable<PointDeControleIG> {
    private String nom;
    private int  identifiant;
    private double posX;
    private double posY= 100;
    private int largeur;
    private int hauteur;
    private int temps;
    private int delais;
    private Composant composant;
    private ArrayList<PointDeControleIG > pointsDeControle=new ArrayList<PointDeControleIG>(4);

    public EtapeIG(String nom, int largeur, int hauteur, int temps, int delais){
        this.nom= nom;
        this.largeur= largeur;
        this.hauteur= hauteur;
        this.temps= temps;
        this.delais= delais;
        FabriqueIdentifiant maFabrique=FabriqueIdentifiant.getInstance();
        this.identifiant= maFabrique.getNumeroActivite();
    }

    public EtapeIG(String nom, int temps, int delais){
        this.nom= nom;
        this.temps= temps;
        this.delais= delais;
        FabriqueIdentifiant maFabrique=FabriqueIdentifiant.getInstance();
        this.identifiant= maFabrique.getNumeroActivite();
        this.posX=100*identifiant;
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

    public void ajouterPDC(){
        FabriqueIdentifiant identifiant = FabriqueIdentifiant.getInstance();
        PointDeControleIG pdcA = new PointDeControleIG(this.getPosX(), this.getPosY()+(this.getHauteur()/2), this);
        PointDeControleIG pdcB = new PointDeControleIG(this.getPosX()+(this.getLargeur()/2),this.getPosY()+this.getHauteur(), this);
        PointDeControleIG pdcC = new PointDeControleIG(this.getPosX()+this.getLargeur(),this.getPosY()+(this.getHauteur()/2), this);
        PointDeControleIG pdcD = new PointDeControleIG(this.getPosX()+(this.getLargeur()/2),this.getPosY(),this);
        pointsDeControle.add(pdcA);
        pointsDeControle.add(pdcB);
        pointsDeControle.add(pdcC);
        pointsDeControle.add(pdcD);
        notifierObservateurs();
    }

    public PointDeControleIG getPdc(int i){
        return pointsDeControle.get(i);
    }


    public void setNom(String newNom){
        this.nom = newNom;
        notifierObservateurs();
    }
    @Override
    public Iterator<PointDeControleIG> iterator() {
        return pointsDeControle.iterator();
    }
}
