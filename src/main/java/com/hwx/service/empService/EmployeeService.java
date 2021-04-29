package com.hwx.service.empService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwx.dao.EmployeeMapper;
import com.hwx.pojo.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;

	/*
	 * 查询所有员工
	 */
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeMapper.selectByExampleWithDept(null);
	}

}
