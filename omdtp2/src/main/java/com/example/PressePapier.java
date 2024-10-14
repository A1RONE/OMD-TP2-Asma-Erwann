package com.example;

public class PressePapier {

    private String m_texte;

    public PressePapier(String texte){
        m_texte = texte;
    }

    public PressePapier(){
        m_texte = "";
    }

    public void setText(String texte) {
        m_texte = texte;
    }

    public String getText(){
        return m_texte;
    }

    public void deleteText(){
        m_texte = "";
    }
}