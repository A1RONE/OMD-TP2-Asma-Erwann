import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.Editeur;

public class CopyTest {
    
    @Test
    public void testCopy(){

        Editeur editeur = new Editeur();
        String message = "Hello world!";
        String contenu = "";
        editeur.writeBufferText(message);
        String result = editeur.getPressePapierText();
        assertEquals(contenu, result, "Le presse papier devrait contenir \'"+contenu+"\' mais actuellement on a : \'"+result+"\'");

        editeur.setSelectionBeginIndex(0);
        editeur.setSelectionEndIndex(5);

        editeur.addCommand("Copy");

        result = editeur.getPressePapierText();
        contenu = "Hello";
        assertEquals(contenu, result,  "Le presse papier devrait contenir \'"+contenu+"\' mais actuellement on a : \'"+result+"\'");
    }

}
