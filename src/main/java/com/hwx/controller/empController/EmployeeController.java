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
 * 处理员工请求
 * 
 */

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/*
	 * 想要@ResponseBody正常工作，就要导入jackson包,
	 * 
	 */
	@RequestMapping("/emps")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Msg getEmpWidthJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {

		System.out.println(pn);
		// 引入PageHelper分页插件
		// 查询址前只需要调用 传入页面以及每页的大小
		PageHelper.startPage(pn, 10);

		// startPage后面紧跟的这个查询就是分页查询
		List<Employee> emps = employeeService.getAll();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		// 使用PageInfo包装查询后的结果，只需要将pageInfo交给页面 封装了详细的分页信息 连续显示的页数
		PageInfo page = new PageInfo(emps, 5);

		return Msg.success().add("info", page);
	}

	/*
	 * 查询员工数据
	 */

	/*
	 * // @RequestMapping("/emps") public String getEmps(@RequestParam(value = "pn",
	 * defaultValue = "1") Integer pn, Model model) {
	 * 
	 * // 引入PageHelper分页插件 // 查询址前只需要调用 传入页面以及每页的大小 PageHelper.startPage(pn, 10);
	 * 
	 * // startPage后面紧跟的这个查询就是分页查询 List<Employee> emps = employeeService.getAll();
	 * 
	 * // 使用PageInfo包装查询后的结果，只需要将pageInfo交给页面 封装了详细的分页信息 连续显示的页数 PageInfo page = new
	 * PageInfo(emps, 5);
	 * 
	 * model.addAttribute("pageInfo", page);
	 * 
	 * return "list"; }
	 */

}
