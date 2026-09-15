package com.mycompany.td3;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;     //   ajouté
import java.awt.Graphics;       //   ajouté
import java.awt.Color;          //   ajouté
import java.awt.event.MouseListener;  //   ajouté
import java.awt.event.MouseEvent;     //   ajouté

public class TD3 {
    public static void main(String[] args) {
        Fenetre f1 = new Fenetre();
    }
}

class Fenetre extends JFrame {
    public Fenetre(){
        setTitle("MA FENETRE");
        setBounds(500,300,400,300); 
        setContentPane(new PanneauDessin());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //   ajouté
        setVisible(true); 
    }
}
        
class PanneauDessin extends JPanel {
    private ArrayList<Integer> aX;
    private ArrayList<Integer> aY;
    
    public PanneauDessin(){
        super();
        aX = new ArrayList<>();               
        aY = new ArrayList<>();               
        setForeground(new Color(0,0,255));   
        setBackground(new Color(255,255,255));  
        addMouseListener(new EcouteurSouris());  
    }
    
    public void ajoutePoint(int x, int y){
        aX.add(x);
        aY.add(y);
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){   
        super.paintComponent(g);              
        for (int i=0; i < aX.size(); i++){
            g.drawOval(aX.get(i)-1, aY.get(i)-1, 3, 3); 
        }
    }
}

class EcouteurSouris implements MouseListener {
    public void mousePressed(MouseEvent e){}    
    public void mouseReleased(MouseEvent e){}   
    public void mouseEntered(MouseEvent e){}    
    public void mouseExited(MouseEvent e){}     

    public void mouseClicked(MouseEvent e){     
        ((PanneauDessin)e.getSource()).ajoutePoint(e.getX(), e.getY());  
    }
}