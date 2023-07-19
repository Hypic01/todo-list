package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ToDo;

public interface ToDoRepo extends JpaRepository<ToDo, Integer> {

}
