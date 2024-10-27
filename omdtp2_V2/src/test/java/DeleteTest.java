import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.Delete;
import com.example.Editeur;

public class DeleteTest {

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
        Delete delete = new Delete(editeur);
        delete.execute();

        result = editeur.getBufferText();
        message = " world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");     

        result = delete.getOldData();
        message = "Hello";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        editeur.setSelectionBeginIndex(1);
        editeur.setSelectionEndIndex(1);

        delete = new Delete(editeur);
        delete.execute();

        result = editeur.getBufferText();
        message = "world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");     

        result = delete.getOldData();
        message = " ";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        delete.undo();

        result = editeur.getBufferText();
        message = " world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'"); 
        
        delete.redo();
        result = editeur.getBufferText();
        message = "world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");    

        editeur = new Editeur();
        message = "Hello world!";
        editeur.writeBufferText(message);
        result = editeur.getBufferText();
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'"); 

        editeur.setSelectionBeginIndex(0);
        editeur.setSelectionEndIndex(5);

        editeur.addCommand("Delete");

        result = editeur.getBufferText();
        message = " world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");   
        
    }   
}
