package test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwx.dao.DepartmentMapper;
import com.hwx.dao.EmployeeMapper;
import com.hwx.pojo.Department;
import com.hwx.pojo.Employee;

/**
 * 测试dao层工作 导入SpringTest模块
 * 
 * @ContextConfiguration指定spring文件的位置 直接Autowried要使用的组件
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MapperTest {

	@Autowired
	DepartmentMapper departmentMappert;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;

	// 测试DepartmentMapper
	@Test
	public void testMusic() {
//		// 1.创建SpringIoc容器
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//		// 2.从容器中拿出来
//		ioc.getBean(DepartmentMapper.class);

		System.out.println("部门：" + departmentMappert);

//		1. 插入几个部门
//		departmentMappert.insertSelective(new Department(null, "测试部"));
//		departmentMappert.insertSelective(new Department(null, "运维部"));
		/*
		 * DepartmentMapper departmentMapper =
		 * sqlSession.getMapper(DepartmentMapper.class); for (int i = 0; i < 100; i++) {
		 * String uid = UUID.randomUUID().toString().substring(0, 5) + i;
		 * departmentMapper.insertSelective(new Department(null, uid));
		 * System.out.print(i + "  "); } System.out.println();
		 * System.out.println("批量添加完成");
		 */

//		2. 测试员工表
		System.out.println("员工：" + employeeMapper);
//		employeeMapper.insertSelective(new Employee(null, "郝文秀", "M", "1965554545@qq.com", 2));
//		批量插入员工 

		/*
		 * EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		 * for (int i = 0; i < 1000; i++) { String uid =
		 * UUID.randomUUID().toString().substring(0, 5) + i; int randMath = (int)
		 * (Math.random() * 100 + 1); employeeMapper.insertSelective(new Employee(null,
		 * uid, "M", uid + "@qq.com", randMath)); System.out.print(i + "  "); }
		 * System.out.println(); System.out.println("批量添加完成");
		 */

//		3. 测试查询

		System.out.println(employeeMapper.selectByPrimaryKey(50));

	}

}
