package com.yencheng.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yencheng.entity.Dept;
import com.yencheng.service.DeptService;

@RestController
@RequestMapping("/dept")
public class DeptController {

	@Resource
	private DeptService deptService;

	// get-查詢全部dept
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Dept> getAll() {
		return deptService.findAll();
	}

	// post-新增dept
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Dept dept) {
		System.out.println("get parameter dept = " + dept.toString());
		if (dept.getDept_no() != null) {
			System.out.println("id自動生成，不需填寫");
		}
		dept = deptService.save(dept);
		if (dept == null) {
			return "failed: dept id already exist";
		} else {
			System.out.println("after save to DB : " + dept.toString());
			return "success add dept : " + dept.getDept_no() + " , " + dept.getDeptName();
		}
	}
	
	//put-修改dept
		@RequestMapping(value= {"/{dept_no}"},method=RequestMethod.PUT)
		public String update(@PathVariable Integer dept_no,Dept dept) {
			System.out.println("get parameter deptId = " + dept_no);
			System.out.println("get Parameter dept = " + dept.toString());
			if(dept_no.intValue() != dept.getDept_no().intValue()) return "Error : 請求參數id值不匹配";
			dept = deptService.update(dept);
			if(dept == null) {
				return "failed : not found dept_no!";
			}else {
				return "success update dept : " + dept.getDept_no();
			}
		}
		//delete-刪除dept
		@RequestMapping(value= {"/{dept_no}"},method=RequestMethod.DELETE)
		public String delete(@PathVariable Integer dept_no) {
			System.out.println("get parameter id = " + dept_no);
			if(dept_no <= 0)return "Error : 參數錯誤，id不可為負數 : " + dept_no;
			Integer result = deptService.delete(dept_no);
			if(result.intValue()==0) {
				return "success delete employee : " + dept_no ;
			}else {
				return "failed : " + result;
			}
		}

}
