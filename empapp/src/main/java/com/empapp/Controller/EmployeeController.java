package com.empapp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empapp.Dto.EmployeeDto;
import com.empapp.Entity.Employee;
import com.empapp.Repository.EmployeeRepository;
import com.empapp.Service.EmailService;
import com.empapp.Service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;//Create object through dependency-Injection
	
	@Autowired
	private EmailService emailService;
	//http://localhost:8080/viewAddEmployee
	@RequestMapping("/viewAddEmployee")  //@Webservlet
	public String viewAddEmployeePage() {
		return "add_employee";  //RequestDispatcher
		
	}
	
	//We put the data through Entity class
	/*@RequestMapping("/add_employee")
	public String addEmployee(Employee emp,ModelMap map) {
		
		employeeService.addEmployee(emp);
		map.addAttribute("msg","Record is Saved!!");
		return "add_employee";
	}*/
	
	//we put the data one by one
	/*@RequestMapping("add_employee")
	public String addEmployee(@RequestParam String name,
			@RequestParam String email,
			@RequestParam String phnumber,
			@RequestParam int salary,ModelMap map) {
		Employee emp= new Employee();
		emp.setName(name);
		emp.setEmail(email);
		emp.setPhnumber(phnumber);
		emp.setSalary(salary);
		employeeService.addEmployee(emp);
		map.addAttribute("msg","Record is saved!!");
		return "add_employee";
		
	}*/
	
	//we put the data through Dto-class
	@RequestMapping("/add_employee")
	public String addEmployee(EmployeeDto empDto,ModelMap map) {
		Employee emp= new Employee();
		//emp.setId(empDto.getId());
		emp.setName(empDto.getName());
		emp.setEmail(empDto.getEmail());
		emp.setPhnumber(empDto.getPhnumber());
		emp.setSalary(empDto.getSalary());
		employeeService.addEmployee(emp);
		//called sendEmail() method of Service-Layer to send a welcome email
		emailService.sendEmail(empDto.getEmail(),"WelcomeMessage","Your Record is Sucessfully Added in our Website!!");
		map.addAttribute("msg","Record is saved!!");
		return "add_employee";
		
	}
	
	@RequestMapping("/list_employee")
	public String listEmployees(ModelMap map) {
		List<Employee> allEmployees = employeeService.getAllEmployees();		
		map.addAttribute("allEmployees",allEmployees);
		return "list_employee";
	}
	
	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam ("id") long id,ModelMap map) {
		employeeService.deleteEmployeeById(id);
		List<Employee> allEmployees = employeeService.getAllEmployees();		
		map.addAttribute("allEmployees",allEmployees);
		return "list_employee";
		
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam ("id") long id,ModelMap map) {
		
		Optional<Employee> employeeById = employeeService.findEmployeeById(id);
		
		Employee emp = employeeById.get();
		System.out.println(emp);
		//List<Employee> allEmployees = employeeService.getAllEmployees();		
		map.addAttribute("emp",emp);
		
		return "update_employee";
		
	}
	
	@RequestMapping("/update_employee")
	public String updateEmployee(EmployeeDto dto, ModelMap map) {
		Employee emp = new Employee();
		
		emp.setId(dto.getId());
		emp.setName(dto.getName());
		emp.setEmail(dto.getEmail());
		emp.setPhnumber(dto.getPhnumber());
		emp.setSalary(dto.getSalary());
		
		employeeService.updateEmployee(emp);
		
		List<Employee> allEmployees = employeeService.getAllEmployees();		
		map.addAttribute("allEmployees",allEmployees);
		map.addAttribute("msg","Record is Updated!!");
		return "list_employee";
	}
	
}
