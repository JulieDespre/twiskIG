package twisk.outils;

public class FabriqueIdentifiant {
        private static FabriqueIdentifiant instance = new FabriqueIdentifiant();
        private int numero;
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
            numero = 0;
        }

        /**
         * retourne le numéro unique généré par la fabrique d'identifiant
         *
         * @return le numéro
         */
        public int getNumero() {
            numero++;
            return numero;
        }

}


