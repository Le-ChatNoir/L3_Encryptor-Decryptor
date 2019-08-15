package exercice4.test;

import exercice4.Encrypteur;

/**
 * Tests de cryptage.
 */
public final class Emetteur {

  /**
   * Constructeur privé. Permet d'interdire l'instanciation de la classe de
   * l'extérieur.
   */
  private Emetteur() {

  }

  /**
   * Programme principal.
   * 
   * @param args
   *            arguments de la ligne de commande
   * @throws InterruptedException
   *             soulevée quand join est interrompu
   */
  public static void main(final String[] args) throws InterruptedException {
    Thread t;
    final int attente = 800; // temps d'attente avant annulation (en ms)

    final long startTime = System.currentTimeMillis();
    // ----
    
    t = new Encrypteur("poeme.txt", "poemecrypt.txt").encrypte();
    // t.join(); // attente indéfinie
    t.join(attente);
    t.interrupt(); // attente maximale de "attente" s

    t = new Encrypteur("time.mp4", "timecrypt.mp4").encrypte();
    // t.join(); // attente indéfinie
    t.join(attente);
    t.interrupt(); // attente maximale de "attente" s

    // ----
    long endTime = System.currentTimeMillis();
    System.out.println("Temps d'exécution : " + (endTime - startTime) + "ms");
  }

}

/*
 
1/3 - Chargement de poeme.txt... ok.
2/3 - Encryptage et sauvegarde dans poemecrypt.txt... ok.
3/3 - Sauvegarde du crypteur dans poemecrypt.txt.crypteur... ok.
1/3 - Chargement de time.mp4... Temps d'exécution : 1007ms
ANNULATION
 
 */
