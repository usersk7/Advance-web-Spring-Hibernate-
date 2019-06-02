/**
 * 
 */
package com.smita.student_project.student.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smita.student_project.student.model.Student;

/**
 * @author Smita B Kumar
 *
 */
@Repository
public class StudentDao implements IStudentDao {
	
	private SessionFactory sessionFactory;
	private static final Logger logger = 			
			LoggerFactory.getLogger(StudentDao.class);

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println("Session Factory : "+sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Student addStudent(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(student);
		logger.info("Student saved successfully, Student Details="
		+ student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		Session session = 
				this.sessionFactory
				.getCurrentSession();
		session.update(student);
		logger.info("Student updated successfully, "
				+ "Student Details=" + student);
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentList() {
		Session session = this.sessionFactory.openSession();
		List<Student> personsList = session.createQuery("from Student").list();
		for (Student p : personsList) {
			logger.info("Student List::" + p);
		}
		return personsList;
	}

	@Override
	public Student getStudentById(int studentId) {
		Session session = this.sessionFactory.getCurrentSession();
		Student p = (Student) session.load(Student.class, new Integer(studentId));
		logger.info("Student loaded successfully, Student details=" + p);
		return p;
	}

	@Override
	public Student removeStudent(int studentId) {
		Session session = this.sessionFactory.getCurrentSession();
		Student student = 
		(Student) session.load(Student.class, new Integer(studentId));
		if (null != student) {
			session.delete(student);
		}else {
			logger.error
			("Student NOT deleted, with student Id=" +studentId);
		}
		logger.info("Student deleted successfully, student details=" + student);
		return student;
	}


}
