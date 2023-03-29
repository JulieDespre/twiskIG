package twisk.mondeIG;

public abstract class ArcIG {
   PointDeControleIG pdcStart;

   PointDeControleIG pdcEnd;
   boolean selec=false;
    public ArcIG ( PointDeControleIG pdcStart, PointDeControleIG pdcEnd) {
    this.pdcStart=pdcStart;
    this.pdcEnd=pdcEnd;
    }

    public double getStartX(){
        return pdcStart.getPosX();
    }
    public double getStartY(){
        return pdcStart.getPosY();
    }

    public double getEndX(){
        return pdcEnd.getPosX();
    }
    public double getEndY(){
        return pdcEnd.getPosY();
    }

    public PointDeControleIG getPdcStart(){
        return pdcStart;
    }

    public PointDeControleIG getPdcEnd(){
        return pdcEnd;
    }
    public int getIdentifiant(PointDeControleIG pdc){
        return pdc.getIdentifiant();
    }

    public void setSelec(){
        selec=!selec;
    }

    public Boolean getSelect(){
        return this.selec;
    }
}
