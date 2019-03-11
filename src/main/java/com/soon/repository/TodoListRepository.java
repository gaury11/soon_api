package com.soon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soon.domain.TodoList;


public interface TodoListRepository extends JpaRepository<TodoList, Long> {
	
}
