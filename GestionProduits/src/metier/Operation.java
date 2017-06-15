package metier;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Operation {
	
	private ArrayList<Produit> produits = new ArrayList<Produit>();

	public ArrayList<Produit> getProduits() 
	{
		ArrayList<Produit> listProduits = new ArrayList<Produit>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
	        java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionproduits","root","");
		
	        PreparedStatement pr =cn.prepareStatement("select * from produit");	
		    
	        ResultSet rs = pr.executeQuery();
	        
	        while(rs.next())
	        {
	        	Produit p =new Produit();
	        	p.setId(rs.getInt("id"));
	        	p.setNom(rs.getString("nom"));
	        	p.setDesc(rs.getString("desc"));
	        	p.setPrix(rs.getInt("prix"));
	        	p.setEtat(rs.getInt("etat"));
	        	
	        	listProduits.add(p);
	        }
	        
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return listProduits;
		
		/*return produits;*/
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}
	

	public void addProduit(Produit p)
	{
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
	        java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionproduits","root","");
		
	        PreparedStatement pr =cn.prepareStatement("insert into produit values (NULL,?,?,?,?)");	
		    
	        pr.setString(1,p.getNom());
	        pr.setString(2,p.getDesc());
	        pr.setInt(3,p.getPrix());
		    pr.setInt(4,p.getEtat());
		    pr.execute();
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	     /*	produits.add(p); */
	}
	
	
	public void removeProduit(int id)
	{
		
		// Supprimer Produit BD
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
	        java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionproduits","root","");
		
	        PreparedStatement pr =cn.prepareStatement("delete from produit where id=?");	
		    
	        pr.setInt(1,id);
		    
		    pr.execute();
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		
		
		
	  /*	for(Produit p :produits)
		{
			if(p.getId()==id)
			{
				produits.remove(p);
				break;
			}
		}
		*/	
	}
}
