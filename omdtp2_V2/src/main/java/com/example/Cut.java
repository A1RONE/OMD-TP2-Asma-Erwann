package com.example;

public class Cut extends ACommand {

    String new_text;
    int begin_id;
    int end_id;
    Delete delete;

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
        // Remplace le texte
        Copy copy = new Copy(m_editeur);
        copy.execute();
        if (begin_id != end_id){
            delete = new Delete(m_editeur);
            delete.execute();
            new_text = delete.getOldData();
        }
    }
    @Override
    public void undo()
    {
        delete.undo();
    }
    @Override
    public void redo()
    {
        delete.redo();
    }

    public String getOldData()
    {
        return new_text;
    }
    
}
