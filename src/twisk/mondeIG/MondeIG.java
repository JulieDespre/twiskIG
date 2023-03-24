package twisk.mondeIG;

import twisk.outils.FabriqueIdentifiant;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class MondeIG extends SujetObserve implements Iterable<EtapeIG> {
    private final HashMap <Integer, EtapeIG> etapes;

    private final ArrayList <EtapeIG> etapesClicked = new ArrayList <EtapeIG>();
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
    private Boolean creationCourbe = false;
    private ArrayList<Point> pointClicked = new ArrayList<Point>();


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

    public ArrayList<EtapeIG> getEtapesClicked(){
        return etapesClicked;
    }

    public EtapeIG getEtapesClicked(int indice){
        return etapesClicked.get(indice);
    }
    public void  ajouterEtapesClicked(EtapeIG etape){
            etapesClicked.add(etape);
            this.notifierObservateurs();
    }


    public boolean hasBeenClicked(EtapeIG etape){
        return etapesClicked.contains(etape);
    }

    public void enleverEtapesClicked(EtapeIG etape){
        etapesClicked.remove(etape);
    }

    //methode nouveau
    public void destructeurDeMonde() {
    // Réinitialiser le monde
            etapes.clear();
            lignes.clear();
            courbes.clear();
            FabriqueIdentifiant identifiant = FabriqueIdentifiant.getInstance();
            identifiant.reset();
            this.notifierObservateurs();
    }

    public void setPdcCentPosX(double newPosX){
        pdcCentPosX = newPosX;
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

    //ajouter les arcs
    public void ajouterLigne(PointDeControleIG pdcStart, PointDeControleIG pdcEnd) {
        LigneDroiteIG newArc = new LigneDroiteIG(pdcStart,pdcEnd);
        lignes.add(newArc);
        this.notifierObservateurs();
    }

    public void ajouterCourbe(PointDeControleIG pdcStart, Point p1, Point p2, PointDeControleIG pdcEnd) {
        CourbeIG newCourbe = new CourbeIG(pdcStart, p1, p2, pdcEnd);
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
        return creationCourbe;
    }
    public void setCreationCourbe(boolean newcreaCour){
        this.creationCourbe = newcreaCour;
    }
    public int getCptpt(){
        return cptPt;
    }
    public int getCptAct(){
        return cptAct;
    }
    public void setCptAct(int newCpt){
        cptAct = newCpt;
    }
    public void increCptAct(){
        cptAct = cptAct + 1;
    }
    public void increCpt(){
        cpt = cpt + 1;
    }


    //suprime étape(s) sélectionnées et arc qui lui sont reliées
    public void supprimerEtapes(){
        System.out.println(etapesClicked.size());
        for(EtapeIG etape : etapesClicked){
                for(PointDeControleIG pdc : etape.getPdc()){
                    for(int i=0;i<lignes.size();i++){
                        ArcIG arc= lignes.get(i);
                        if(pdc.getIdentifiant() == arc.getPdcStart().getIdentifiant() || pdc.getIdentifiant() == arc.getPdcEnd().getIdentifiant()){
                            lignes.remove(arc);
                            i--;
                        }
                    }
                }
            etapes.remove(etape.getIdentifiant());
        }
        this.etapesClicked.clear();
        System.out.println(etapesClicked.size());
        this.notifierObservateurs();
    }

    public int nbEtapeSelec(){
        return etapesClicked.size();
    }

    public Point getPointCliked(int i){
        return pointClicked.get(i);
    }

    public ArrayList<Point> getPointCliked(){
        return pointClicked;
    }

    public int getTaillePointCliked (){
        return pointClicked.size();
    }
    public void  ajouterPointClicked(Point point){
        pointClicked.add(point);
        this.notifierObservateurs();
    }


}
