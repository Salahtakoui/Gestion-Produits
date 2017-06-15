package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Operation;
import metier.Produit;

public class ProduitServlet extends HttpServlet{
	private Operation op;
	
	 public void init(ServletConfig config) throws ServletException {
		 
		op =new Operation();
	 }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Récupération des données
		
		if(req.getParameter("action")!=null)
		{
			op.removeProduit(Integer.parseInt(req.getParameter("id")));
			
		}
		else
		{
			String nom = req.getParameter("nom");
			String desc = req.getParameter("desc");
			String prix = req.getParameter("prix");
			String etat = req.getParameter("etat");
			
			Produit p =new Produit(1,nom,desc,Integer.parseInt(prix),Integer.parseInt(etat));
			op.addProduit(p);
			
		}	
		
		
		
		ProduitBeans pb =new ProduitBeans();
        pb.setListe(op.getProduits());		
		
        req.setAttribute("modele",pb);
		req.getRequestDispatcher("Produit.jsp").forward(req, resp);
		
		
		
		/*
		//Affichage des données
		
		PrintWriter pr =resp.getWriter();
		pr.println("<html><head><title>Application JAVA EE</title></head><body>");
		pr.println(nom);
		pr.println(desc);
		pr.println(prix);
		pr.println(etat);
		pr.println("</body></html>"); */
		

	}

}