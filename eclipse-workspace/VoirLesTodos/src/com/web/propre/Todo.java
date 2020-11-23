package com.web.propre;

import java.util.ArrayList;
import java.util.List;

public class Todo {
	String title;
	String description;
	int id;

	
	public Todo(String title,String description,int id)
	{
		this.title=title;
		this.description=description;
		this.id=id;

	}
	public Todo()
	{
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
