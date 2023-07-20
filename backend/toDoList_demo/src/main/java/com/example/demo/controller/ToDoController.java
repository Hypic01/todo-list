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

@RestController
public class ToDoController {
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
		System.out.println(toDo.toString());
		repo.save(toDo);
	}
	
	@DeleteMapping("/todo/{tdid}")
	public ErrorType deleteToDo(@PathVariable("tdid") int tdId) {
		if(repo.findById(tdId).isEmpty())
			return new ErrorType("ERROR_NO_SUCH_ELEMENT");
		else {
			ToDo toDo = repo.findById(tdId).orElse(null);
			repo.delete(toDo);
			return new ErrorType("NO_ERROR");
		}
	}
	
	@PutMapping(path="/todo", consumes = "application/json")
	public void updateOrAddAlien(@RequestBody ToDo toDo) {
		repo.save(toDo);
	}
	
	@PutMapping("/todo/{tdid}")
	@ResponseBody
	public ErrorType doneToDo(@PathVariable("tdid") int tdId) {
		if(repo.findById(tdId).isEmpty())
			return new ErrorType("ERROR_NO_SUCH_ELEMENT");
		else {
			ToDo toDo = repo.findById(tdId).orElse(null);
			repo.save(new ToDo(toDo.getTdId(), toDo.getTdMsg(), !toDo.isTdDone()));
			return new ErrorType("NO_ERROR");
		}
	}
}
