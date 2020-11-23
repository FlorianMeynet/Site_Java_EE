package com.web.propre;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class AddTodo
 */
@WebServlet("/AddTodo")
public class AddTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Resource(name="jdbc/projetee")
	private DataSource dataSource;
	TodoDB tododb;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTodo() {
        super();
        tododb= new TodoDB(dataSource);
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addTodo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name= request.getParameter("title");
		System.out.println(name);
		String description=request.getParameter("description");
		System.out.println(description);
		
		tododb.AjouterTodo(description, name);
		
		System.out.println("Bien ajouter");
		
		HttpSession session = request.getSession();

		session.setAttribute("listTodo", tododb.RecuperationTodos(0));
		
		response.sendRedirect("listTodo.jsp");
	}

}
