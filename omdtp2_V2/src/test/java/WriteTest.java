import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.Editeur;
import com.example.Write;

public class WriteTest {

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
        Write write = new Write(editeur);
        String text = "Goodbye";
        write.setNewText(text);
        write.execute();

        result = editeur.getBufferText();
        message = "Goodbye world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        result = write.getOldData();
        message = "Hello";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");
        
        write = new Write(editeur);
        text = " Bob";
        write.setNewText(text);
        write.execute();

        result = editeur.getBufferText();
        message = "Goodbye Bob world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        result = write.getOldData();
        message = "";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        write.undo();

        result = editeur.getBufferText();
        message = "Goodbye world!";
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");


    }
}
