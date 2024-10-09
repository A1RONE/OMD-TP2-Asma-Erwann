
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.Buffer;

public class BufferTest {

    @Test
    public void testAddText() {
        // Créer une instance de la classe à tester
        Buffer buffer = new Buffer();
        // Appeler la méthode à tester
        buffer.addText("Hello World!");
        String resultat = buffer.getText();
        // Vérifier que le résultat est celui attendu
        assertEquals("Hello World!", resultat, "Le texte devrais renvoyer \'Hello World!\'");
        buffer.addText(" Bonjour patate!");
        resultat = buffer.getText();
        assertEquals("Hello World! Bonjour patate!", resultat, "Le texte devrais renvoyer \'Hello World! Bonjour patate!\'");
    }
    @Test
    public void testGetText(){
        Buffer buffer = new Buffer();
        String resultat = buffer.getText();
        assertEquals("", resultat, "Le texte devrait être vide.");
        buffer.addText("Hello World!");
        resultat = buffer.getText();
        assertEquals("Hello World!", resultat, "Le texte devrais renvoyer \'Hello World!\'");
    }
    @Test
    public void testDeleteText(){
        Buffer buffer = new Buffer();

        buffer.addText("Hello World!");
        String resultat = buffer.getText();
        assertEquals("Hello World!", resultat, "Le texte devrais renvoyer \'Hello World!\'");
        
        buffer.deleteText();
        resultat = buffer.getText();
        assertEquals("", resultat, "Le message devrais être vide.");
    }
    @Test
    public void testGetSelection()
    {
        Buffer buffer = new Buffer();

        buffer.addText("Hello World!");
        String resultat = buffer.getText();
        assertEquals("Hello World!", resultat, "Le texte devrais renvoyer \'Hello World!\'");

        resultat = buffer.getSelection(0, 4);
        assertEquals("Hell", resultat, "Le message renvoyé devrais être \'Hell\'");

        resultat = buffer.getSelection(10, 12);
        assertEquals("d!", resultat, "Le message renvoyé devrais être \'d!\'");

        resultat = buffer.getSelection(2, 10);
        assertEquals("llo Worl", resultat, "Le message renvoyé devrais être \'llo Worl\'");

        resultat = buffer.getSelection(3, 3);
        assertEquals("", resultat, "Le message renvoyé devrais être \'\', en réalité on obtient : \'"+resultat+"\'");

        resultat = buffer.getSelection(12, 10);
        assertEquals("d!", resultat, "Le message renvoyé devrais être \'\', en réalité on obtient : \'"+resultat+"\'");
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            buffer.getSelection(-2, 10); // Indices invalides
        }, "IndexOutOfBoundsException should have been thrown");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            buffer.getSelection(0, 20); // Indices invalides
        }, "IndexOutOfBoundsException should have been thrown");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            buffer.getSelection(10, -2); // Indices invalides
        }, "IndexOutOfBoundsException should have been thrown");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            buffer.getSelection(20, 0); // Indices invalides
        }, "IndexOutOfBoundsException should have been thrown");
        

    }
    @Test
    public void testDeleteSelection()
    {
        Buffer buffer = new Buffer();
        buffer.addText("Hello World!");
        String resultat = buffer.getText();
        assertEquals("Hello World!", resultat, "Le texte devrais renvoyer \'Hello World!\'");

        buffer.deleteText();
        buffer.addText("Hello World!");

        buffer.deleteSelection(0, 4);
        resultat = buffer.getText();
        assertEquals("o World!", resultat, "Le texte devrais renvoyer \'o World!\', en réalité on obtient : \'"+resultat+"\'");

        buffer.deleteText();
        buffer.addText("Hello World!");
        
        buffer.deleteSelection(3, 3);
        resultat = buffer.getText();
        assertEquals("Hello World!", resultat, "Le texte devrais renvoyer \'Hello World!\', en réalité on obtient : \'"+resultat+"\'");

        buffer.deleteText();
        buffer.addText("Hello World!");

        buffer.deleteSelection(10, 12);
        resultat = buffer.getText();
        assertEquals("Hello Worl", resultat, "Le texte devrais renvoyer \'Hello Worl\', en réalité on obtient : \'"+resultat+"\'");

        buffer.deleteText();
        buffer.addText("Hello World!");

        buffer.deleteSelection(4, 0);
        resultat = buffer.getText();
        assertEquals("o World!", resultat, "Le texte devrais renvoyer \'o World!\', en réalité on obtient : \'"+resultat+"\'");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            buffer.deleteSelection(-2, 10); // Indices invalides
        }, "IndexOutOfBoundsException should have been thrown");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            buffer.deleteSelection(0, 20); // Indices invalides
        }, "IndexOutOfBoundsException should have been thrown");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            buffer.deleteSelection(10, -2); // Indices invalides
        }, "IndexOutOfBoundsException should have been thrown");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            buffer.deleteSelection(20, 0); // Indices invalides
        }, "IndexOutOfBoundsException should have been thrown");

    }
    @Test
    public void testReplacetext()
    {
        Buffer buffer = new Buffer();
        buffer.addText("Hello World!");
        String resultat = buffer.getText();
        assertEquals("Hello World!", resultat, "Le texte devrais renvoyer \'Hello World!\'");       
        
        buffer.replaceText("Goodbye", 0, 5);
        resultat = buffer.getText();
        assertEquals("Goodbye World!", resultat, "Le texte devrais renvoyer \'Goodbye World!\', en réalité on obtient : \'"+resultat+"\'");

        buffer.replaceText("School!", 8, 14);
        resultat = buffer.getText();
        assertEquals("Goodbye School!", resultat, "Le texte devrais renvoyer \'Goodbye School!\', en réalité on obtient : \'"+resultat+"\'");

        buffer.replaceText("Hello", 7, 0);
        resultat = buffer.getText();
        assertEquals("Hello School!", resultat, "Le texte devrais renvoyer \'Hello School!\', en réalité on obtient : \'"+resultat+"\'"); 
        
        buffer.replaceText("World and Goodbye ", 6, 6);
        resultat = buffer.getText();
        assertEquals("Hello World and Goodbye School!", resultat, "Le texte devrais renvoyer \'Hello World and Goodbye School!\', en réalité on obtient : \'"+resultat+"\'");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            buffer.replaceText("a",-2, 10); // Indices invalides
        }, "IndexOutOfBoundsException should have been thrown");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            buffer.replaceText("a",0, 200); // Indices invalides
        }, "IndexOutOfBoundsException should have been thrown");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            buffer.replaceText("a",10, -2); // Indices invalides
        }, "IndexOutOfBoundsException should have been thrown");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            buffer.replaceText("a",200, 0); // Indices invalides
        }, "IndexOutOfBoundsException should have been thrown");
    }
}
