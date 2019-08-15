package encryptor;

import java.io.Serializable;
import java.util.*;

@SuppressWarnings("unused") // à supprimer quand le code est complèté
public class Crypteur implements Serializable {
	private static final long serialVersionUID = -5014568058113026043L; // identifiant de sérialisation
	private Map<Integer, Integer> code;
	private Map<Integer, Integer> decode;

	public Crypteur(Set<Integer> s) {
		List<Integer> l = new ArrayList<>();
		l.addAll(s); // s is the integrality of the file t be crypted in octet by octet format
		Collections.shuffle(l); // Scrambles the text to mix every letter
		int i = 0;
		Integer c, cc;
		this.code = new HashMap<Integer, Integer>(); //The original octet/New octet value couple
		this.decode = new HashMap<Integer, Integer>();  //The new octet value/original octet value couple
		for(Iterator<Integer> it = s.iterator(); it.hasNext();){
			c = it.next();
			cc = l.get(i);
			this.code.put(c, cc); //fills the encrypting dictionary
			this.decode.put(cc, c); //fiils the decrypting dictionary
			i++;
		}
	}

	public Integer code(Integer c) {
		Integer result;
		result = this.code.get(c); //get the encrypted value of the entry character(c) from the this.code dictionnary
		if(result == null){
			return c;
		}
		return result;
	}

	public Integer decode(Integer cc) {
		Integer result;
		result = this.decode.get(cc);  //get the decrypted value of the entry character(cc) from the this.decode dictionnary
		if(result == null){
			return cc;
		}
		return result;
	}
}
