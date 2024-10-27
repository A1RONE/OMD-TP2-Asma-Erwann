package com.example;

import java.util.Scanner;

public class Select extends ACommand {

    int begin_id;
    int end_id;
    Scanner scanner = new Scanner(System.in);

    public Select (Editeur editeur){
        super(editeur);
        begin_id = -1;
        end_id = -1;
    }
    
    @Override
    public void execute() {
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

    public void setBeginIndex(int begin_id) {
        this.begin_id = begin_id;
    }

    public void setEndIndex(int end_id) {
        this.end_id = end_id;
    }

}
