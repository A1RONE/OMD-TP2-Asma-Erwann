package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Editeur editeur = new Editeur();
        Scanner scanner = new Scanner(System.in);
        String ans;
        while (true) {
            System.out.println("Choisissez l'action :");
            System.out.println("WRITE");
            System.out.println("SELECT");
            System.out.println("DELETE");
            System.out.println("COPY");
            System.out.println("CUT");
            System.out.println("PASTE");
            System.out.println("UNDO");
            System.out.println("REDO");
            System.out.println("END");

            ans = scanner.nextLine();
            switch(ans)
            {
                case "WRITE":
                    editeur.addCommand("Write");
                    break;
                case "SELECT":
                    editeur.addCommand("Select");
                    break;
                case "DELETE":
                    editeur.addCommand("Delete");
                    break;
                case "COPY":
                    editeur.addCommand("Copy");
                    break;
                case "CUT":
                    editeur.addCommand("Cut");
                    break;
                case "PASTE":
                    editeur.addCommand("Paste");
                    break;
                case "UNDO":
                    editeur.undoCommand();
                    break;
                case "REDO":
                    editeur.redoCommand();
                    break;
                case "END":
                    return;
            }
            System.out.println("-------------------");
            System.out.println(editeur.getBufferText());
            System.out.println("-------------------");
        }
    }
}