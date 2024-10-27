package com.example;
/**
 * Interface définissant une action quelquonque executée suite à une requette de l'utilisateur sur l'editeur.
 * Cette interface suis le fonctionnement du patron de conception Command.
 */
public interface ICommand {
    /**
     * Methode permettant l'execution de la commande.
     */
    public void execute();
    /**
     * Methode permettant de retirer la commande.
     */
    public void undo();
    /**
     * Methode permettant de reexecuter la commande.
     */
    public void redo();
    
}
