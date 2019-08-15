package exercice4.test;

import exercice4.Decrypteur;

/**
 * Tests de décryptage.
 */
public final class Recepteur {

  /**
   * Constructeur privé. Permet d'interdire l'instanciation de la classe de
   * l'extérieur.
   */
  private Recepteur() {

  }

  /**
   * Programme principal.
   * 
   * @param args
   *            arguments de la ligne de commande
   */
  public static void main(final String[] args)  {
    
    long startTime = System.currentTimeMillis();
    // ----
    new Decrypteur(
      "poemecrypt.txt", "poemecrypt.txt.crypteur", "poemedecrypt.txt")
      .decrypte();
    new Decrypteur(
      "timecrypt.mp4", "timecrypt.mp4.crypteur", "timedecrypt.mp4")
      .decrypte();
    // ----
    long endTime = System.currentTimeMillis();
    System.out.println("Temps d'exécution : " + (endTime - startTime) + "ms");

  }

}

/*

1/2 - Chargement de poemecrypt.txt.crypteur... ok.
2/2 - Chargement, décryptage et sauvegarde dans poemedecrypt.txt... ok.
1/2 - Chargement de timecrypt.mp4.crypteur... ok.
2/2 - Chargement, décryptage et sauvegarde dans timedecrypt.mp4... ok.
Temps d'exécution : 472ms

*/
