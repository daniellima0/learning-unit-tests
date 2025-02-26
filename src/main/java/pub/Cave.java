package pub;
import java.util.Vector;
import java.util.Enumeration;

public class Cave {
	public Vector<Boisson> rayons;

	public Cave(){
		this.rayons = new Vector<>();
	}

	public void add(Boisson b){
		this.rayons.add(b);
	}

	public Boisson take(String nom){
		Boisson retour = null;
		Enumeration<Boisson> e = this.rayons.elements();
		while (e.hasMoreElements()) {
			retour = e.nextElement();
			if (retour.nom.equalsIgnoreCase(nom)) {
				this.rayons.remove(retour);
				return retour;
			}
		}
		return null;
	}
}
