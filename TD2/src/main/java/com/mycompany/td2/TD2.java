/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.td2;
import javax.swing.JFrame;

/**
 *
 * @author sia
 */
public class TD2 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        JFrame f1 = new JFrame("Ma Fenetre");
        
        f1.setSize(400,300);   // largeur, hauteur en pixels
        f1.setLocation(500, 300); // location en ecran
        //fenetre.setBounds(500,300,400,300); // équivalent à setLocation + setSize ensemble
        
        while(true){
            
            f1.setVisible(true);   // affiche la fenêtre
            try{
                Thread.sleep(1000);  // pause de 1000 millisecondes = 1 seconde
            } catch (Exception e) {}
            
            f1.setVisible(false);   // affiche la fenêtre
            try{
                Thread.sleep(1000);  // pause de 1000 millisecondes = 1 seconde
                f1.setTitle("MA FENETRE");
            } catch (Exception e) {}
            
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ferme le programme quand on clique X

        }
    }
}
