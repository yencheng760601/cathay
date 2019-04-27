package com.yencheng.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yencheng.entity.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept,Integer>{

	/**
	 * 查DB有無此部門名稱
	 * @param deptName
	 * @return
	 */
	List<Dept> findByDeptName(String deptName);
}
