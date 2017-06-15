package metier;

public class Produit {
	
	private int id;
	private String nom;
	private String desc;
	private int prix;
	private int etat;
	
	public Produit() {
		super();
	}

	public Produit(String nom, String desc, int prix, int etat) {
		super();
		this.nom = nom;
		this.desc = desc;
		this.prix = prix;
		this.etat = etat;
	}

	public Produit(int id, String nom, String desc, int prix, int etat) {
		super();
		this.id = id;
		this.nom = nom;
		this.desc = desc;
		this.prix = prix;
		this.etat = etat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	
	public String toString()
	{
		return "Id:"+id+" "+"nom :"+nom+" "+"desc :"+desc+" "+"prix :"+prix+" "+"etat :"+etat+" .";
	}
	
	public void show()
	{
		System.out.println(this.toString());
	}

}
