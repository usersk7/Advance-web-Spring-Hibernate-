package com.cdac.mvc.person.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.mvc.exception.CustomException;
import com.cdac.mvc.person.model.Person;
import com.cdac.mvc.persons.service.IPersonService;

@Controller
public class PersonController {
	private IPersonService personService;

	@Autowired
	@Qualifier(value = "personService")
	public void setPersonService(IPersonService ps) {
		this.personService = ps;
	}
//Controller Level Exception
	@ExceptionHandler(CustomException.class)
	public ModelAndView handlePersonNotFoundException(CustomException ex) {
		Map<String, CustomException> model = new HashMap<String, CustomException>();
		model.put("CustomException", ex);
		return new ModelAndView("error", model);

	}
	@ExceptionHandler(NoSuchBeanDefinitionException.class)
	public ModelAndView handleBeanException(NoSuchBeanDefinitionException ex) {
		Map<String, NoSuchBeanDefinitionException> model = 
				new HashMap<String, NoSuchBeanDefinitionException>();
		model.put("NoSuchBeanDefinitionException", ex);
		return new ModelAndView("error", model);

	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		Map<String, Exception> model = new HashMap<String, Exception>();
		model.put("Exception", ex);
		return new ModelAndView("error", model);

	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());// model
		model.addAttribute("listPersons", 
				this.personService.listPersons());
		return "person";// view name
	}

	// For add and update person both
	@RequestMapping(value = "/person/add", 
			method = RequestMethod.POST)
	public String addPerson(
			@ModelAttribute("person") 
			@Valid Person p, 
			BindingResult result, 
			Model model) {
		if (!result.hasErrors()) {
			if (p.getPersonId() == null) {
				// new person, add it
				this.personService.addPerson(p);
			} else {
				// existing person, call update
				this.personService.updatePerson(p);
			}
			return "redirect:/persons";
		}
		model.addAttribute("listPersons", 
				this.personService.listPersons());
		return "person";

	}

	@RequestMapping("/removePerson/{personId}")
	@ExceptionHandler({ CustomException.class ,NoSuchMethodException.class})
	public String removePerson(@PathVariable("personId") int personId) throws CustomException {		
		this.personService.removePerson(personId);
		return "redirect:/persons";
		//when we want to send request from one method of controller
		//to another method of controller
		//use redirect:/requestMappingPath
	}

	@RequestMapping("/editPerson/{personId}")
	public String showEditPersonPage(
			@PathVariable("personId") int personId, Model model) {
		Person personObj = 
				this.personService.getPersonById(personId);
		model.addAttribute("person", personObj);
		List<Person> personListObj =
				this.personService.listPersons();
		model.addAttribute("listPersons", personListObj);
		return "person";// view name
	}

	@RequestMapping("/showErrorPage/error")
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e) {

		ModelAndView mav = new ModelAndView("error");// view name
		mav.addObject("exName", e.getClass().getSimpleName());// model for ex name
		mav.addObject("exMessage", e.getMessage());// model for ex msg
		return mav;
	}
}
