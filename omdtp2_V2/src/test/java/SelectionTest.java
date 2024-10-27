import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.Selection;

public class SelectionTest {
    @Test
    public void testGetBeginIndex()
    {
        Selection selection = new Selection();
        int resultat = selection.getBeginIndex();
        assertEquals(0, resultat, "Le resultat devrais être 0. En réalité le résultat est : "+ resultat);

    }

    @Test
    public void testGetEndIndex()
    {
        Selection selection = new Selection();
        int resultat = selection.getEndIndex();
        assertEquals(0, resultat, "Le resultat devrais être 0. En réalité le résultat est : "+ resultat);
    }

    @Test
    public void testSetBeginIndex()
    {
        Selection selection = new Selection();
        int resultat = selection.getBeginIndex();
        assertEquals(0, resultat, "Le resultat devrais être 0. En réalité le résultat est : "+ resultat);

        selection.setBeginIndex(10);
        resultat = selection.getBeginIndex();
        assertEquals(10, resultat, "Le resultat devrais être 10. En réalité le résultat est : "+ resultat);
        assertThrows(IllegalArgumentException.class, () ->
        {
            selection.setEndIndex(-1);
        },"An IllegalArgumentException should have been thrown");

    }

    @Test
    public void testSetEndIndex()
    {
        Selection selection = new Selection();
        int resultat = selection.getEndIndex();
        assertEquals(0, resultat, "Le resultat devrais être 0. En réalité le résultat est : "+ resultat);

        selection.setEndIndex(10);
        resultat = selection.getEndIndex();
        assertEquals(10, resultat, "Le resultat devrais être 10. En réalité le résultat est : "+ resultat);

        assertThrows(IllegalArgumentException.class, () ->
        {
            selection.setEndIndex(-1);
        },"An IllegalArgumentException should have been thrown");
    }
}
