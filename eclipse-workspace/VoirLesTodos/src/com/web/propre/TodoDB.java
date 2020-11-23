package com.web.propre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class TodoDB {

	private DataSource dataSource;
	
	public TodoDB(DataSource dataSource1)
	{
		this.dataSource=dataSource1;
	}
	
	
	
	public List<Todo> RecuperationTodos(int classId)
	{
		List<Todo> listSortie = new ArrayList<Todo>();
		if (classId==0) // si c'est un prof
		{
			System.out.println("c'est un prof");
			String sql = "Select * from projetee.todo;";
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
					String title=myRs.getString("name");
					String description=myRs.getString("description");
					int id=myRs.getInt("idTodo");
					
					listSortie.add(new Todo(title,description,id));
			
				}
				close(myConn,myStmt,myRs);
			}
			
			catch (Exception e)
			{
				System.out.println("Erreur importation todo prof");
			}
		}
		else // si c'est un eleve
		{
			System.out.println("c'est un élève");
			String sql="Select td.* from projetee.todo as td JOIN projetee.TodoClass as tc ON tc.idTodoAux=td.idTodo WHERE tc.classIDAux='"+classId+"';";
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
					String title=myRs.getString("name");
					String description=myRs.getString("description");
					int id=myRs.getInt("idTodo");
					listSortie.add(new Todo(title,description,id));
			
				}
				close(myConn,myStmt,myRs);
			}
			catch (Exception e)
			{
				System.out.println("Erreur importation todo eleve"+classId);
			}
	
		}
	
		return listSortie;
	}
	
	public Todo RecuperationTodo(int id)
	{
		Todo sortie=null;
		String sql = "Select * from projetee.Todo where idTodo='"+id+"';";
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
				String title=myRs.getString("name");
				String description=myRs.getString("description");			
				sortie= new Todo(title,description,id);
		
			}
		}
		
		catch (Exception e) {
			
		}
		close(myConn,myStmt,myRs);
		return sortie;
	}
	public void AjouterTodo(String descr,String nom)
	{
		String sql="Insert INTO `projetee`.`todo` (description,name) VALUES ('"+descr+"','"+nom+"');";
		System.out.println(sql);
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		try
		{
			myConn=dataSource.getConnection();
			myStmt=myConn.createStatement();
			System.out.println("On est la !! ");
			myRs=myStmt.executeQuery(sql);
			while (myRs.next())
			{
				
			}
		}
		
		catch (Exception e) {
			System.out.println("Probleme : " +e);
		}

		close(myConn,myStmt,myRs);
	}

	public void ModifyTodo(int id,String descr,String nom)
	{
		String sql="UPDATE `projetee`.`todo` set `description`='"+descr+"',`name`='"+nom+"' where idTodo='"+id+"';";
		System.out.println(sql);
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		try
		{
			myConn=dataSource.getConnection();
			myStmt=myConn.createStatement();
			if (myStmt.execute(sql))
			{
			System.out.println(	"Bien importé");
			}
		}
		
		catch (Exception e) {
			System.out.println("Probleme : " +e);
		}

		close(myConn,myStmt,myRs);
	}

	

	public void DeleteTodo(int id)
	{
		String sql="DELETE FROM projetee.Todo WHERE idTodo='"+id+"' ";
		System.out.println(sql);
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		try
		{
			myConn=dataSource.getConnection();
			myStmt=myConn.createStatement();
			if (myStmt.execute(sql))
			{
			System.out.println(	"Bien supprimé");
			}
		}
		
		catch (Exception e) {
			System.out.println("Probleme de del : "+ e);
		}

		close(myConn,myStmt,myRs);
	}
	
	public void close(Connection myConn,Statement myStmt,ResultSet myRs)
	{
		try {
			if(myStmt!=null) myStmt.close();
			if (myRs!=null) myRs.close();
			if(myConn!=null) myConn.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
