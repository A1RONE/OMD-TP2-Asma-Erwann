package com.example;
/**
 * Classe representant l'editeur de texte, classe en directe interaction avec les commandes du joueur.
 * Cette classe centralise le projet et possède et a un acces directe vers les autres objet composant l'editeur.
 */
public class Editeur {

    private Buffer m_buffer;
    private Selection m_selection;
    private PressePapier m_pressepapier;
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
     * Prend deux indices en paramètres et renvoie true si la selection est inclue dans le texte.
     * @param begin int Indice de début de la selection (inclus).
     * @param end int Indice de fin de la selection (non inclus).
     * @return boolean La selection est inclue dans le texte.
     */
    public boolean selectionIsInText(int begin, int end)
    {
        return ( (begin >= 0) && (begin <= getBufferTextLenght()  ) && (end >= 0) && (end <= getBufferTextLenght()) );
    }

    
}
