package com.hwx.controller.empController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwx.pojo.Employee;
import com.hwx.pojo.msg.Msg;
import com.hwx.service.empService.EmployeeService;

/*
 * ����Ա������
 * 
 */

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/*
	 * ��Ҫ@ResponseBody������������Ҫ����jackson��,
	 * 
	 */
	@RequestMapping("/emps")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Msg getEmpWidthJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {

		System.out.println(pn);
		// ����PageHelper��ҳ���
		// ��ѯַǰֻ��Ҫ���� ����ҳ���Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);

		// startPage��������������ѯ���Ƿ�ҳ��ѯ
		List<Employee> emps = employeeService.getAll();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		// ʹ��PageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ�� ��װ����ϸ�ķ�ҳ��Ϣ ������ʾ��ҳ��
		PageInfo page = new PageInfo(emps, 5);

		return Msg.success().add("info", page);
	}

	/*
	 * ��ѯԱ������
	 */

	/*
	 * // @RequestMapping("/emps") public String getEmps(@RequestParam(value = "pn",
	 * defaultValue = "1") Integer pn, Model model) {
	 * 
	 * // ����PageHelper��ҳ��� // ��ѯַǰֻ��Ҫ���� ����ҳ���Լ�ÿҳ�Ĵ�С PageHelper.startPage(pn, 10);
	 * 
	 * // startPage��������������ѯ���Ƿ�ҳ��ѯ List<Employee> emps = employeeService.getAll();
	 * 
	 * // ʹ��PageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ�� ��װ����ϸ�ķ�ҳ��Ϣ ������ʾ��ҳ�� PageInfo page = new
	 * PageInfo(emps, 5);
	 * 
	 * model.addAttribute("pageInfo", page);
	 * 
	 * return "list"; }
	 */

}
