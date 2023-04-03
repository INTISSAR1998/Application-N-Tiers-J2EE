package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GestionCentreImp;
import model.Consultation;

/**
 * Servlet implementation class ServletRecherche
 */
public class ServletRecherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
    GestionCentreImp gestionCentre ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRecherche() {
    	super();
    	gestionCentre = new GestionCentreImp();


        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("consultation.jsp");

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Vector<Consultation> ListeConsultation = gestionCentre.getConsultationByMedecin(Integer.parseInt(request.getParameter("idMedecin")));
		request.setAttribute("ListeConsultation2", ListeConsultation);
		request.getRequestDispatcher("consultation.jsp").forward(request, response);
	}

}
