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
 * Servlet implementation class EditTodo
 */
@WebServlet("/EditTodo")
public class EditTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TodoDB todoDb;
	
	@Resource(name="jdbc/projetee")
	private DataSource dataSource;
	
	int id;
	
	public void init() throws ServletException
	{
		super.init();
		todoDb=new TodoDB(dataSource);
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTodo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id=Integer.parseInt(request.getParameter("todoId"));
		Todo todo = todoDb.RecuperationTodo(id);
		request.setAttribute("Todo",todo);
		request.getRequestDispatcher("editTodo.jsp").forward(request, response);
		
		System.out.println(id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("probleme pas doGET");
		String name= request.getParameter("title");
		System.out.println(name);
		String description=request.getParameter("descr");
		System.out.println(description);
		
		todoDb.ModifyTodo(id, description, name);
		
		System.out.println("Bien update");
		
		HttpSession session = request.getSession();

		session.setAttribute("listTodo", todoDb.RecuperationTodos(0));
		
		response.sendRedirect("listTodo.jsp");
	}

}
