package com.example;

/**
 * Classe permettant de sauvegarder le texte séléctionné et copié à garder en mémoire
 */
public class PressePapier {

    /**
     * Le texte à sauvegarder
     */
    private String m_texte;

    /**
     * Constructeur du presse papier avec un texte en entrée
     * @param texte String Le texte à sauvegarder
     */
    public PressePapier(String texte){
        m_texte = texte;
    }

    /**
     * Constructeur du presse papier sans paramètre
     * Le paramètre du texte à sauvegarder est vide
     */
    public PressePapier(){
        m_texte = "";
    }

    /**
     * Ajouter un nouveau texte dans le presse papier 
     * @param texte String Le texte à ajouter
     */
    public void setText(String texte) {
        m_texte = texte;
    }

    /**
     * Getter retournant le texte présent dans le presse papier
     * @return String Le texte à retourner
     */
    public String getText(){
        return m_texte;
    }

    /**
     * Permet de supprimer le contenu du presse papier
     */
    public void deleteText(){
        m_texte = "";
    }
}