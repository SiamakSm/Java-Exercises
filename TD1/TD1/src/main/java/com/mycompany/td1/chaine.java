package com.mycompany.td1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sia
 */
public class chaine {
    // caractéristiques = attributs

    private char[] _t ;
    private int _lg ;
    private final static int _LMax = 10000;
    
    // constructeur vide
    public chaine(){
        this._t = new char[_LMax]; // this here is not mandatory
        this._lg = 0;
    }
    
    
    // constructeur depuis un String
    public chaine(String s){
        this();
        if(s != null){
            _lg = Math.min(s.length(), _LMax);
            for (int i=0 ; i<_lg ; i++){
                _t[i] = s.charAt(i);
            }
        }
    }
    
    
    // constructeur depuis un autre chaine
    public chaine (chaine c){
        this();
        if (c != null){
            _lg = c.getlg();
            for (int i=0 ; i<_lg ; i++){
                _t[i] = c.getcar(i);
            }
        }
    }
    
    // getter
    public int getlg(){
        return _lg;
    }
    
    // getter
    public char getcar(int pos){
        if (pos >= 0 && pos < _lg)
            return _t[pos];
        return 0;
    }
    
    
    public String toString(){
        return new String(_t, 0, _lg);
    }
    
    
    public void affichage(){
        System.out.println(this);
    }
    
    
    // setter
    public void setCar(int pos, char c){
        if(pos >= 0 && pos < _LMax){
            _t[pos] = c;
            if(pos >= _lg) _lg = pos + 1;
        }
    }
    
    
    // setter
    public void setChaine(int pos, String s){
        if(pos >= 0 && pos < _LMax){
            int l = Math.min(s.length(), _LMax - pos);
            for(int i=0 ; i<l ; i++){
                _t[pos + i] = s.charAt(i);
            }
            _lg = Math.max(_lg, pos + l);
        }
    }
    
    public void setChaine(int pos, chaine c){
        if(pos >= 0 && pos < _LMax){
            int l = Math.min(c.getlg(), _LMax - pos);
            for(int i=0 ; i<l ; i++){
                _t[pos + i] = c.getcar(i);
            }
            _lg = Math.max(_lg, pos + l);
        }
    }
    
    
    public void concat(String s){
        setChaine(_lg , s);
    }
    
    public void concat(chaine c){
        setChaine(_lg , c);
    }
    
    
    public chaine getChaine(int pos, int lg){
        chaine c = new chaine();
        if (pos >= 0 && pos < _lg){
            int l = Math.max(lg, _LMax - pos);
            for (int i=0 ; i<l ; i++){
                c.setCar(i , _t[pos + i]);
            }
        }
        return c;
    }
    
    
    public String getString(int pos, int lg){
        if (pos >= 0 && pos < _LMax){
            int l = Math.min(lg, _LMax - pos);
            return new String(_t, pos , l);
        }
        return "" ;
    }
    
    
    // test d'égalité
    public boolean egale(String s){
        if (s.length() != _lg) return false;
        for(int i = 0 ; i < _lg ; i++){
            if(_t[i] != s.charAt(i)) return false;
        }
        
        return true ;
    }
    
    
    // test d'égalité
    public boolean egale(chaine c){
        if (c.getlg() != _lg) return false;
        for(int i = 0 ; i < _lg ; i++){
            if(_t[i] != c.getcar(i)) return false;
        }
        return true ;
    }
    
    
    // recherche de motif
    public int recherche (String motif){
        int l = motif.length();
        for (int depart = 0 ; depart < _lg - l ; depart ++){
            int i = 0;
            while (_t[depart +i] == motif.charAt(i)) i++;
            if(i == l) return depart;
        }
        return -1;
    }
    
}
