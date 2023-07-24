package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ToDoRepo;
import com.example.demo.model.ErrorType;
import com.example.demo.model.ToDo;
import com.example.demo.service.ToDoService;

@RestController
public class ToDoController {
	@Autowired
	ToDoService serv;
	@Autowired
	ToDoRepo repo;
	
	@GetMapping("/todos")
	@ResponseBody
	public List<ToDo> getToDos() {
		return repo.findAll();
	}
	
	@GetMapping("/todo/{tdid}")
	@ResponseBody
	public Optional<ToDo> getToDos(@PathVariable("tdid") int tdId) {
		return repo.findById(tdId);
	}
	
	@PostMapping(path = "/todo", consumes = "application/json")
	public void addToDo(@RequestBody ToDo toDo) {
		serv.saveToDo(toDo);
	}

	@PostMapping(path = "/todos", consumes = "application/json")
	public void addToDos(@RequestBody List<ToDo> toDos) {
		serv.saveToDos(toDos);
	}
	
	@DeleteMapping("/todo/{tdid}")
	public ErrorType deleteToDo(@PathVariable("tdid") int tdId) {
		return serv.deleteToDo(tdId);
	}
	
	@PutMapping(path="/todo", consumes = "application/json")
	public void updateOrAddAlien(@RequestBody ToDo toDo) {
		serv.saveToDo(toDo);
	}
	
	@PutMapping("/todo/{tdid}")
	@ResponseBody
	public ErrorType doneToDo(@PathVariable("tdid") int tdId) {
		return serv.doneToDO(tdId);
	}
}
