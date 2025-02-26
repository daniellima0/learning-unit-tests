package pub;

public class Boisson {
	public String nom;
	public boolean alcoolise;
	public float degre;
	public float volume;
	public float prix;

	public Boisson(String nom){
		this.nom = nom;
		this.alcoolise = false;
	}

	public Boisson(String nom, float degre){
		this.nom = nom;
		this.degre = degre;
		this.alcoolise = true;
	}

	public String toString(){
		return this.alcoolise ? this.nom + " (l'abus d'alcool est dangereux pour la sante)" : this.nom;
	}
}
