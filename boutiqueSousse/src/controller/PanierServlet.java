package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LignePanier;
import model.Panier;
import model.Produit;
import repository.BoutiqueManagement;

/**
 * Servlet implementation class PanierServlet
 */
@WebServlet("/PanierServlet")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoutiqueManagement boutiqueManagement = new BoutiqueManagement();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Produit p = boutiqueManagement.getProduitById(id);
		
		HttpSession session = request.getSession();
		if((Panier)session.getAttribute("panier") == null)
		{
			LignePanier lp = new LignePanier(p, 1);
			List<LignePanier> ListLigneP = new ArrayList<LignePanier>();
			ListLigneP.add(lp);
			Panier panier = new Panier(ListLigneP);
			session.setAttribute("panier", panier);
			
		}
		else {
			Panier panier = (Panier)session.getAttribute("panier");
			boolean test = false ;
			for(LignePanier lp : panier.getLignepanier()) {
			if(lp.getProduit().getId()==id) {
				lp.setQuantite(lp.getQuantite()+1);
				test = true;
			}	
			}
			if(!test) {
				LignePanier lp = new LignePanier(p, 1);
			
				panier.getLignepanier().add(lp);
			}
		}
		response.sendRedirect("panier.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
