package com.spinmaster.Todolist.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Tasks {
	@Id @GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min=2, max=30)
	private String taskname;
	
	@NotNull
	private Calendar performdate;
	
	@NotNull
	@Size(min=5, max=15)
	private String category;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@NotNull
	private Boolean isdone;
	
	public Tasks(String taskname, Calendar performdate, String category, Priority priority, Boolean isdone){
		this.taskname = taskname;
		this.performdate = performdate;
		this.category = category;
		this.priority = priority;
		this.isdone = false;
	}

	public Tasks(){
	}

	public Long getId(){
		return id;
	}

	public String getName(){
		return taskname;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskname() {
		return taskname;
	}

	public Calendar getPerformdate() {
		return performdate;
	}

	public String getCategory() {
		return category;
	}

	public Priority getPriority() {
		return priority;
	}
	
	public Boolean getIsdone() {
		return isdone;
	}
}
