package com.example;

import java.util.ArrayList;

public class Macro extends ACommand {

    private ArrayList<ICommand> m_macro;

    public Macro(Editeur editeur, ArrayList<ICommand> macro){
        super(editeur);
        m_macro = macro;
    }

    @Override
    public void execute()
    {
        for(int i=0; i<m_macro.size(); i++){
            m_macro.get(i).execute();
        }
    };
    @Override
    public void undo()
    {
        for(int i=m_macro.size()-1; i>=0; i--){
            m_macro.get(i).undo();
        }
    };
    @Override
    public void redo()
    {
        for(int i=0; i<m_macro.size(); i++){
            m_macro.get(i).redo();
        }
    };
}
