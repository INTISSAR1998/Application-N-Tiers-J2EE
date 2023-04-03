package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GestionCentreImp;
import model.*;
import dao.*;
/**
 * Servlet implementation class ServletPrincipale
 */
public class ServletPrincipale extends HttpServlet {
	private static final long serialVersionUID = 1L;
    GestionCentreImp gestionCentre ;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrincipale() {
        super();
    	gestionCentre = new GestionCentreImp();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vector<Patient> ListePatient = gestionCentre.getAllPatient();
		Vector<Medecin> ListeMedecin = gestionCentre.getAllMedecin();
		Vector<Consultation> ListeConsultation = gestionCentre.getAllConsultation();
		HttpSession session = request.getSession();
		session.setAttribute("ListePatient", ListePatient);
		session.setAttribute("ListeMedecin", ListeMedecin);
		session.setAttribute("ListeConsultation", ListeConsultation);
		response.sendRedirect("gestion.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
