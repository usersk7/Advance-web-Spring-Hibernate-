/**
 * 
 */
package com.smita.student_project.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smita.student_project.exception.CustomException;
import com.smita.student_project.student.model.Student;
import com.smita.student_project.student.service.IStudentService;

/**
 * @author Smita B Kumar
 *
 */
@Controller
public class StudentController {
	@Autowired
	private IStudentService studentService;
	@RequestMapping("/")
	public String showIndexPage(Model model) {
		model.addAttribute("title", 
				"Welcome to My Spring Hibernate MVC Application");
		return new String("index");//viewName
	}
	
	@RequestMapping("/students")
	public String showStudentList(Model model) {
		Student student = new Student();
		List<Student> studentList = studentService.getStudentList();
		//call the service to get the list of user
		model.addAttribute("student", student);
		model.addAttribute("studentList", studentList);
		return new String("studentPage");//viewName
	}
	// For add and update student both
		@RequestMapping(value = "/addStudent", 
				method = RequestMethod.POST)
		public String addStudent(
				@ModelAttribute("student") 
				@Valid Student p, 
				BindingResult result, 
				Model model) {
			if (!result.hasErrors()) {
				if (p.getStudentId() == null) {
					// new student, add it
					this.studentService.addStudent(p);
				} else {
					// existing student, call update
					this.studentService.updateStudent(p);
				}
				return "redirect:/students";
			}
			model.addAttribute("listStudents", 
					this.studentService.getStudentList());
			return "studentPage";

		}

		@RequestMapping("/removeStudent/{studentId}")
		@ExceptionHandler({ CustomException.class ,NoSuchMethodException.class})
		public String removeStudent(@PathVariable("studentId") int studentId) throws CustomException {		
			this.studentService.removeStudent(studentId);
			return "redirect:/students";
			//when we want to send request from one method of controller
			//to another method of controller
			//use redirect:/requestMappingPath
		}

		@RequestMapping("/editStudent/{studentId}")
		public String showEditStudentPage(
				@PathVariable("studentId") int studentId, Model model) {
			Student studentObj = 
					this.studentService.getStudentById(studentId);
			model.addAttribute("student", studentObj);
			List<Student> studentListObj =
					this.studentService.getStudentList();
			model.addAttribute("listStudents", studentListObj);
			return "studentPage";// view name
		}

		@RequestMapping("/showErrorPage/error")
		public ModelAndView exception(Exception e) {

			ModelAndView mav = new ModelAndView("error");// view name
			mav.addObject("exName", e.getClass().getSimpleName());// model for ex name
			mav.addObject("exMessage", e.getMessage());// model for ex msg
			return mav;
		}
}
