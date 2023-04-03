package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddFruit
 */
public class AddFruit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFruit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fruit = request.getParameter("fruit");
		if(fruit != null && !fruit.equals("")) {
			HttpSession session = request.getSession();
			Object obj = session.getAttribute(fruit);
			if(obj == null) {
				session.setAttribute(fruit, new Integer(1));
			}
			else {
				Integer num = (Integer) obj;
				num++;
				session.setAttribute(fruit, num);
			}
		}
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/panier.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
