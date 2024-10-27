package com.example;

public class Delete extends ACommand {

    String deleted_text;
    int begin_id;
    int end_id;

    public Delete(Editeur editeur){
        super(editeur);
        deleted_text = "";
    }

    @Override
    public void execute()
    {
        // Recupère les index de la sélection
        begin_id = m_editeur.getSelectionBeginIndex();
        end_id = m_editeur.getSelectionEndIndex();
        if (begin_id == end_id && begin_id != 0 )
        {
            begin_id -=1;
        }
        // Recupère et stock le texte qui va être supprimer
        // (garde une trace de l'execution)
        deleted_text = m_editeur.getBufferText(begin_id, end_id);
        // Supprime le texte
        m_editeur.deleteBufferText(begin_id, end_id);
        Select select = new Select(m_editeur);
        select.setBeginIndex(begin_id);
        select.setEndIndex(begin_id);
        select.execute();
    }
    @Override
    public void undo()
    {
        m_editeur.writeBufferText(deleted_text, begin_id, begin_id);
        Select select = new Select(m_editeur);
        select.setBeginIndex(begin_id);
        select.setEndIndex(end_id);
        select.execute();
    }

    public String getOldData()
    {
        return deleted_text;
    }

}
