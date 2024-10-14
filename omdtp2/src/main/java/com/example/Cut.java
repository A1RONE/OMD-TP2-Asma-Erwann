package com.example;

public class Cut extends ACommand {

    String new_text;
    int begin_id;
    int end_id;

    public Cut(Editeur editeur){
        super(editeur);
        new_text = "";
    }
    
    @Override
    public void execute() {
        // Recupère les index de la sélection
        begin_id = m_editeur.getSelectionBeginIndex();
        end_id = m_editeur.getSelectionEndIndex();
        // Recupère et stock le texte qui va être mis dans le presse papier
        // (garde une trace de l'execution)
        new_text = m_editeur.getBufferText(begin_id, end_id);
        // Remplace le texte
        m_editeur.deleteBufferText(begin_id, end_id);
        m_editeur.setPressePapierText(new_text);
    }

    public String getOldData()
    {
        return new_text;
    }
    
}
