package com.example;

import java.util.Scanner;

public class Write extends ACommand {

    String old_text;
    String new_text;
    int begin_id;
    int end_id;
    Scanner scanner = new Scanner(System.in);
    Select select;

    public Write (Editeur editeur){
        super(editeur);
        new_text = "";
        old_text = "";
    }
    
    @Override
    public void execute() {
        // Recupère les index de la sélection
        begin_id = m_editeur.getSelectionBeginIndex();
        end_id = m_editeur.getSelectionEndIndex();   
        // (garde une trace de l'execution)
        old_text = m_editeur.getBufferText(begin_id, end_id);
        // Remplace le texte
        if (new_text.equals(""))
        {
            System.out.println("Entrer le nouveau texte :");
            new_text = scanner.nextLine();
        }
        m_editeur.writeBufferText(new_text, begin_id, end_id);
        select = new Select(m_editeur);
        select.setBeginIndex(begin_id + new_text.length());
        select.setEndIndex(begin_id + new_text.length());
        select.execute();
    }
    @Override
    public void undo()
    {
        m_editeur.writeBufferText(old_text, begin_id, begin_id + new_text.length());
        select.undo();
    }
    @Override
    public void redo()
    {
        m_editeur.writeBufferText(new_text, begin_id, end_id);
        select.redo();
    }


    public String getOldData()
    {
        return old_text;
    }

    public void setNewText(String text)
    {
        new_text = text;
    }

}
