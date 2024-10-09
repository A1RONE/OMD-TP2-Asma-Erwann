package com.example;
/**
 * Classe representant la selection d'une zone de texte.
 * Cette selection est représentée par un indice de départ (inclus) et un indice de fin (non inclus dans la selection).
 * Cette classe ne peux pas toute seule verifier que l'indice entré est valide.
 */
public class Selection {
    /**
     * int L'indice de départ de la selection (inclus).
     */
    private int begin_id = 0;
    /**
     * int L'indice de fin de la selection (non inclus).
     */
    private int end_id = 0;
    /**
     * Getter de l'indice de départ.
     * @return int l'indice de départ (inclus dans la selection)
     */
    public int getBeginIndex()
    {
        return begin_id;
    }
    /**
     * Getter de l'indice de fin.
     * @return int l'indice de fin (non inclus dans la séléction)
     */
    public int getEndIndex()
    {
        return end_id;
    }
    /**
     * Setter de l'indice de départ.
     * @param new_index int nouvelle indice de départ <= 0 (inclus dans la selection)
     */
    public void setBeginIndex(int new_index)
    {
        if (new_index < 0)
        {
            throw new IllegalArgumentException("Index must be a positive number.");
        }
        begin_id = new_index;
    }
    /**
     * Setter de l'indice de fin.
     * @param new_index int nouvelle indice de fin <= 0 (non inclus dans la selection)
     */
    public void setEndIndex(int new_index)
    {
        if (new_index < 0)
        {
            throw new IllegalArgumentException("Index must be a positive number.");
        }
        end_id = new_index;
    }
}
