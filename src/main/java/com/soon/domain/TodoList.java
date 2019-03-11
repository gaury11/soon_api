package com.soon.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.soon.domain.TodoList.TodoListBuilder;

import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "ESC_TODO")
@Getter
@NoArgsConstructor
public class TodoList implements Serializable  {

/*	CREATE TABLE `ESC_TODO` (
	  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
	  `TODO_TITLE` varchar(200) DEFAULT NULL,
	  `TODO_CONTENT` varchar(4000) DEFAULT NULL,
	  `REG_DATE` datetime DEFAULT NULL,
	  `UPT_DATE` datetime DEFAULT NULL,
	  PRIMARY KEY (`ID`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8*/
	
	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

	@Column(name = "TODO_TITLE")
	private String todoTitle;

    @Column(name = "TODO_CONTENT")
    private String todoContent;
    
    @Column(name = "REG_DATE")
    private LocalDateTime regDate;
    
    @Column(name = "UPT_DATE")
    private LocalDateTime uptDate;
    
    @Builder
    public TodoList(Long idx, String todoTitle, String todoContent,
    		LocalDateTime regDate, LocalDateTime uptDate){
    	this.idx = idx;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.regDate = regDate;
        this.uptDate = uptDate;
    }
}
