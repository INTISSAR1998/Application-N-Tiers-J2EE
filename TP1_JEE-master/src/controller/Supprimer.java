package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Gestiondb;

/**
 * Servlet implementation class Supprimer
 */
public class Supprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gestiondb gestiondb;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supprimer() {
    	  super();
        gestiondb= new Gestiondb();

      
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("numero")!=null)
		{
		gestiondb.deleteEtudiant(Integer.parseInt(request.getParameter("numero")));
		response.sendRedirect("Liste.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
