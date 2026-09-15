/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.td1;

/**
 *
 * @author sia
 */
public class TD1 {

    public static void main(String[] args) {
        String s1 = null;
        System.out.println("Hello World!!!!!!");
        chaine c1 = new chaine(s1);
        chaine c2 = new chaine("Helloooo");
        chaine c3 = new chaine(c2);
        c3.affichage();
        
        chaine c4 = new chaine("byeee");
        c4.setChaine(c4.getlg(), " les amis");
        c4.affichage(); 
    }
}





// private static final int _LMax = 10000; 10