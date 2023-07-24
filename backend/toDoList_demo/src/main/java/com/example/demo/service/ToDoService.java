package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ToDoRepo;
import com.example.demo.model.ErrorType;
import com.example.demo.model.ToDo;

@Service
public class ToDoService {
    @Autowired
	ToDoRepo repo;

    public void saveToDo(ToDo toDo){
        repo.save(toDo);
    }

    public void saveToDos(List<ToDo> toDos){
        repo.saveAll(toDos);
    }

    public ErrorType deleteToDo(int tdId){
        if(repo.findById(tdId).isEmpty())
			return new ErrorType("ERROR_NO_SUCH_ELEMENT");
		else {
			ToDo toDo = repo.findById(tdId).orElse(null);
			repo.delete(toDo);
			return new ErrorType("NO_ERROR");
		}
    }

    public ErrorType doneToDO(int tdId){
        if(repo.findById(tdId).isEmpty())
			return new ErrorType("ERROR_NO_SUCH_ELEMENT");
		else {
			ToDo toDo = repo.findById(tdId).orElse(null);
			repo.save(new ToDo(toDo.getTdId(), toDo.getTdMsg(), !toDo.isTdDone()));
			return new ErrorType("NO_ERROR");
		}
    }

    private ErrorType checkEmpty(int tdId){
        if(repo.findById(tdId).isEmpty())
			return new ErrorType("ERROR_NO_SUCH_ELEMENT");
		else {
            return new ErrorType("NO_ERROR");
        }
    }
}
