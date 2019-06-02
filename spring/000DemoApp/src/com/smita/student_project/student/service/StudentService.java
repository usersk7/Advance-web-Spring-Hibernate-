/**
 * 
 */
package com.smita.student_project.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smita.student_project.student.dao.IStudentDao;
import com.smita.student_project.student.model.Student;

/**
 * @author Smita B Kumar
 *
 */
@Service
public class StudentService implements IStudentService {
	@Autowired
	private IStudentDao studentDao;
	/* (non-Javadoc)
	 * @see com.smita.student_project.student.service.IStudentService#getStudentList()
	 */
	@Override
	@Transactional
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		return studentDao.getStudentList();
	}
	@Override
	@Transactional
	public Student addStudent(Student p) {
		return this.studentDao.addStudent(p);
	}
	@Override
	@Transactional
	public Student updateStudent(Student p) {
		return this.studentDao.updateStudent(p);
	}
	
	@Override
	@Transactional
	public Student getStudentById(int studentId) {
		return this.studentDao.getStudentById(studentId);
	}
	@Override
	@Transactional
	public Student removeStudent(int studentId) {
		return this.studentDao.removeStudent(studentId);
	}
}
