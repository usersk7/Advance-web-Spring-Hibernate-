/**
 * 
 */
package com.smita.student_project.student.dao;

import java.util.List;

import com.smita.student_project.exception.CustomException;
import com.smita.student_project.student.model.Student;

/**
 * @author Smita B Kumar
 *
 */
public interface IStudentDao {
	public Student addStudent(Student student)throws CustomException;//insert
	public List<Student> getStudentList()throws CustomException;;//retrieve/listAll
	public Student updateStudent(Student student)throws CustomException;//update/modify
	public Student removeStudent(int studentId)throws CustomException;//delete/remove
	public Student getStudentById(int studentId)throws CustomException;//search
	
}
