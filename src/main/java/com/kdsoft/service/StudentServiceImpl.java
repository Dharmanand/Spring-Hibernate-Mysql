package com.kdsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kdsoft.dao.StudentDao;
import com.kdsoft.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Override
	@Transactional
	public void insertStudent(Student student) {

		studentDao.insertStudent(student);

	}

}
