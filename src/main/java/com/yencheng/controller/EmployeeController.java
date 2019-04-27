package com.yencheng.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yencheng.entity.Employee;
import com.yencheng.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Resource
	private EmployeeService employeeService;
	
	//get-查詢全部employee
	@RequestMapping(value="",method=RequestMethod.GET)
	public List<Employee> getAll(){
		return employeeService.findAll();
	}
	//get-查詢單個employee
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public List<Employee> getOne(@PathVariable Integer id) {
		System.out.println("get parameter employeeId = " + id);
		return employeeService.findById(id);
	}
	//get-動態查詢
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public List<Employee> getByName(
			@RequestParam(required=false,defaultValue ="") String name,
			@RequestParam(required=false,defaultValue = "0") Integer id,
			@RequestParam(required=false,defaultValue = "0") Integer age,
			@RequestParam(required=false,defaultValue ="") String deptName) {
		System.out.println("get parameter employeeId = " + name + "," + id + "," + age + "," + deptName);
		System.out.println("name isNull : " + name.equals(""));
		System.out.println("id isNull : " + id);
		
		return employeeService.findByEach(name,id,age,deptName);
	}
	//post-新增employee
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(Employee employee) {
		System.out.println("get parameter Employee = " + employee.toString());
		if(employee.getId()!= null) {
			System.out.println("id自動生成，不需填寫");
		}
		employee = employeeService.save(employee);
		if(employee == null) {
			return "failed: employee id already exist";
		} else {
			System.out.println("after save to DB : " + employee.toString());
			return "success add Employee : " + employee.getId();
		}
	}
	//put-修改employee
	@RequestMapping(value= {"/{employeeId}"},method=RequestMethod.PUT)
	public String update(@PathVariable Integer employeeId,Employee employee) {
		System.out.println("get parameter EmployeeId = " + employeeId);
		System.out.println("get Parameter Employee = " + employee.toString());
		if(employeeId.intValue() != employee.getId().intValue()) return "Error : 請求參數id值不匹配";
		employee = employeeService.update(employee);
		if(employee == null) {
			return "failed : not found employee!";
		}else {
			return "success update employee : " + employee.getId();
		}
	}
	//delete-刪除employee
	@RequestMapping(value= {"/{id}"},method=RequestMethod.DELETE)
	public String delete(@PathVariable Integer id) {
		System.out.println("get parameter id = " + id);
		if(id <= 0)return "Error : 參數錯誤，id不可為負數 : " + id;
		Integer result = employeeService.delete(id);
		if(result.intValue()==0) {
			return "success delete employee : " + id ;
		}else {
			return "failed : " + result;
		}
	}

}
