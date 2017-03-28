/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

import java.util.Scanner;

public class Morpion {

    /**
     * @param args the command line arguments autor jeremymure
     */
    public static void main(String[] args) {

//Initialisation
        String grille[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};                       //Création d'un tableau

        String J1 = "X";                                                                       //Création du joueur 1
        String J2 = "O";                                                                       //Création du joueur 2
        String currentUser = J1;                                                               //Premier joueur (joueur 1)

        int win = 1;                                                                           //Création de la variable win

        System.out.println("Tapez un chiffre entre 1 et 9 pour placer votre symbole : ");

//Début du programme
        while (win != 0) {                                                                    //Tant que win different de 0 la boucle continue

            int x = 42;                                                                            //Création de la variable x

//Contrôle les entrés du joueur
            while (x != 12) {                                                                 //Tant que x different de 12 la boucle continue
                AfficherGrille(grille);                                                       //Affiche la grille

                Scanner enter = new Scanner(System.in);
                int entre = enter.nextInt();                         //Création d'une variable enter dont la valeur est affecter par l'utilisateur 

                int i = entre - 1;                   //création d'une variable i pour synchroniser les numéros de grille et l'entrée de l'utilisateur

                if (entre == 0 || entre >= 10) {                                                //Si nombre non compris dans la grille erreurs
                    System.out.println("Emplacement " + (i + 1) + " incorrecte! Recommence.");  //Affiche cette phrase et la boucle recommence

                } else if (!grille[i].equals(J2) && !grille[i].equals(J1)) {           //Si emplacement i de la grille different de J1 et J2
                    grille[i] = currentUser;                                           //Emplacement de la grille prend la valeur du joueur actuel
                    x = 12;                                                            //Met fin à la boucle en affectant à x la valeur 12
                } else {                                                               //Sinon emplacement déjà pris 
                    System.out.println("Emplacement " + (i + 1) + " déjà pris! Recommence.");

                }

            }
//Condition de victoire
            if ((currentUser.equals(grille[0]) && currentUser.equals(grille[1]) && currentUser.equals(grille[2]))         //Si le joueur actuel a trois
                    || (currentUser.equals(grille[3]) && currentUser.equals(grille[4]) && currentUser.equals(grille[5]))  //case en ligne, en colonne et en
                    || (currentUser.equals(grille[6]) && currentUser.equals(grille[7]) && currentUser.equals(grille[8]))  //diagonal alors...  
                    || (currentUser.equals(grille[0]) && currentUser.equals(grille[3]) && currentUser.equals(grille[6]))
                    || (currentUser.equals(grille[1]) && currentUser.equals(grille[4]) && currentUser.equals(grille[7]))
                    || (currentUser.equals(grille[2]) && currentUser.equals(grille[5]) && currentUser.equals(grille[8]))
                    || (currentUser.equals(grille[0]) && currentUser.equals(grille[4]) && currentUser.equals(grille[8]))
                    || (currentUser.equals(grille[2]) && currentUser.equals(grille[4]) && currentUser.equals(grille[6]))) {
                win = 0;                                                                                                  //Fin de la boucle win

//Changement de joueur
            } else if (currentUser.equals(J1)) {                //Si le joueur actuel est le joueur 1
                System.out.println("");
                System.out.println("Au tour du joueur 2 :");    //Phrase introduisant le joueur 2
                currentUser = J2;                               //Joueur actuel est le joueur 2

            } else {
                System.out.println("");
                System.out.println("Au tour du joueur 1 :");
                currentUser = J1;
            }
        }
//Fin de programme
        AfficherGrille(grille);                                                     //Affiche la grille final
        if (currentUser.equals(J1)) {
            System.out.println("Joueur 1" + "(" + currentUser + ")" + " Win !!!");
        } else {                                                                    //Phrase de victoir pour les deux joueurs
            System.out.println("Joueur 2" + "(" + currentUser + ")" + " Win !!!");

        }

    }

    static void AfficherGrille(String grille[]) {
        //Création de la grille
        System.out.println("[ " + grille[6] + " | " + grille[7] + " | " + grille[8] + " ]");
        System.out.println("[ " + grille[3] + " | " + grille[4] + " | " + grille[5] + " ]");
        System.out.println("[ " + grille[0] + " | " + grille[1] + " | " + grille[2] + " ]");

    }
}
