import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.Editeur;
import com.example.Select;

public class SelectTest {
    @Test
    public void executeTest()
    {
        Editeur editeur = new Editeur();
        String message = "Hello world!";
        editeur.writeBufferText(message);
        String result = editeur.getBufferText();
        //fail("result : " + ( (editeur.getBufferText()) == message));
        assertEquals(message, result, "Le text devrait être \'"+message+"\' mais actuellement on a : \'"+result+"\'");

        int base_begin_id = 0;
        int base_end_id = 5;

        Select select = new Select(editeur);
        select.setBeginIndex(base_begin_id);
        select.setEndIndex(base_end_id);
        select.execute();

        int begin_id = editeur.getSelectionBeginIndex();
        int end_id = editeur.getSelectionEndIndex();
        assertEquals(base_begin_id, begin_id, "L'index devrait être' \'"+String.valueOf(base_begin_id)+"\' mais actuellement on a : \'"+String.valueOf(begin_id)+"\'");
        assertEquals(base_end_id, end_id, "L'index devrait être' \'"+String.valueOf(base_end_id)+"\' mais actuellement on a : \'"+String.valueOf(end_id)+"\'");

        select.undo();
        begin_id = editeur.getSelectionBeginIndex();
        end_id = editeur.getSelectionEndIndex();
        assertEquals(0, begin_id, "L'index devrait être' \'"+String.valueOf(0)+"\' mais actuellement on a : \'"+String.valueOf(begin_id)+"\'");
        assertEquals(0, end_id, "L'index devrait être' \'"+String.valueOf(0)+"\' mais actuellement on a : \'"+String.valueOf(end_id)+"\'");


    }

}
