package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Gestiondb;
import model.Etudiant;

/**
 * Servlet implementation class Ajouter
 */
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Gestiondb gestiondb; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter() {
        super();

    	gestiondb= new Gestiondb();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Etudiant e= new Etudiant(Integer.parseInt(request.getParameter("num")),request.getParameter("nom"),request.getParameter("prenom"),Integer.parseInt(request.getParameter("tel")));
		gestiondb.addEtudiant(e);
		response.sendRedirect("Liste.jsp");
	}

}
