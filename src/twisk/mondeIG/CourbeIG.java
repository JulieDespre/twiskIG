package twisk.mondeIG;

import java.awt.*;

public class CourbeIG {
        PointDeControleIG pdcStart;
        Point p1;
        Point p2;
        PointDeControleIG pdcEnd;
        public CourbeIG (PointDeControleIG pdcStart, PointDeControleIG pdcEnd, Point p1, Point p2) {
            this.pdcStart=pdcStart;
            this.p1 = p1;
            this.p2 = p2;
            this.pdcEnd=pdcEnd;
        }

        public double getStartX(){
            return pdcStart.getPosX();
        }
        public double getStartY(){
            return pdcStart.getPosY();
        }

        public double getP1X(){
            return p1.getX();
        }
        public double getP1Y(){
            return p1.getY();
        }
        public double getP2X(){
            return p2.getX();
        }
        public double getP2Y(){
            return p2.getY();
        }

        public double getEndX(){
            return pdcEnd.getPosX();
        }

        public double getEndY(){
            return pdcEnd.getPosY();
        }


}
