package ex0;

class Chaine {
  
  // Attributs /////////////////////////////////////////////////////////////////
  //
  private char[] _aCh;
  private int _lgCh;
  private static final int _lgMax = 65535;

  // Méthodes //////////////////////////////////////////////////////////////////
  //
  // Constructeur sans paramètre : réservation du tableau en mémoire et création
  // d'une chaîne vide
  //
  public Chaine() {
    _aCh = new char[_lgMax];
    _lgCh = 0;
  }

  // Constructeur à partir d'un objet "String" (surdéfinition)
  //
  public Chaine(String s) {
    this(); // Appel au constructeur sans paramètres pour éviter la duplication de code
    if (s != null) {
        _lgCh = Math.min(s.length(), _lgMax); // Si s dépasse la capacité maximale, on tronque
        for (int i = 0; i < _lgCh; i++) _aCh[i] = s.charAt(i);
    }
  }

  // Accesseur : renvoie la longueur courante de la chaîne
  //
  public int getLg() {
    return _lgCh;
  }

  // Accesseur : renvoie le caractère présent dans la chaîne à la position "pos"
  //
  public char getChar(int pos) {
    if (pos >= 0 && pos < _lgCh) return _aCh[pos];
    else return 0;
  }

  // Constructeur à partir d'un autre objet "Chaine" (surdéfinition)
  //
  public Chaine(Chaine ch) {
    this();
    if (ch != null) {
        _lgCh = ch.getLg();
        for (int i = 0; i < _lgCh; i++) _aCh[i] = ch.getChar(i);
    }
  }

  // Renvoie la chaîne sous forme de "String". Cette méthode retourne un objet 
  // de type "String" en utilisant le constructeur de la classe "String" prenant
  // en argument un tableau de caractères (comme dans getString)
  //
  @Override
  public String toString() {
    return new String(_aCh, 0, _lgCh);
  }

  // Affiche la chaîne dans la console
  //
  public void affiche() {
      //for (int i = 0; i < _lgCh; i++) System.out.print(_aCh[i]);
      //System.out.println();
    System.out.println(this);
  }

  // Modifieur : écrit le caractère "c" à la position "pos" de la chaîne
  //
  public void setCar(char c, int pos) {
    if (pos >= 0 && pos < _lgMax) {
      _aCh[pos] = c;
      if (pos >= _lgCh) _lgCh = pos + 1;
    }
  }

  // Modifieur : écrit la sous-chaîne "ch" (de type "Chaine") à la position
  // "pos" de la chaîne.
  //
  public void setChaine(Chaine ch, int pos) {
    if (pos >= 0 && pos < _lgMax) {
        int lg = ch.getLg();
        if (pos + lg > _lgMax) lg = _lgMax - pos; // Troncature si nécessaire
        for (int i = 0; i < lg; i++) _aCh[pos + i] = ch.getChar(i);
        _lgCh = Math.max(pos + lg, _lgCh);
    }
  }

  // Modifieur : écrit la sous-chaîne "s" (de type "String") à la position
  // "pos" de la chaîne (surdéfinition)
  //
  public void setChaine(String s, int pos) {
    if (pos >= 0 && pos < _lgMax) {
        int lg = s.length();
        if (pos + lg > _lgMax) lg = _lgMax - pos; // Troncature si nécessaire
        for (int i = 0; i < lg; i++) _aCh[pos + i] = s.charAt(i);
        _lgCh = Math.max(pos + lg, _lgCh);
    }
  }

  // Concaténation d'une chaîne de type "Chaine"
  //
  public void concat(Chaine ch) {
    setChaine(ch, _lgCh);
  }

  // Idem précédente avec une chaîne de type "String" (surdéfinition)
  //
  public void concat(String s) {
    setChaine(s, _lgCh);
  }

  // Accesseur : renvoie la sous-chaîne (de type "Chaine") commençant à la
  // position "pos" et de longueur "lg"
  // 
  public Chaine getChaine(int pos, int lg) {
    Chaine c = new Chaine();
    if (pos >= 0 && pos < _lgCh) {
        if (pos + lg > _lgCh) lg = _lgCh - pos; // Réduction de la longueur d'extraction si nécessaire
        for (int i = 0; i < lg; i++) c.setCar(_aCh[i + pos], i);    
    }
    return c;
  }

  // Accesseur : idem précédent mais retourne une sous-chaîne de type "String".
  // N.B.: Ici, on utilise un constructeur de la classe "String" native qui prend
  // en paramètre un tableau de caractère.
  //
  public String getString(int pos, int lg) {
    if (pos >= 0 && pos < _lgCh) {
        if (pos + lg > _lgCh) lg = _lgCh - pos; // Réduction de la longueur d'extraction si nécessaire
        return new String(_aCh, pos, lg);
    } else return "";
    // Ou bien, beaucoup plus concis, en utilisant getChaine() :
    // return getChaine(pos, lg).toString();
  }

  // Teste si la chaîne est égale au paramètre "ch" de type "Chaine"
  //
  public boolean egale(Chaine ch) {
    if (_lgCh != ch.getLg()) return false;
    for (int i = 0; i < _lgCh; i++) {
        if (_aCh[i] != ch.getChar(i)) return false;
    }
    return true;
  }

  // Idem précédente, mais avec un paramètre de type "String" (surdéfinition)
  //
  public boolean egale(String s) {
    if (_lgCh != s.length()) return false;
    for (int i = 0; i < _lgCh; i++) {
        if (_aCh[i] != s.charAt(i)) return false;
    }
    return true;
    // Ou bien, de manière beaucoup plus concise : return s.equals(this.toString());
  }

  // Recherche de la sous-chaîne "s" (de type "String") dans la chaîne : 
  // retourne la position de la première occurrence de "s", ou bien -1 si "s"
  // est introuvable.
  //
  public int recherche(String s) {
    int lg = s.length();
    for (int depart = 0; depart < _lgCh - lg + 1; depart++) {
      int i = 0;
      while ((i < lg) && (_aCh[depart + i] == s.charAt(i))) i++;
      if (i == lg) return depart;
    }
    return -1;
  }

  // Idem avec une sous-chaîne de type "Chaine" (surdéfinition)
  //
  public int recherche(Chaine ch) {
    int lg = ch.getLg();
    for (int depart = 0; depart < _lgCh - lg + 1; depart++) {
      int i = 0;
      while ((i < lg) && (_aCh[depart + i] == ch.getChar(i))) i++;
      if (i == ch.getLg()) return depart;
    }
    return -1;
  }

  // Tronque la chaîne à "lg" caracteres
  //
  public void tronque(int lg) {
    if (lg < _lgCh) _lgCh = lg;
  }

  // Décale la sous-chaîne comprise entre "pos" et la fin de la chaîne
  // de "n" unités vers la droite. Ici, on retourne un booléen pour dire à
  // l'appelant si le décalage a pu se faire ou pas.
  // N.B: il s'agit d'une méthode utilisée par la méthode publique "insere". On
  // la déclare "private" car elle n'a pas vocation à être appelée directement
  // de l'extérieur.
  //
  private boolean _decale(int pos, int n) {
    if (_lgCh + n <= _lgMax) {
      for (int i = _lgCh - 1; i >= pos; i--) {
          _aCh[i + n] = _aCh[i];
          _aCh[i] = 0;
      }
      _lgCh += n;
      return true;
    } else return false;
  }

  // Insertion dans la chaîne d'une sous-chaîne de type "String" à la position
  // "pos". Cette méthode utilise la méthode auxiliaire "_decale".
  //
  public void insere(String s, int pos) {
    if (pos >= 0 && pos < _lgCh) {
      int lg = s.length();
      if (_decale(pos, lg)) {
          for (int i = 0; i < lg; i++) _aCh[pos + i] = s.charAt(i);
      }
    }
  }

  // Idem avec une sous-chaîne de type "Chaine" (surdéfinition)
  //
  public void insere(Chaine ch, int pos) {
    if (pos >= 0 && pos < _lgCh) {
      int lg = ch.getLg();
      if (_decale(pos, lg)) {
          for (int i = 0; i < lg; i++) _aCh[pos + i] = ch.getChar(i);
      }
    }
  }

  // Comparaison de la chaîne "s" (de type "String") à la chaîne. Renvoie -1
  // si "s" est plus grande (ordre lexicographique) que la chaîne, 0 si "s"
  // est égale à la chaine, et 1 si "s" est plus petite que la chaîne.
  //
  public int compare(String s) {
    int lg = s.length();
    int i = 0;
    while (   (i < lg)
           && (i < _lgCh)
           && (_aCh[i] == s.charAt(i))) i++;
    if (i == lg) {
      if (i == _lgCh) return 0;
      else return 1;
    } else if (i == _lgCh) {
      return -1;
    } else {
      if (_aCh[i] < s.charAt(i)) return -1;
      else return 1;
    }
  }

  // Idem avec une chaîne "ch" de type "Chaine" (surdéfinition)
  //
  public int compare(Chaine ch) {
    int lg = ch.getLg();
    int i = 0;
    while ((i < lg)
           && (i < _lgCh)
           && (_aCh[i] == ch.getChar(i))) i++;
    if (i == lg) {
      if (i == _lgCh) return 0;
      else return 1;
    } else if (i == _lgCh) {
      return -1;
    } else {
      if (_aCh[i] < ch.getChar(i)) return -1;
      else return 1;
    }
  }
  
  // Le remplacement est laissé en exercice. Il peut être écrit "from scratch"
  // ou bien, plus astucieusement, en utilisant les méthodes recherche, _decale et
  // setChaine...
}
