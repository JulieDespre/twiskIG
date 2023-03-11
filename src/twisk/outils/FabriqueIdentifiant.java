package twisk.outils;

public class FabriqueIdentifiant {
        private static final FabriqueIdentifiant instance = new FabriqueIdentifiant();
        private int numeroAct;
        private int numeroPDC;
        /**
         * Constructeur FabriqueIdentifiant
        *
        */
        private FabriqueIdentifiant() {
            reset();
        }

        /**
         * retourne l'instance de la fabrique d'Indentifiant
         *
         * @return l'instance de la fabrique d'Identifiant
         */
        public static FabriqueIdentifiant getInstance() {
            return instance;
        }

        /**
         * remet a zéro le numéro généré par la fabique d'itentifiant
         */
        public void reset() {
            numeroAct = 0;
            numeroPDC = 0;
        }

        /**
         * retourne le numéro unique généré par la fabrique d'identifiant
         *
         * @return le numéro
         */
        public int getNumeroActivite() {
            numeroAct++;
            return numeroAct;
        }

        public int getNumeroPDC() {
        numeroPDC++;
        return numeroPDC;
    }


}


