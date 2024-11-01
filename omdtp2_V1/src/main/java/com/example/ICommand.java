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
    
}
