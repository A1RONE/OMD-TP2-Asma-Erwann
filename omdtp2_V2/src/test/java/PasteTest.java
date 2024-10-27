import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.Editeur;
import com.example.Paste;

public class PasteTest {

    @Test
    public void executeTest()
    {
        Editeur editeur = new Editeur();
        String message = "Hello world!";
        editeur.writeBufferText(message);
        String result = editeur.getBufferText();
        //fail("result : " + ( (editeur.getBufferText()) == message));
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'"); 

        editeur.setSelectionBeginIndex(0);
        editeur.setSelectionEndIndex(5);

        editeur.setPressePapierText("Goodbye");

        //editeur.addCommand("Paste");
        Paste paste = new Paste(editeur);
        paste.execute();

        result = editeur.getBufferText();
        message = "Goodbye world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        result = paste.getOldData();
        message = "Hello";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");


        //editeur.addCommand("Paste");
        paste = new Paste(editeur);
        paste.execute();

        result = editeur.getBufferText();
        message = "GoodbyeGoodbye world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        paste.undo();

        result = editeur.getBufferText();
        message = "Goodbye world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        paste.redo();
 
        result = editeur.getBufferText();
        message = "GoodbyeGoodbye world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");       

        editeur = new Editeur();
        message = "Hello world!";
        editeur.writeBufferText(message);
        result = editeur.getBufferText();
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'"); 

        editeur.setSelectionBeginIndex(0);
        editeur.setSelectionEndIndex(5);

        editeur.setPressePapierText("Goodbye");

        //editeur.addCommand("Paste");
        editeur.addCommand("Paste");

        result = editeur.getBufferText();
        message = "Goodbye world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");



        
    }
}
