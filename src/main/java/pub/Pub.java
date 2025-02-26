package pub;

public class Pub {
	public Bar bar;
	public Cave cave;

	public Pub(){
		this.bar = new Bar();
		this.cave = new Cave();
	}

	public void approvisionnerBar(String nom){
		Boisson boisson = this.cave.take(nom);
		if (boisson != null) {
			this.bar.add(boisson);
		}
	}

	public static void main(String[] args) {
		Pub pub = new Pub();

		pub.cave.add(new Boisson("Coca"));
		pub.cave.add(new Boisson("Eau"));
		pub.cave.add(new Boisson("Whisky", 40));
		pub.cave.add(new Boisson("Biere", 8));

		pub.approvisionnerBar("Biere");
		pub.approvisionnerBar("Whisky");
		pub.approvisionnerBar("Coca");
		pub.approvisionnerBar("Eau");

		Cocktail maz = new Cocktail("Mazout");
		maz.add("Biere", 50);
		maz.add("Coca", 50);
		pub.bar.add(maz);

		pub.bar.boissonChaude.add(new Boisson("Cafe"));

		System.out.println(pub.bar.serv("Cafe"));
	}
}
