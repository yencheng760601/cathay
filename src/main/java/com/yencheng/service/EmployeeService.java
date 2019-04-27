package com.yencheng.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yencheng.entity.Dept;
import com.yencheng.entity.Employee;
import com.yencheng.repository.DeptRepository;
import com.yencheng.repository.EmployeeRepository;
import com.yencheng.repository.EmployeeSpecs;

@Service
public class EmployeeService {

	@Resource
	private EmployeeRepository employeeRepository;
	@Resource
	private DeptRepository deptRepository;

	// 獲取全部
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public List<Employee> findByName(String name) {
		return employeeRepository.findByName(name);
	}

	// 獲取單個
	public List<Employee> findById(Integer id) {
		return employeeRepository.findById(id);
	}

	// 動態查詢
	public List<Employee> findByEach(String name, Integer id, Integer age, String deptName) {
		List<Dept> deptList = null;
		Dept dept = null;
		//若部門名稱不為空，則看數據庫有無資料
		if (!deptName.equals("")) {
			deptList = deptRepository.findByDeptName(deptName);
			if (!(deptList.size() == 0)) {
				dept = deptList.get(0);
			} else {
				//資料庫沒資料就跳出
				return null;
			}
		}

		return employeeRepository.findAll(EmployeeSpecs.employeeFrom(id, name, age, dept));
	}

	// 新增
	public Employee save(Employee employee) {
//		System.out.println(employee.getId() == null);
		if (employee.getId() != null) {
			Employee tmpEmployee = employeeRepository.findOne(employee.getId());
			if (tmpEmployee != null) {
				return null;
			}
		}
		return employeeRepository.save(employee);
	}

	// 修改
	public Employee update(Employee employee) {
		Employee tmpEmployee = employeeRepository.findOne(employee.getId());
		if (tmpEmployee == null) {
			return null;
		}
		tmpEmployee.setName(employee.getName());
//		tmpEmployee.setSex(employee.getSex());
		tmpEmployee.setMobile_phone_no(employee.getMobile_phone_no());
		tmpEmployee.setAddress(employee.getAddress());
//		tmpEmployee.setBirth_day(employee.getBirth_day());
//		tmpEmployee.setCreate_date(employee.getCreate_date());
		tmpEmployee.setLast_update_date(employee.getLast_update_date());
		tmpEmployee.setDept_no(employee.getDept_no());

		return employeeRepository.save(tmpEmployee);
	}

	// 刪除
	public Integer delete(Integer id) {
		Employee tmpEmployee = employeeRepository.findOne(id);
		if (tmpEmployee == null) {
			return -1;
		} else {
			employeeRepository.delete(id);
			return 0;
		}
	}

}
