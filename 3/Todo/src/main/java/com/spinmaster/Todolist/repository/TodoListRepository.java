package com.spinmaster.Todolist.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spinmaster.Todolist.model.Tasks;

public interface TodoListRepository extends JpaRepository<Tasks, Long>{
	Collection<Tasks> findBytaskname(String taskname);
	Collection<Tasks> findBytasknameStartsWithIgnoreCase(String taskname);
	
	@Query("select new map (T.id as id, T.taskname as taskname, T.performdate as performdate, T.category as category, T.priority as priority, T.isdone as isdone) from Tasks T")
	Collection<Tasks> findAllCustom();
	
	@Query("select new map (T.id as id, T.taskname as taskname, T.performdate as performdate, T.category as category, T.priority as priority, T.isdone as isdone) from Tasks T order by performdate desc")
	Collection<Tasks> findAllCustomByDate();
	
	@Query("select new map (T.id as id, T.taskname as taskname, T.performdate as performdate, T.category as category, T.priority as priority, T.isdone as isdone) from Tasks T")
	Collection<Tasks> findAllCustomByPriority();
}
