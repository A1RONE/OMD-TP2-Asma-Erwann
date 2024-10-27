package com.example;
/**
 * Classe en extension de ACommand.
 * Elle represente la commande de l'action copier.
 * On recupère la valeur du buffer séléctionnée et on la met dans le presse papier.
 */
public class Copy extends ACommand {

    public Copy(Editeur editeur){
        super(editeur);
    }

    @Override
    public void execute() {
        // Editeur editeur = new Editeur();
        int begin = m_editeur.getSelectionBeginIndex();
        int end = m_editeur.getSelectionEndIndex();
        String selected = m_editeur.getBufferText(begin, end);
        m_editeur.setPressePapierText(selected);
        // throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void undo(){}
    @Override
    public void redo(){}
    
}
