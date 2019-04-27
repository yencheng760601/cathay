package com.yencheng.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Dept {

	public Dept() {}
	public Dept(Integer dept_no, String deptName) {
		super();
		this.dept_no = dept_no;
		this.deptName = deptName;
	}
	@Id
	@GeneratedValue
	@Column(name="dept_no")
	private Integer dept_no;
	@Column(name="dept_name")
	private String deptName;
//	@OneToOne(mappedBy = "dept_no") 
//	private Employee employee;
	
	
	public Integer getDept_no() {
		return dept_no;
	}
	public void setDept_no(Integer dept_no) {
		this.dept_no = dept_no;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
//	public Employee getEmployee() {
//		return employee;
//	}
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
	@Override
	public String toString() {
		return "Dept [dept_no=" + dept_no + ", deptName=" + deptName + "]";
	}
	
	
	
}
