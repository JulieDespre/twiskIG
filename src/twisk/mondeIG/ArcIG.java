package twisk.mondeIG;

public class ArcIG {
   PointDeControleIG pdcStart;

   PointDeControleIG pdcEnd;
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

}
