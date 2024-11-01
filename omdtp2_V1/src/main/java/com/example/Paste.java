package com.example;

public class Paste extends ACommand {

    String old_text;
    int begin_id;
    int end_id;

    public Paste (Editeur editeur){
        super(editeur);
        old_text = "";
    }
    
    @Override
    public void execute() {
        // Recupère les index de la sélection
        begin_id = m_editeur.getSelectionBeginIndex();
        end_id = m_editeur.getSelectionEndIndex();
        // Recupère le texte à remplacer
        String new_text = m_editeur.getPressePapierText();
        // Recupère et stock le text qui va être remplacer
        // (garde une trace de l'execution)
        old_text = m_editeur.getBufferText(begin_id, end_id);
        // Remplace le texte
        m_editeur.writeBufferText(new_text, begin_id, end_id);
        Select select = new Select(m_editeur);
        select.setBeginIndex(begin_id + new_text.length());
        select.setEndIndex(begin_id + new_text.length());
        select.execute();
    }

    public String getOldData()
    {
        return old_text;
    }

}