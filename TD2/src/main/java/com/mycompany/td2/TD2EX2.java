/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.td2;
import javax.swing.JFrame; 
/**
 *
 * @author sia
 */
public class TD2EX2 {
        public static void main(String[] args) {
        Fenetre f1 = new Fenetre();
        
        }
}


class Fenetre extends JFrame implements MouseListener {
    public Fenetre(){
        setTitle("MA 2eme FENETRE");
        setBounds(500,300,400,300);
        setVisible(true);
        addMouseListener(new Ecouteur(this)); // ex3 component
    }
}
