package com.yencheng;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yencheng.entity.Employee;
import com.yencheng.repository.EmployeeRepository;
import com.yencheng.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)// 可以自動觸發所有的@Mock註解物件的建立
public class EmployeeServiceTest {

	@InjectMocks
	EmployeeService employeeService;
	
	@Mock
	EmployeeRepository employeeRepository;
	
//	@Rule  // 可以自動觸發所有的@Mock註解物件的建立
//    public MockitoRule mockitoRule = MockitoJUnit.rule();
	
//  @Before // @Test註解的方法執行前執行，觸發所有的@Mock註解物件的建立
//  public void setUp() {
//      MockitoAnnotations.initMocks(this);
//  }
	
	@Test
	public void SimpleTest() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("張延晟");
		employee.setSex(1);
		employee.setMobile_phone_no("0963188143");
		employee.setAddress("中正路");
//		employee.setDept_no(1);
		
		Mockito.when(employeeRepository.findOne(employee.getId())).thenReturn(employee);
		
		org.junit.Assert.assertTrue(employeeService.findById(1).equals(employee));
	}
	
}
