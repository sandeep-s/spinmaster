package com.spinmaster.Todolist.controller;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spinmaster.Todolist.model.Priority;
import com.spinmaster.Todolist.model.Tasks;
import com.spinmaster.Todolist.repository.TodoListRepository;

@RestController
public class TodoListController {
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Tasks> tasks(){	
		return this.tasksRepository.findAllCustom();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Optional<Tasks> getTaskById(@PathVariable("id") Long id){
	    return tasksRepository.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void saveTask(@RequestBody @Valid Tasks task){
		task.setId(null);
		tasksRepository.save(task);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void deleteTask(@PathVariable("id") Long id){
		tasksRepository.deleteById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public void editTask(@RequestBody @Valid Tasks editedTask ,@PathVariable("id") Long id){
		editedTask.setId(id);
		tasksRepository.saveAndFlush(editedTask);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/populateTasksByDate")
	public Collection<Tasks> tasksByDate(){	
		return this.tasksRepository.findAllCustomByDate();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/populateTasksByPriority")
	public Collection<Tasks> tasksByPriority(){
		Priority.values();
		return this.tasksRepository.findAllCustomByPriority();
	}
	
	@Autowired TodoListRepository tasksRepository;
}
