package com.kdsoft.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kdsoft.model.Student;
import com.kdsoft.service.StudentService;

@Controller
@RequestMapping(value = "/Hello")
public class MyController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloWorld() {
		return "index";
	}

	@RequestMapping(value = "/insert/{id}", method = RequestMethod.GET)
	public String hello(@PathVariable("id") int id) throws Exception {

		if (id == 2) {
			throw new SQLException("SQLException, id=" + id);
		} else if (id == 3) {
			throw new IOException("IOException, id=" + id);
		}
		studentService.insertStudent(new Student(25, "Kumar"));
		return "index";
	}

	@ExceptionHandler(Exception.class)
	public String handleException(HttpRequestHandler request,
			Exception exception) {
		return "error";
	}

}
