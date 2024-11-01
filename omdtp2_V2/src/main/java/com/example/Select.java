package com.example;

import java.util.Scanner;

public class Select extends ACommand {

    int begin_id;
    int end_id;
    int old_begin_id;
    int old_end_id;
    Scanner scanner = new Scanner(System.in);

    public Select (Editeur editeur){
        super(editeur);
        begin_id = -1;
        end_id = -1;
    }

    public Select (Select select)
    {
        super(select.getEditeur());
        begin_id = select.getBegin_id();
        end_id = select.getEnd_id();
    }

    public Editeur getEditeur()
    {
        return m_editeur;
    }

    public int getBegin_id() {
        return begin_id;
    }

    public int getEnd_id() {
        return end_id;
    }
    
    
    @Override
    public void execute() {

        old_begin_id = m_editeur.getSelectionBeginIndex();
        old_end_id = m_editeur.getSelectionEndIndex();

        if (begin_id == -1)
        {
            while (true) { 
                System.out.println("Enter a valid begin index :");
                begin_id = scanner.nextInt();
                if (begin_id >= 0)
                {
                    break;
                }
            }
        }

        if (end_id == -1)
        {
            while (true) { 
                System.out.println("Enter a valid end index :");
                end_id = scanner.nextInt();
                if (end_id >= 0)
                {
                    break;
                }
            }
        }
        if (!m_editeur.selectionIsInText(begin_id, end_id))
        {
            throw new IndexOutOfBoundsException("Indices out of bounds");
        }

        m_editeur.setSelectionBeginIndex(begin_id);
        m_editeur.setSelectionEndIndex(end_id);
    }
    @Override
    public void undo()
    {
        m_editeur.setSelectionBeginIndex(old_begin_id);
        m_editeur.setSelectionEndIndex(old_end_id);
    }
    @Override
    public void redo()
    {
        m_editeur.setSelectionBeginIndex(begin_id);
        m_editeur.setSelectionEndIndex(end_id);        
    }

    public void setBeginIndex(int begin_id) {
        this.begin_id = begin_id;
    }

    public void setEndIndex(int end_id) {
        this.end_id = end_id;
    }

}
