package com.yencheng.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yencheng.entity.Dept;
import com.yencheng.repository.DeptRepository;

@Service
public class DeptService {
	
	@Resource
	DeptRepository deptRepository;

	//獲取全部
		public List<Dept> findAll(){
			return deptRepository.findAll();
		}
		//獲取單個
		public Dept findById(Integer id) {
			return deptRepository.findOne(id);
		}
		//新增
		public Dept save(Dept dept) {
//			System.out.println(employee.getId() == null);
			if(dept.getDept_no() != null) {
				Dept tmpDept = deptRepository.findOne(dept.getDept_no());
				if(tmpDept != null) {
					return null;
				}
			}		
			return deptRepository.save(dept);
		}
		//修改
		public Dept update(Dept dept) {
			Dept tmpDept = deptRepository.findOne(dept.getDept_no());
			if(tmpDept == null) {
				return null;
			}
			
			tmpDept.setDeptName(dept.getDeptName());
			return deptRepository.save(tmpDept);
		}
		
		//刪除
		public Integer delete(Integer id) {
			Dept tmpDept = deptRepository.findOne(id);
			if(tmpDept == null) {
				return -1;
			}else {
				deptRepository.delete(id);
				return 0;
			}		
		}
}
