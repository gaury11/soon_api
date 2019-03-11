package com.soon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soon.domain.TodoList;
import com.soon.repository.TodoListRepository;

@Service
public class TodoListService {

	private final TodoListRepository todoListRepository;
	
    public TodoListService(TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
    }
    
    public List<TodoList> findTodoList() {
    	
    	return todoListRepository.findAll();
    }
    
    @Transactional
    public void deleteTodoListByIdx(Long idx){
    	todoListRepository.deleteById(idx);
    }

    public TodoList saveTodoList(TodoList todoList) {
    	return todoListRepository.save(todoList);
    }
   
	public Optional<TodoList> selectOneTodo(Long editIdx) {
		// TODO Auto-generated method stub
		return todoListRepository.findById(editIdx);
	}
}
