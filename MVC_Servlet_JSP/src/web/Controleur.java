package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produit;
/**
 * Servlet implementation class Controleur
 */
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Produit prod;
	@Override
	public void init() throws ServletException {
		prod = new Produit();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("codeProduit");
		String design = request.getParameter("designation");
		int prix = Integer.parseInt(request.getParameter("prix"));
		
		prod.setCodeProduit(code);
		prod.setDesignation(design);
		prod.setPrix(prix);
		
		request.setAttribute("model",prod);
		request.getRequestDispatcher("/ajouterProduit.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
