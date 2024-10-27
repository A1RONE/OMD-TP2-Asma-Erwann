package com.example;
/**
 * Classe abstraite implementant l'interface commande.
 * Correspond à une action quelquonque executée suite à une requette de l'utilisateur sur l'editeur.
 */
public abstract class ACommand implements ICommand {
    /**
     * Editeur L'editeur sur lequel la commande est executée. 
     */
    protected Editeur m_editeur;
    /**
     * Constructeur de la classe ACommand qui permet de Construire un objet ACommand
     * @param editeur l'editeur sur lequel est executée la commande.
     */
    public ACommand(Editeur editeur){
        m_editeur = editeur;
    }
    /**
     * La methode d'execution de la commande.
     */
    @Override
    public abstract void execute();
    /**
     * Methode permettant de retirer la commande.
     */
    @Override
    public abstract void undo();
}
