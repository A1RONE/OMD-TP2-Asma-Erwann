package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Classe representant l'editeur de texte, classe en directe interaction avec les commandes du joueur.
 * Cette classe centralise le projet et possède et a un acces directe vers les autres objet composant l'editeur.
 */
public class Editeur {

    private Buffer m_buffer;
    private Selection m_selection;
    private PressePapier m_pressepapier;
    private Stack<ICommand> m_commands;
    private Stack<ICommand> m_redo;
    private ArrayList<ICommand> m_macro;
    private ArrayList<String> m_command_list = new ArrayList<>(Arrays.asList(
        "WRITE", "SELECT", "DELETE", "COPY", "CUT", "PASTE"
    ));
    private Scanner scanner = new Scanner(System.in);
    /**
     * Constructeur de l'editeur,
     * Crée ses propres objets :
     *  - Buffer
     *  - Selection
     *  - PressePapier
     */
    public Editeur(){
        m_buffer = new Buffer();
        m_selection = new Selection();
        m_pressepapier = new PressePapier();
        m_commands = new Stack<ICommand>();
        m_redo = new Stack<ICommand>();
        m_macro = new ArrayList<ICommand>();
    }
    /**
     * Getter du buffer lié à l'editeur.
     * @return Buffer Le buffer lié à l'editeur.
     */
    public Buffer getBuffer() {
        return m_buffer;
    }
    /**
     * Getter de la zone de selection lié à l'editeur.
     * @return Selection La zone de selection lié à l'editeur.
     */
    public Selection getSelection() {
        return m_selection;
    }
    /**
     * Getter du presse papier lié à l'editeur.
     * @return PressePapier La zone de presse papier lié à l'editeur.
     */
    public PressePapier getPressePapier() {
        return m_pressepapier;
    }
    // Buffer
    /**
     * Getter recupère la valeur de l'attribut main_text de Buffer
     * Pas de paramètres renvoie le texte entier.
     * @return String Valeur de l'attribut main_text.
     */
    public String getBufferText()
    {
        return m_buffer.getText();
    }
    /**
     * Getter recupère la valeur de l'attribut main_text de Buffer
     * Avec paramètres renvoie le texte entre les indices begin et end.
     * @param begin int Indice de départ (inclus)
     * @param end int Indice d'arrivée (non inclus)
     * @return String Valeur de l'attribut main_text entre les indices begin et end.
     */
    public String getBufferText(int begin,int end)
    {
        return m_buffer.getSelection(begin, end);
    }
    /**
     * Recupere la longueur de l'attribut main_text de Buffer.
     * @return int Longueur de l'attribut main text de Buffer.
     */
    public int getBufferTextLenght()
    {
        return m_buffer.getTextLength();
    }
    /**
     * Efface le texte à l'interieur du buffer.
     */
    public void deleteBufferText()
    {
        m_buffer.deleteText();
    }
    /**
     * Efface le texte à l'interieur du buffer dand l'intervalle [begin; end[
     * @param begin int Index de départ du buffer.(inclus).
     * @param end int Index d'arrivée du buffer (non inclus).
     */
    public void deleteBufferText(int begin, int end)
    {
        m_buffer.deleteSelection(begin, end);
    }
    /**
     * Ecrit dans le texte du buffer.
     * Sans paramètres d'Indice ecrit à la fin du texte.
     * @param new_text String Texte à ajouter.
     */
    public void writeBufferText(String new_text)
    { 
        m_buffer.addText(new_text);
    }
    /**
     * Ecrit dans le texte du buffer.
     * Avec paramètres d'Indices remplace le texte entre les indices begin et end.
     * @param new_text String Texte à ajouter.
     * @param begin int Indice de début de la zone à remplacée (inclus).
     * @param end int Indice de fin de la zone à remplacée (non inclus).
     */
    public void writeBufferText(String new_text, int begin, int end)
    {
        m_buffer.replaceText(new_text, begin, end);
    }

    //Selection
    /**
     * Recupère l'index du pointeur begin (inclus dans la sélection)
     * @return int L'index du pointeur begin.
     */
    public int getSelectionBeginIndex()
    {
        return m_selection.getBeginIndex();
    }
    /**
     * Recupère l'index du pointeur end (non inclus dans la sélection)
     * @return int L'index du pointeur end.
     */
    public int getSelectionEndIndex()
    {
        return m_selection.getEndIndex();
    }
    /**
     * Modifie l'index de départ de la sélection (inclus)
     * @param index int Index de départ de la sélection.
     */
    public void setSelectionBeginIndex(int index)
    {
        m_selection.setBeginIndex(index);
    }
    /**
     * Modifie l'index de fin de la sélection (non inclus)
     * @param index int Index de fin de la sélection.
     */
    public void setSelectionEndIndex(int index)
    {
        m_selection.setEndIndex(index);
    }
    /**
     * Prend deux indices en paramètres et renvoie true si la selection est inclue dans le texte.
     * @param begin int Indice de début de la selection (inclus).
     * @param end int Indice de fin de la selection (non inclus).
     * @return boolean La selection est inclue dans le texte.
     */
    public boolean selectionIsInText(int begin, int end)
    {
        return ( (begin >= 0) && (begin <= getBufferTextLenght()  ) && (end >= 0) && (end <= getBufferTextLenght()) );
    }
    //Presse papier
    /**
     * Recupere le texte du presse papier
     * @return String Texte du presse papier.
     */
    public String getPressePapierText()
    {
        return m_pressepapier.getText();
    }
    /**
     * Remplace le texte du presse papier
     * @param text String Nouveu texte.
     */
    public void setPressePapierText(String text)
    {
        m_pressepapier.setText(text);
    }
    /*
     * Supprime le texte du presse papier.
     */
    public void deletePressePapiertext()
    {
        m_pressepapier.deleteText();
    }
    //ICommands
    /**
     * Plays an inputed command and add it to the stack.
     * If the command doesn't exist an exception is thrown.
     * @param action String Name of the command. 
     */
    public void addCommand(String action)
    {
        ICommand com;
        switch (action) {
            case "Paste":
                com = new Paste(this);
                break;
            case "Copy":
                com = new Copy(this);
                break;
            case "Cut":
                com = new Cut(this);
                break;
            case "Write":
                com = new Write(this);
                break;
            case "Select":
                com = new Select(this);
                break;
            case "Delete":
                com = new Delete(this);
                break;
            case "Macro":
                ArrayList<ICommand> new_macro = new ArrayList<>();
                for (int i=0; i<m_macro.size(); i++)
                {
                    if (m_macro.get(i) instanceof Paste) {
                        new_macro.add(new Paste((Paste)m_macro.get(i)));
                    } else if (m_macro.get(i) instanceof Copy) {
                        new_macro.add(new Copy((Copy)m_macro.get(i)));
                    } else if (m_macro.get(i) instanceof Cut) {
                        new_macro.add(new Cut((Cut)m_macro.get(i)));
                    } else if (m_macro.get(i) instanceof Write) {
                        new_macro.add(new Write((Write)m_macro.get(i)));
                    } else if (m_macro.get(i) instanceof Select) {
                        new_macro.add(new Select((Select)m_macro.get(i)));
                    } else if (m_macro.get(i) instanceof Delete) {
                        new_macro.add(new Delete((Delete)m_macro.get(i)));
                    }
                }
                com = new Macro(this, new_macro);
                break;
            
            default:
                throw new IllegalArgumentException(action+" n'est pas une action valide.");

        }
        
        if (com != null){
            m_redo.clear();
            com.execute();
            m_commands.push(com);
        }

    }
    public void undoCommand()
    {
        if (m_commands.empty())
        {
            return;
        }

        ICommand com = m_commands.pop();
        m_redo.push(com);
        if ( com instanceof Copy )
        {
            while (com instanceof Copy) { 
                if (m_commands.empty())
                {
                    return;
                }
                com = m_commands.pop();
                m_redo.push(com);
            }
        }
        com.undo();
    }

    public void redoCommand()
    {
        if (m_redo.empty())
        {
            return;
        }

        ICommand com = m_redo.pop();
        m_commands.push(com);
        if ( com instanceof Copy )
        {
            while (com instanceof Copy) { 
                if (m_redo.empty())
                {
                    return;
                }
                com = m_redo.pop();
                m_commands.push(com);
            }
        }
        com.redo();        
    }
    public void clearMacro()
    {
        m_macro.clear();
    }

    public void addMacro(String action)
    {
        ICommand com;
        if (!m_command_list.contains(action))
        {return;}
        switch (action) {
            case "PASTE":
                com = new Paste(this);
                break;
            case "COPY":
                com = new Copy(this);
                break;
            case "CUT":
                com = new Cut(this);
                break;
            case "WRITE":
                com = new Write(this);
                System.out.println("Entrer le nouveau texte :");
                String text = scanner.nextLine();
                ((Write) com).setNewText(text);
                break;
            case "SELECT":
                com = new Select(this);
                int begin_id;
                int end_id;
                while (true) { 
                    System.out.println("Enter a valid begin index :");
                    begin_id = scanner.nextInt();
                    if (begin_id >= 0)
                    {
                        break;
                    }
                }

                while (true) { 
                    System.out.println("Enter a valid end index :");
                    end_id = scanner.nextInt();
                    if (end_id >= 0)
                    {
                        break;
                    }
                }

                ((Select) com).setBeginIndex(begin_id);
                ((Select) com).setEndIndex(end_id);
                break;

            case "DELETE":
                com = new Delete(this);
                break;
            
            default:
                throw new IllegalArgumentException(action+" n'est pas une action valide.");

        }
        
        if (com != null){
            m_macro.add(com);
        }
    }

    public void playCommand(String command)
    {
        switch(command)
        {
            case "WRITE":
                addCommand("Write");
                break;
            case "SELECT":
                addCommand("Select");
                break;
            case "DELETE":
                addCommand("Delete");
                break;
            case "COPY":
                addCommand("Copy");
                break;
            case "CUT":
                addCommand("Cut");
                break;
            case "PASTE":
                addCommand("Paste");
                break;
            case "PLAY MACRO":
                addCommand("Macro");
                break;
            case "UNDO":
                undoCommand();
                break;
            case "REDO":
                redoCommand();
                break;
        }
    }
    
}
