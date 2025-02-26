package pub;
import java.util.Vector;
import java.util.Enumeration;

public class Bar {
	public Vector<Boisson> boissonChaude;
	public Vector<Boisson> boissonFroide;
	public Vector<Boisson> boissonAlcoolisee;
	public Vector<Cocktail> cocktailSansAlcoole;
	public Vector<Cocktail> cocktailAvecAlcoole;

	public Bar(){
		this.boissonChaude = new Vector<>();
		this.boissonFroide = new Vector<>();
		this.boissonAlcoolisee = new Vector<>();
		this.cocktailAvecAlcoole = new Vector<>();
		this.cocktailSansAlcoole = new Vector<>();
	}

	public void add(Boisson boisson){
		if (boisson.alcoolise) {
			this.boissonAlcoolisee.add(boisson);
		} else {
			if (boisson.nom.equalsIgnoreCase("coffee") || boisson.nom.equalsIgnoreCase("tea")) {
				this.boissonChaude.add(boisson);
			} else {
				this.boissonFroide.add(boisson);
			}
		}
	}

	public void add(Cocktail cocktail){
		if (cocktail.alcoolFree()) {
			this.cocktailSansAlcoole.add(cocktail);
		} else {
			this.cocktailAvecAlcoole.add(cocktail);
		}
	}

	public Object serv(String command){
		Boisson retourB = null;
		Cocktail retourC = null;
		Enumeration<Boisson> e;
		Enumeration<Cocktail> ec;

		e = this.boissonFroide.elements();
		while (e.hasMoreElements()) {
			retourB = e.nextElement();
			if (retourB.nom.equalsIgnoreCase(command)) {
				this.boissonFroide.remove(retourB);
				return retourB;
			}
		}

		e = this.boissonAlcoolisee.elements();
		while (e.hasMoreElements()) {
			retourB = e.nextElement();
			if (retourB.nom.equalsIgnoreCase(command)) {
				this.boissonAlcoolisee.remove(retourB);
				return retourB;
			}
		}

		e = this.boissonChaude.elements();
		while (e.hasMoreElements()) {
			retourB = e.nextElement();
			if (retourB.nom.equalsIgnoreCase(command)) {
				this.boissonChaude.remove(retourB);
				return retourB;
			}
		}

		ec = this.cocktailSansAlcoole.elements();
		while (ec.hasMoreElements()) {
			retourC = ec.nextElement();
			if (retourC.nom.equalsIgnoreCase(command)) {
				this.cocktailSansAlcoole.remove(retourC);
				return retourC;
			}
		}

		ec = this.cocktailAvecAlcoole.elements();
		while (ec.hasMoreElements()) {
			retourC = ec.nextElement();
			if (retourC.nom.equalsIgnoreCase(command)) {
				this.cocktailAvecAlcoole.remove(retourC);
				return retourC;
			}
		}

		return null;
	}
}
