package exercice4.test;

import exercice4.Crypteur;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Tests de du crypteur.
 */
public final class TestCrypteur {

  /**
   * Constructeur privé. Permet d'interdire l'instanciation de la classe de
   * l'extérieur.
   */
  private TestCrypteur() {

  }

  /**
   * Programme principal.
   * 
   * @param args arguments de la ligne de commande
   */
  public static void main(final String[] args) {

    Set<Integer> set = new HashSet<Integer>(Arrays.asList(0, 3, 2, 8, 7, 5));
    Crypteur cr = new Crypteur(set);

    for (int i = 0; i < 10; i++) {
      System.out.println("code(" + i + ") = " + cr.code(i) + " ; decode(" + cr.code(i) + ") = "
                         + cr.decode(cr.code(i)));
    }

  }

}

/*
 
code(0) = 7 ; decode(7) = 0
code(1) = 1 ; decode(1) = 1
code(2) = 3 ; decode(3) = 2
code(3) = 2 ; decode(2) = 3
code(4) = 4 ; decode(4) = 4
code(5) = 5 ; decode(5) = 5
code(6) = 6 ; decode(6) = 6
code(7) = 0 ; decode(0) = 7
code(8) = 8 ; decode(8) = 8
code(9) = 9 ; decode(9) = 9

 */
