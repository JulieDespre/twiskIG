package twisk.mondeIG;

import twisk.exceptions.ExceptionDelais;
import twisk.exceptions.ExceptionEtape;
import twisk.exceptions.ExceptionTemps;
import twisk.outils.FabriqueIdentifiant;
import twisk.outils.TailleComposants;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class EtapeIG extends SujetObserve implements Iterable<PointDeControleIG> {
    private String nom;

    private final int identifiant;
    private double posX;
    private double posY;
    private int largeur;
    private int hauteur;
    private int temps =5;
    private int delais =2;
    private Composant composant;
    private final ArrayList<PointDeControleIG > pointsDeControle=new ArrayList<PointDeControleIG> (4);
    private Boolean estEntree = false;
    private Boolean estSortie = false;
    private Boolean wasEntry = false;
    private Boolean wasExit = false;


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
        this.posX=100;
        this.posY=100;
    }

    public EtapeIG(){
        FabriqueIdentifiant maFabrique=FabriqueIdentifiant.getInstance();
        this.identifiant= maFabrique.getNumeroActivite();
        this.nom="Activité "+this.identifiant;
        this.posX=100;
        this.posY=100;
    }

    protected void setTailles(){
        TailleComposants taille=TailleComposants.getInstance();
        this.hauteur= taille.getHauteur(this);
        this.largeur=taille.getLargeur(this);
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
        PointDeControleIG pdcA = new PointDeControleIG(this.getPosX(), this.getPosY()+(this.getHauteur()/2), this);
        PointDeControleIG pdcB = new PointDeControleIG(this.getPosX()+(this.getLargeur()/2),this.getPosY()+this.getHauteur(), this);
        PointDeControleIG pdcC = new PointDeControleIG(this.getPosX()+this.getLargeur(),this.getPosY()+(this.getHauteur()/2), this);
        PointDeControleIG pdcD = new PointDeControleIG(this.getPosX()+(this.getLargeur()/2),this.getPosY(),this);
        pointsDeControle.add(pdcA);
        pointsDeControle.add(pdcB);
        pointsDeControle.add(pdcC);
        pointsDeControle.add(pdcD);
        notifierObservateurs();
        for (PointDeControleIG pdc : pointsDeControle) {
            System.out.println(pdc);
        }
    }
    public void refreshPdc(){
        pointsDeControle.get(0).setPdc(this.getPosX(), this.getPosY()+(this.getHauteur()/2));
        pointsDeControle.get(1).setPdc(this.getPosX()+(this.getLargeur()/2),this.getPosY()+this.getHauteur());
        pointsDeControle.get(2).setPdc(this.getPosX()+this.getLargeur(),this.getPosY()+(this.getHauteur()/2));
        pointsDeControle.get(3).setPdc(this.getPosX()+(this.getLargeur()/2),this.getPosY());
    }

    public ArrayList<PointDeControleIG> getPdc(){
        return pointsDeControle;
    }

    public void setNomEtapeClicked(String newNom){
        this.nom = newNom;
        this.notifierObservateurs();
    }
    public void setTpsEtapeClicked(int newTps) throws ExceptionTemps {
        if (newTps < 10 && newTps > 0) {
            this.temps = newTps;
            this.notifierObservateurs();
        } else {
            throw new ExceptionTemps();
        }
    }

    public void setDelEtapeClicked(int newDel) throws ExceptionDelais {
        if (newDel < 10 && newDel > 0) {
            this.temps = newDel;
            this.notifierObservateurs();
        } else {
            throw new ExceptionDelais();
        }
    }


    public Boolean estEntree(){
        return estEntree;
    }

    public Boolean setEstEntree(Boolean b){
        return estEntree = b;
    }

    public Boolean estSortie(){
        return estSortie;
    }

    public Boolean setEstSortie(Boolean b){
        return estSortie = b;
    }
    public Boolean wasEntry(){
        return wasEntry;
    }

    public void setWasEntry(Boolean bool){
        wasEntry = bool;
    }

    public Boolean wasExit(){
        return wasExit;
    }

    public void setWasExit(Boolean bool){
        wasExit = bool;
    }
    @Override
    public Iterator<PointDeControleIG> iterator() {
        return pointsDeControle.iterator();
    }
}
