package twisk.mondeIG;

import twisk.exceptions.ExceptionEtape;
import twisk.exceptions.TwiskException;
import twisk.outils.FabriqueIdentifiant;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class MondeIG extends SujetObserve implements Iterable<EtapeIG> {
    private final HashMap <Integer, EtapeIG> etapes;

    private final ArrayList <EtapeIG> etapesClicked = new ArrayList<>();
    private double pdcCentPosX;
    private double pdcCentPosY;
    //compteur pdc clické
    private int cpt;
    //compteur pour activitée clickée
    private int cptAct;
    private PointDeControleIG pdcClick=null;
    private final ArrayList<LigneDroiteIG> lignes =new ArrayList<LigneDroiteIG>();
    private final ArrayList<CourbeIG> courbes =new ArrayList<CourbeIG>();
    private Boolean creationLigne = false;
    private Boolean creationCourbe = false;
    private ArrayList<PointDeControleIG> pdcClicked = new ArrayList<PointDeControleIG>();
    private ArrayList<Point> pointClicked = new ArrayList<Point>();
    private ArrayList<EtapeIG> mondeEntree= new ArrayList<EtapeIG>();
    private ArrayList<EtapeIG> mondeSortie= new ArrayList<EtapeIG>();


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
    public void ajouterLigne(PointDeControleIG pdcStart, PointDeControleIG pdcEnd) throws TwiskException {
        if (pdcStart.getEtapePDC().getIdentifiant() != pdcEnd.getEtapePDC().getIdentifiant())
        {
            LigneDroiteIG newArc = new LigneDroiteIG(pdcStart, pdcEnd);
            lignes.add(newArc);
            this.notifierObservateurs();
        } else {
            throw new TwiskException();
        }
    }

    public void ajouterCourbe(PointDeControleIG pdcStart, Point p1, Point p2, PointDeControleIG pdcEnd) throws TwiskException {
        if (pdcStart.getEtapePDC().getIdentifiant() != pdcEnd.getEtapePDC().getIdentifiant()) {
            CourbeIG newCourbe = new CourbeIG(pdcStart, p1, p2, pdcEnd);
            courbes.add(newCourbe);
            this.notifierObservateurs();
        } else {
            throw new TwiskException();
        }
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
                            pdcClicked.remove(lignes.get(i).getPdcStart());
                            pdcClicked.remove(lignes.get(i).getPdcEnd());
                            lignes.get(i).getPdcStart().setHasNoArc();
                            lignes.get(i).getPdcEnd().setHasNoArc();
                            lignes.get(i).getPdcStart().setCpt(0);
                            lignes.get(i).getPdcEnd().setCpt(0);
                            lignes.remove(arc);
                            i--;
                        }
                    }
                    for(int j=0;j<courbes.size();j++) {
                        ArcIG arc = courbes.get(j);
                        if (pdc.getIdentifiant() == arc.getPdcStart().getIdentifiant() || pdc.getIdentifiant() == arc.getPdcEnd().getIdentifiant()) {
                            pdcClicked.remove(courbes.get(j).getPdcStart());
                            pdcClicked.remove(courbes.get(j).getPdcEnd());
                            courbes.get(j).getPdcStart().setHasNoArc();
                            courbes.get(j).getPdcEnd().setHasNoArc();
                            courbes.get(j).getPdcStart().setCpt(0);
                            courbes.get(j).getPdcEnd().setCpt(0);
                            courbes.remove(arc);
                            j--;
                        }
                    }
                }
            etapes.remove(etape.getIdentifiant());
        }
        this.etapesClicked.clear();
        this.notifierObservateurs();
    }

    public int nbEtapeSelec(){
        return etapesClicked.size();
    }

    public void ajouterPdcClicked(PointDeControleIG pdc){
        pdcClicked.add(pdc);
    }
    public ArrayList<PointDeControleIG> getPdcClicked(){
        return pdcClicked;
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
        if(pdcClicked != null) {
            pointClicked.add(point);
            this.notifierObservateurs();
        }
    }

    public void clearPointClicked(){
        this.pointClicked.clear();
    }

    public ArrayList<EtapeIG> aCommeEntree(){
        return mondeEntree;
    }

    public void ajouterEntree(EtapeIG etape) throws ExceptionEtape{
        if(!aCommeEntree().contains(etape)) {
            mondeEntree.add(etape);
            etape.setEstEntree(true);
            this.notifierObservateurs();
        }else{
            throw new ExceptionEtape();
        }
    }

    public ArrayList<EtapeIG> aCommeSortie(){
        return mondeSortie;
    }

    public void ajouterSortie(EtapeIG etape) throws ExceptionEtape {
        if(!aCommeSortie().contains(etape)) {
            mondeSortie.add(etape);
            etape.setEstSortie(true);
            this.notifierObservateurs();
        } else {
            throw new ExceptionEtape();
        }
    }

    public void suppArcs(){
        for (int i=0;i<lignes.size();i++){
            if (lignes.get(i).getSelect()) {
                pdcClicked.remove(lignes.get(i).getPdcStart());
                pdcClicked.remove(lignes.get(i).getPdcEnd());
                lignes.get(i).getPdcStart().setHasNoArc();
                lignes.get(i).getPdcEnd().setHasNoArc();
                lignes.get(i).getPdcStart().setCpt(0);
                lignes.get(i).getPdcEnd().setCpt(0);
                lignes.remove(i);
                i--;
            }
        }
        for (int i=0;i<courbes.size();i++){
            if (courbes.get(i).getSelect()) {
                pdcClicked.remove(courbes.get(i).getPdcStart());
                pdcClicked.remove(courbes.get(i).getPdcEnd());
                courbes.get(i).getPdcStart().setHasNoArc();
                courbes.get(i).getPdcEnd().setHasNoArc();
                courbes.get(i).getPdcStart().setCpt(0);
                courbes.get(i).getPdcEnd().setCpt(0);
                courbes.remove(i);
                i--;
            }
        }

        notifierObservateurs();
    }



}
