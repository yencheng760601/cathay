package com.yencheng.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="employee")
public class Employee {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="sex")
	private Integer sex;
	@Column(name="mobile_phone_no")
	private String mobile_phone_no;
	@Column(name="address")
	private String address;
	@Column(name="age")
	private Integer age;
	@Column(name="create_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")//註解是指定資料庫中這個欄位的數據類型
	@Temporal(TemporalType.DATE)
	private Date create_date;
	@Column(name="last_update_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date last_update_date;
	@Column(name="dept_no")
	private Integer dept_no;
	@OneToOne
//	@JoinColumn(name = "dept_no", referencedColumnName = "dept_no")
	@JoinColumn(name = "dept_no", insertable = false, updatable = false)
	private Dept dept;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getMobile_phone_no() {
		return mobile_phone_no;
	}
	public void setMobile_phone_no(String mobile_phone_no) {
		this.mobile_phone_no = mobile_phone_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getLast_update_date() {
		return last_update_date;
	}
	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}
	public Integer getDept_no() {
		return dept_no;
	}
	public void setDept_no(Integer dept_no) {
		this.dept_no = dept_no;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sex=" + sex + ", mobile_phone_no=" + mobile_phone_no
				+ ", address=" + address + ", age=" + age + ", create_date=" + create_date
				+ ", last_update_date=" + last_update_date + ", dept=" + dept + "]";
	}
	
	
	
	
}
