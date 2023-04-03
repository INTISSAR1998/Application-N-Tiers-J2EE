package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LignePanier;
import model.Panier;

/**
 * Servlet implementation class DeletePanier
 */
@WebServlet("/DeletePanier")
public class DeletePanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 HttpSession session = request.getSession();
	 Panier panier = (Panier)session.getAttribute("panier");
	 int id = Integer.parseInt(request.getParameter("id"));
	for(int i = 0 ;i<panier.getLignepanier().size(); i++) {
		 if(panier.getLignepanier().get(i).getProduit().getId()==id) {
			 if(panier.getLignepanier().get(i).getQuantite()>1) {
				 panier.getLignepanier().get(i).setQuantite(panier.getLignepanier().get(i).getQuantite()-1);
				
			 }
			 else {
				 
				 panier.getLignepanier().remove(panier.getLignepanier().get(i));
			 }
			 }
	}
	 for(LignePanier lp : panier.getLignepanier()) {
		
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
