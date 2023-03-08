package twisk.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;

public class testEtapeIG {
    @Test
    public void TestConstructeurEtape() {
        EtapeIG e1 = new ActiviteIG("test1", 10, 10, 6, 2);
        String test = e1.getNom();
        Assertions.assertEquals("test1", test);
    }

    @Test
    public void TestConstructeurEtape2() {
        EtapeIG e1 = new ActiviteIG("test1", 10, 10, 6, 2);
        int test = e1.getIdentifiant();
        Assertions.assertEquals(1, test);
    }

    @Test
    public void TestConstructeurEtape3() {
        EtapeIG e1 = new ActiviteIG("test1", 10, 10, 6, 2);
        EtapeIG e2 = new ActiviteIG("test1", 10, 10, 6, 2);
        int test = e1.getIdentifiant();
        int test2 = e2.getIdentifiant();
        Assertions.assertNotEquals(test2, test);
    }
}
