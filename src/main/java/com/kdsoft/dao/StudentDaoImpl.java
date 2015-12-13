package com.kdsoft.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdsoft.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertStudent(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}
}
