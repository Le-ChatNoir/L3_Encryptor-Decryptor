package encryptor;
import java.io.*;
import java.util.*;

@SuppressWarnings("unused") // à supprimer quand le code est complèté
public class Decrypteur {

	private String source, cible, sourcecrypteur;

	public Decrypteur(String source1, String sourcecrypteur1, String cible1) {
		this.source = source1;
		this.sourcecrypteur = sourcecrypteur1;
		this.cible = cible1;
	}

	public void decrypte() {
		try{
			System.out.print("Etape 1/2, deserialisation du crypteur " + sourcecrypteur + " ...");
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcecrypteur));
			ObjectInputStream ois = new ObjectInputStream(bis);
			Crypteur crypt = (Crypteur) ois.readObject();
			ois.close();
			bis.close();
			System.out.println(" OK");


			System.out.print("Etape 2/2, chargement, decryptage et sauvegarde dans " + cible + " ...");
			InputStream entree = new BufferedInputStream(new FileInputStream(source));
			OutputStream sortie = new BufferedOutputStream(new FileOutputStream(cible));
			for(int i = entree.read(); i != -1; i = entree.read()){
				sortie.write(crypt.decode(i));
			}
			entree.close();
			sortie.close();
			System.out.println(" OK");

		} catch(IOException ioex) {
			throw new IOError(ioex);
		} catch (ClassNotFoundException cnf) {
    		throw new Error(cnf);
    	}
	}

}
