package com.yencheng.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.yencheng.entity.Dept;
import com.yencheng.entity.Employee;
import com.yencheng.entity.Employee_;

public class EmployeeSpecs {

	public static Specification<Employee> employeeFrom(Integer id,String name,Integer age,Dept dept){
		return new Specification<Employee>() {
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate p1 = null;
				if(id != 0) {
					Predicate p2 = cb.equal(root.get(Employee_.id),id);
					if(p1 != null) {
						p1 = cb.and(p1,p2);
					} else {
						p1 = p2;
					}				
				}
				if(age!=0) {
					Predicate p2 = cb.equal(root.get(Employee_.age), age);
					if(p1 != null) {
						p1 = cb.and(p1,p2);
					} else {
						p1 = p2;
					}
				}
				if(!name.equals("")) {
					Predicate p2 = cb.equal(root.get(Employee_.name), name);
					if(p1 != null) {
						p1 = cb.and(p1,p2);
					} else {
						p1 = p2;
					}
				}
				if(dept!=null) {
					Predicate p2 = cb.equal(root.get(Employee_.dept), dept);
					if(p1 != null) {
						p1 = cb.and(p1,p2);
					} else {
						p1 = p2;
					}
				}
				return p1;				
			}			
		};
	}
}
