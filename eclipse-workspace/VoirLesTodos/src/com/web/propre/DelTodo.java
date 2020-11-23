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
 * Servlet implementation class ModTodo
 */
@WebServlet("/DelTodo")
public class DelTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TodoDB todoDb;
	
	@Resource(name="jdbc/projetee")
	private DataSource dataSource;
	
	int id;
	
    public DelTodo() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void init() throws ServletException
	{
		super.init();
		todoDb=new TodoDB(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		id=Integer.parseInt(request.getParameter("todoId"));
		todoDb.DeleteTodo(id);
		
		HttpSession session = request.getSession();
		session.setAttribute("listTodo", todoDb.RecuperationTodos(0));
		
		request.getRequestDispatcher("listTodo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
