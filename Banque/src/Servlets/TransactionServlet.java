package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Client;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/***
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String montant = request.getParameter("montant");
		float mnt = Integer.parseInt(montant);
		Client c = new Client(1);
		c.setSolde(300);
		String operation = "";
		String virement = request.getParameter("virement");
		String retrait = request.getParameter("retrait");
		
		if(virement != null) {
			operation = virement;
			c.Transaction(mnt, operation);
			PrintWriter pw = response.getWriter();
			pw.println("Virement effectuée avec succée");
		}
		else {System.out.println("Virement echouée! Réessayez une autre fois");}
			
		
		if(retrait != null) {
			operation = retrait;
			c.Transaction(mnt, operation);
			PrintWriter pw = response.getWriter();
			pw.println("Retrait effectuée avec succée");
		}
		else {System.out.println("Retrait echouée! Réessayez une autre fois");}
	}

}
