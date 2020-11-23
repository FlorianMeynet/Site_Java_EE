package com.web.propre;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class LoginWay
 */
@WebServlet("/LoginWay")
public class LoginWay extends HttpServlet {
	private static final long serialVersionUID = 1L;

		
		@Resource(name="jdbc/projetee")
		private DataSource dataSource;
		
		int id;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginWay() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	public void init() throws ServletException
	{
		super.init();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("loginPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		System.out.println("on est laaaaaa au début");
		int classId=-1;
		String name= request.getParameter("name").replaceAll(" ", "");
		String password=request.getParameter("motDePasse").replaceAll(" ", "");
		String sql="Select classID from projetee.Personne WHERE name='"+name+"' and password='"+password+"';";
		System.out.println(sql);
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		try
		{
			myConn=dataSource.getConnection();
			myStmt=myConn.createStatement();
			myRs=myStmt.executeQuery(sql);
			while (myRs.next())
			{
				classId=myRs.getInt("classID");
				System.out.println(classId);
				HttpSession session = request.getSession();
				System.out.println("1");
				session.setAttribute("classId", classId);
				System.out.println("2");
				session.setAttribute("name", name);
				System.out.println("3");
				TodoDB a = new TodoDB(dataSource);
				System.out.println("4");
				session.setAttribute("listTodo",a.RecuperationTodos(classId));
				System.out.println("5");
				if(classId==0) {
					request.getRequestDispatcher("listTodo.jsp").forward(request, response);
				}
				else {
					
					request.getRequestDispatcher("listTodo_student.jsp").forward(request, response);
				}
				
			}
			System.out.println("erreur mdp");
			request.getRequestDispatcher("loginPage.jsp").forward(request, response);
			
			
			
		}
		catch (Exception e)
		{
			System.out.println("probleme mdp ou bdd");
			request.getRequestDispatcher("loginPage.jsp").forward(request, response);
			
		}
	}

}
