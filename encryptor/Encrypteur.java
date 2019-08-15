package encryptor;
import java.io.*;
import java.util.*;


public class Encrypteur implements Runnable{

	private String source, cible;

	public Encrypteur(String source1, String cible1) {
		this.source = source1;
		this.cible = cible1;
	}

	public final Thread encrypte() {
		Thread t = new Thread(this);
		t.start();
		return t;
	}


	@Override
	public final void run(){
		try{
			System.out.print("Etape 1/3, chargement de " + source + "... ");
			InputStream entree = new BufferedInputStream(new FileInputStream(source)); // Reading stream from input file
			Set<Integer> octets = new HashSet<>(); //Ensemble check si le caractère n'est pas déjà présent
			List<Integer> contenu = new ArrayList<>(); 
			//Interuption with CTRL+C
			for(int i = entree.read(); i != -1; i = entree.read()){
				octets.add(i);
				contenu.add(i);
				if (Thread.interrupted()) {
        		  System.out.println("ANNULATION");
        		  System.out.flush(); // mise à jour en sortie
        		  entree.close();
        		  return;
        		}
			}
			entree.close(); //Input stream no longer needed
			System.out.println(" OK");

			System.out.print("Etape 2/3, encryptage et sauvegarde dans " + cible + "... ");
			OutputStream sortie = new BufferedOutputStream(new FileOutputStream(cible)); // Output stream to get the new encrypted file out
			Crypteur crypt = new Crypteur(octets); // Creates a crypt with the octet set to get the corresponding encrypted dictionnary
			for(int i : contenu){
				sortie.write(crypt.code(i));
				if (Thread.interrupted()) {
        		  System.out.println("ANNULATION");
        		  System.out.flush(); // mise à jour en sortie
        		  sortie.close();
        		  return;
        		}
			}
			sortie.close();
			System.out.println(" OK");

			//saving the key with the dictionnaries for backup purpose
			System.out.print("Etape 3/3, serialisation du crypteur dans " + cible + ".crypteur ... ");
			FileOutputStream fos = new FileOutputStream(cible + ".crypteur");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(crypt);
			oos.close();
			fos.close();
			System.out.println(" OK");
		}
		catch (IOException ioex) {
			throw new IOError(ioex);
		}
	}

}
