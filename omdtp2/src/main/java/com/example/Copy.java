package com.example;
/**
 * Classe en extension de ACommand.
 * Elle represente la commande de l'action copier.
 * On recupère la valeur du buffer séléctionnée et on la met dans le presse papier.
 */
public class Copy extends ACommand {

    public Copy(Editeur editeur){
        super(editeur);
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
