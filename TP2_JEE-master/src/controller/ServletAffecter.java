package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import model.Error;
import dao.*;

/**
 * Servlet implementation class ServletAffecter
 */
public class ServletAffecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       GestionCentreImp gestionCentre ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAffecter() {
        super();

    	 gestionCentre = new GestionCentreImp();
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
		Patient p = new Patient(Integer.parseInt(request.getParameter("idPatient")));
		Medecin m = new Medecin(Integer.parseInt(request.getParameter("idMedecin")));
		Consultation c = new Consultation(0, 
				Integer.parseInt(request.getParameter("jour"))
				,Integer.parseInt(request.getParameter("heure"))
				,p
				,m);

		Error error = new Error("1","success");
		
		boolean test = false;
		for(Consultation cc : gestionCentre.getAllConsultation()) {
			if(cc.getJour()==(c.getJour())&&cc.getHeure()==(c.getHeure())) {
				error.setCode("2");
				error.setMessage("cette date est occupé");
				test = true;
			}
		}
		
		HttpSession session = request.getSession();

		if(test) {
			session.setAttribute("error", error);
			response.sendRedirect("gestion.jsp");
		}
		else {
			gestionCentre.addConsultation(c);
			response.sendRedirect("gestion.jsp");
	       	 }

	}

}
