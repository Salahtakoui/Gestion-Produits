package metier;

import java.util.Iterator;

public class TestProduit {

	public static void main(String[] args) 
	{
	  Operation op =new Operation();
	  Produit p= new Produit();
	  
	  op.addProduit(new Produit(1,"clavier","clavier Dell",70,1));
	  op.addProduit(new Produit(2,"Ecran","Ecran Dell",70,1));
	  
	  Iterator<Produit> prds = op.getProduits().iterator();
	  
		while(prds.hasNext())
		{
			p=prds.next();
			p.show();
		}
	}

}
