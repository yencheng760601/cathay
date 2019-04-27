package com.yencheng.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.yencheng.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>,JpaSpecificationExecutor<Employee> {

	
	/**
	 * 通過姓名相等查詢
	 * @param name
	 * @return
	 */	
	List<Employee> findByName(String name);
	
	/**
	 * 通過員工編號查詢
	 * @param id
	 * @return
	 */
	List<Employee> findById(Integer id);

	
	

}
