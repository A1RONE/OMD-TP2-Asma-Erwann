import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.Cut;
import com.example.Editeur;

public class CutTest {

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

        //editeur.addCommand("Paste");
        Cut cut = new Cut(editeur);
        cut.execute();

        result = editeur.getBufferText();
        message = " world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        result = editeur.getPressePapierText();
        message = "Hello";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");       

        result = cut.getOldData();
        message = "Hello";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        //editeur.addCommand("Paste");
        cut = new Cut(editeur);
        cut.execute();

        result = editeur.getBufferText();
        message = " world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        result = editeur.getPressePapierText();
        message = "";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");       

        result = cut.getOldData();
        message = "";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        
        editeur.setSelectionEndIndex(1);

        cut = new Cut(editeur);
        cut.execute();

        result = editeur.getBufferText();
        message = "world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        result = editeur.getPressePapierText();
        message = " ";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");       

        result = cut.getOldData();
        message = " ";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        editeur = new Editeur();
        message = "Hello world!";
        editeur.writeBufferText(message);
        result = editeur.getBufferText();
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'"); 

        editeur.setSelectionBeginIndex(0);
        editeur.setSelectionEndIndex(5);

        editeur.addCommand("Cut");

        result = editeur.getBufferText();
        message = " world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        result = editeur.getPressePapierText();
        message = "Hello";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");       
        
    }
}

