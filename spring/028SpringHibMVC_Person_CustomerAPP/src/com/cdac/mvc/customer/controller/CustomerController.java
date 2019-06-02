package com.cdac.mvc.customer.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.cdac.mvc.customer.model.Customer;
import com.cdac.mvc.customers.service.ICustomerService;
import com.cdac.mvc.exception.CustomException;
/**
 * @author Smita
 *
 */
//step 1: annotate the class with @Controller
@Controller
public class CustomerController {
	/*Step 2 : create IService inteface private var **/	
	@Autowired
	@Qualifier("customerService")
	private ICustomerService customerService;
	/*Step 4 : generate customerService getter/setter * */	
	/*Step 5 : annotate customerService setter with
	 * @Autowired
	 * */
	
	@RequestMapping("/")
	public String showIndexPage(Model model) {
		model.addAttribute("title", 
	"Welcome to My Spring Hibernate MVC Application");
		return "index";
	}
	
	@RequestMapping(value = "/customerPage", 
			method = RequestMethod.GET)
	public String listCustomer(Model model) {
		model.addAttribute("customer", new Customer());// model
		model.addAttribute("listCustomers", 
				this.customerService.listCustomer());
		return "customerPage";// view name
	}
	@RequestMapping(value="/customer/add",
			method = RequestMethod.POST)
	@ExceptionHandler({ CustomException.class })
	public String addCustomer(
			@ModelAttribute(value="customer")
			@Valid Customer customer,
			BindingResult results,
			Model model
			) {
		String viewName="redirect:/customerPage";
		//redirection to the controller
		if(!results.hasErrors()) {
			if(customer.getCustomerId()==null) {
				//add customer to db
				customerService.addCustomer(customer);
			}else {
				//editCustomer or update customer
				customerService.updateCustomer(customer);
			}
			viewName="redirect:/customerPage";
		}
		model.addAttribute("listCustomers", 
				this.customerService.listCustomer());
		viewName= "customerPage";
		return viewName;
	}//end of addCustomer
	@RequestMapping("/editCustomer/{customerId}")
	public String showEditCustomerPage(
	@PathVariable("customerId") int customerId, 
	Model model) {
		Customer customerObj = 
	this.customerService.getCustomerById(customerId);
		model.addAttribute("customer", customerObj);
		List<Customer> customerListObj =
				this.customerService.listCustomer();
		model.addAttribute("listCustomers", 
				customerListObj);
		return "customerPage";// view name
	}
	@RequestMapping("/removeCustomer/{customerId}")
	@ExceptionHandler({ CustomException.class })
	public String removePerson(@PathVariable
			("customerId")
	int customerId) throws CustomException {
		if (customerId > 0) {
			throw new CustomException(
					"Given customerId Not Found","404");
		} else {
		this.customerService.removeCustomer(customerId);
		}
		return "redirect:/customerPage";
	}
	@ExceptionHandler(CustomException.class)
	public ModelAndView handleNotFoundException(CustomException ex) {
		Map<String, CustomException> model = new HashMap<String, CustomException>();
		model.put("exception", ex);
		return new ModelAndView("error", model);

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		Map<String, Exception> model = new HashMap<String, Exception>();
		model.put("exception", ex);
		return new ModelAndView("error", model);

	}
}
