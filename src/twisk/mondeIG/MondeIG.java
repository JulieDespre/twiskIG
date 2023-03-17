package twisk.mondeIG;

import twisk.outils.FabriqueIdentifiant;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class MondeIG extends SujetObserve implements Iterable<EtapeIG> {
    private final HashMap <Integer, EtapeIG> etapes;

    private final HashMap <Integer, EtapeIG> etapesClicked = new HashMap <Integer, EtapeIG>();
    private double pdcCentPosX;
    private double pdcCentPosY;
    //compteur de point pour cubicCurve
    private int cptPt;
    private int cpt;
    //compteur pour activitée clickée
    private int cptAct;
    private PointDeControleIG pdcClick=null;
    private final ArrayList<LigneDroiteIG> lignes =new ArrayList<LigneDroiteIG>();
    private final ArrayList<CourbeIG> courbes =new ArrayList<CourbeIG>();
    private Boolean creationLigne = false;
    private Boolean creationCour = false;


    public MondeIG(){
        this.etapes = new HashMap<Integer, EtapeIG>();
    }


    @Override
    public Iterator<EtapeIG> iterator() {
        return etapes.values().iterator();
    }

    public void ajouterEtape(EtapeIG... NewEtapes){
        for (EtapeIG e: NewEtapes) {
            e.ajouterPDC();
            this.etapes.put(e.getIdentifiant(),e);
            this.notifierObservateurs();
        }
    }

    public HashMap<Integer, EtapeIG> getEtapes(){
        return etapes;
        }


    public HashMap<Integer, EtapeIG> getEtapesClicked(){
        return etapesClicked;
    }
    public void  ajouterEtapesClicked(EtapeIG etape){
            etapesClicked.put(etape.getIdentifiant(), etape);
            this.notifierObservateurs();
    }


    public EtapeIG getEtape(int identifiant){
        return etapes.get(identifiant);
    }


    public void destructeurDeMonde() {
    // Réinitialiser le monde
            etapes.clear();
            lignes.clear();
            courbes.clear();
            FabriqueIdentifiant identifiant = FabriqueIdentifiant.getInstance();
            identifiant.reset();
            this.notifierObservateurs();
    }

    public double getCpt(){
        return cpt;
    }

    public void setCpt(int newCpt){
       cpt = newCpt;
    }
    public double getPdcCentPosX(){
        return pdcCentPosX;
    }
    public void setPdcCentPosX(double newPosX){
        pdcCentPosX = newPosX;
    }

    public double getPdcCentPosY(){
        return pdcCentPosY;
    }

    public void setPdcCentPosY(double newPosY){
        pdcCentPosY = newPosY;
    }
    public PointDeControleIG getPdcClick(){
        return pdcClick;
    }

    public void setPdcClick(PointDeControleIG newPdcClick){
        pdcClick = newPdcClick;
    }

    public void ajouterLigne(PointDeControleIG pdcStart, PointDeControleIG pdcEnd) {
        LigneDroiteIG newArc = new LigneDroiteIG(pdcStart,pdcEnd);
        lignes.add(newArc);
        this.notifierObservateurs();
    }

    public void ajouterCourbe(PointDeControleIG pdcStart, Point p1, Point p2, PointDeControleIG pdcEnd) {
        CourbeIG newCourbe = new CourbeIG(pdcStart, pdcEnd, p1, p2);
        courbes.add(newCourbe);
        this.notifierObservateurs();
    }
    public ArrayList<LigneDroiteIG> getLignes() {
        return lignes;
    }

    public ArrayList<CourbeIG> getCourbes() {
        return courbes;
    }

    public boolean getcreationLigne(){
        return creationLigne;
    }
    public void setCreationLigne(boolean newcreaLig){
        this.creationLigne = newcreaLig;
    }

    public boolean getcreationCourbe(){
        return creationCour;
    }
    public void setCreationCourbe(boolean newcreaCour){
        this.creationCour = newcreaCour;
    }
    public int getCptpt(){
        return cptPt;
    }
    public int getCptAct(){
        return cptAct;
    }


    public void increCpt(){
        cpt = cpt + 1;
    }
}
