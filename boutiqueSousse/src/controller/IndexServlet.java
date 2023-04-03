package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categorie;
import model.Produit;
import repository.BoutiqueManagement;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoutiqueManagement boutiqueManagement = new BoutiqueManagement();
		
		if(request.getParameter("id")!=null)
		{
		int id = Integer.parseInt(request.getParameter("id"));
		List<Produit> allProduitByCategorie = boutiqueManagement.getProduitByCategorie(id);
		request.setAttribute("produits", allProduitByCategorie);
		}
		else {
		List<Produit> allProduit = boutiqueManagement.getAllProduit();
		request.setAttribute("produits", allProduit);
		}
		List<Categorie> allCategorie = boutiqueManagement.getAllCategorie();
		
		request.setAttribute("categories", allCategorie);

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
