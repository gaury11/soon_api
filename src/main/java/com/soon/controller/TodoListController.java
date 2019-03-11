package com.soon.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soon.domain.TodoList;
import com.soon.service.TodoListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/todolist")
public class TodoListController {
	
	@Autowired
	TodoListService	todoListService;
	
	@GetMapping("")
	 public ResponseEntity<List<TodoList>> getTodoList(){
		ResponseEntity<List<TodoList>> response = null;

        try{
            response = new ResponseEntity<>(todoListService.findTodoList(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;

	}
	
	@DeleteMapping("/{idx}")
	public ResponseEntity<String> deleteTodoList(@PathVariable("idx")Long idx){
		
		log.info("idx : {}", idx);

        ResponseEntity<String> response = null;
        todoListService.deleteTodoListByIdx(idx);
        response = new ResponseEntity<>("DELETE SUCCESS", HttpStatus.OK);

        return response;
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<TodoList> saveTodoList(@RequestBody Map<String, Object> params){
		ResponseEntity<TodoList> response = null;
		
		TodoList todoList = TodoList.builder()
				.todoContent(params.get("todoContent").toString())
				.regDate(LocalDateTime.now())
				.build();
		
		log.info("insert todoList : {}", todoList.toString());
		response = new ResponseEntity<>(todoListService.saveTodoList(todoList), HttpStatus.OK);

        log.info("result : {}", response.toString());
		
		return response;
	}
	
	@PostMapping("/edit")
	public ResponseEntity<TodoList> editTodoList(@RequestBody Map<String, Object> params){
		ResponseEntity<TodoList> response = null;
		Long editIdx = null;
		
		if (params.get("idx") != null) {
			editIdx =  ((Number) params.get("idx")).longValue();
			
			log.info("editIdx : {}", editIdx);
			
			Optional<TodoList>  oneTodo = todoListService.selectOneTodo(editIdx);
			log.info("oneTodo : {}", oneTodo);
			log.info("oneTodo.getRegDate() : {}", oneTodo.get().getRegDate());
			//Long editIdx = ((Number) params.get("idx")).longValue();
			
			log.info("editIdx param : {}", editIdx);
			
			TodoList todoList = TodoList.builder()
					.idx(editIdx)
					.todoContent(params.get("todoContent").toString())
					.regDate(oneTodo.get().getRegDate())
					.uptDate(LocalDateTime.now())
					.build();
			
			log.info("update todoList : {}", todoList.toString());
			response = new ResponseEntity<>(todoListService.saveTodoList(todoList), HttpStatus.OK);
			
		}
				return response;
	}

}
