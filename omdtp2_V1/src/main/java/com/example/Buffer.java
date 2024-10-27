package com.example;
/**
 * Classe stockant le texte contenue dans l'editeur.
 * Le texte peut être lu en entier ou en partie et être editer et supprimer.
 */
public class Buffer {
    
    /**
     * Le texte editer par l'utilisateur.
     */
    private String main_text = "";

    /**
     * Ajouter tu nouveau text au sein de la string
     * @param new_text String le texte à ajouter.
     */
    public void addText(String new_text){
        main_text += new_text;
    }
    
    /**
     * Getter retournant le texte entier de l'editeur;
     * @return String Texte complet de l'editeur.
     */
    public String getText()
    {
        return main_text;
    }
    /**
     * Getter retournant la longeur de Text.
     * @return int Longeuer de Text.
     */
    public int getTextLength()
    {
        return main_text.length();
    }
    /**
     * Supprime l'entiéreté du texte.
     */
    public void deleteText()
    {
        main_text = "";
    }
    /**
     * Getter retournant la part de texte comprise entre begin et end;
     * L'ordre de begin et end n'a pas d'importance.
     * @param begin int indice de départ de la sélection;
     * @param end int indice de fin de la sélection.
     * @return String Texte selectionner.
     */
    public String getSelection(int begin, int end)
    {
        if (begin < 0 || end < 0 || begin > main_text.length() || end > main_text.length()) {
            throw new IndexOutOfBoundsException("Indices out of bounds");
        }

        if (begin < end){
            // substring récupère la chaine de caratères comprise entre les indices begin et end de la string.
            return main_text.substring(begin, end); 
        }
        else
        {
            return main_text.substring(end, begin);
        }
    }
    /**
     * Supprime la part du texte comprise entre begin et end et renvoie le nouveau texte
     * L'ordre de begin et end n'a pas d'importance.
     * @param begin int indice de départ de la sélection
     * @param end int indice de fin de la sélection.
     */
    public void deleteSelection(int begin, int end)
    {
        if (begin < 0 || end < 0 || begin > main_text.length() || end > main_text.length()) {
            throw new IndexOutOfBoundsException("Indices out of bounds");
        }

        int b_index = Math.min(begin, end);
        int e_index = Math.max(begin, end);

        main_text = main_text.substring(0, b_index) + main_text.substring(e_index, main_text.length());
    }
    /**
     * Supprime le text entre begin et end et le remplace par new_text.
     * L'ordre de begin et end n'a pas d'importance.
     * @param new_text String Text à ajouter
     * @param begin int index de départ 
     * @param end int index de fin (non inclus)
     */
    public void replaceText(String new_text, int begin, int end)
    {
        if (begin < 0 || end < 0 || begin > main_text.length() || end > main_text.length()) {
            throw new IndexOutOfBoundsException("Indices out of bounds");
        }

        int b_index = Math.min(begin, end);
        int e_index = Math.max(begin, end);

        main_text = main_text.substring(0, b_index) + new_text + main_text.substring(e_index, main_text.length());     
    }

}
