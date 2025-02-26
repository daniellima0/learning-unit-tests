package pub;
import java.util.Vector;
import java.util.Enumeration;

public class Cocktail {
	private class Ingrediant {
		public String ingrediant;
		public double quantite;

		public Ingrediant(String ingrediant, double quantite){
			this.ingrediant = ingrediant;
			this.quantite = quantite;
		}
	}

	public String nom;
	public Vector<Ingrediant> ingrediants;
	public boolean alcoolise;

	public Cocktail(String nom){
		this.nom = nom;
		this.ingrediants = new Vector<>();
		this.alcoolise = false;
	}

	public void add(String ingrediant, double quantite){
		if (ingrediant.equalsIgnoreCase("whiskey") || ingrediant.equalsIgnoreCase("rum") ||
				ingrediant.equalsIgnoreCase("vodka") || ingrediant.equalsIgnoreCase("tequila")) {
			this.alcoolise = true;
		}
		this.ingrediants.add(new Ingrediant(ingrediant, quantite));
	}

	public boolean alcoolFree(){
		return !this.alcoolise;
	}

	public String toString(){
		StringBuilder result = new StringBuilder();
		Enumeration<Ingrediant> e = this.ingrediants.elements();
		while (e.hasMoreElements()) {
			Ingrediant current = e.nextElement();
			result.append(current.ingrediant).append(" ").append(current.quantite).append("%\t");
		}
		return result.toString();
	}
}
