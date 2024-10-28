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
            System.out.println("RECORD MACRO");
            System.out.println("PLAY MACRO");
            System.out.println("END");

            ans = scanner.nextLine();
            if (ans.equals("END"))
            {
                return;
            }
            else if (ans.equals("RECORD MACRO"))
            {
                editeur.clearMacro();
                while(true)
                {
                    System.out.println("Choisissez l'action :");
                    System.out.println("WRITE");
                    System.out.println("SELECT");
                    System.out.println("DELETE");
                    System.out.println("COPY");
                    System.out.println("CUT");
                    System.out.println("PASTE");
                    System.out.println("STOP RECORDING");

                    ans = scanner.nextLine();
                    if (ans.equals("STOP RECORDING"))
                    {
                        break;
                    }
                    else
                    {
                        editeur.addMacro(ans);
                    }

                }
            }
            else
            {
                editeur.playCommand(ans);
            }
            System.out.println("-------------------");
            System.out.println(editeur.getBufferText());
            System.out.println("-------------------");
        }
    }
}