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
 * ����dao�㹤�� ����SpringTestģ��
 * 
 * @ContextConfigurationָ��spring�ļ���λ�� ֱ��AutowriedҪʹ�õ����
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

	// ����DepartmentMapper
	@Test
	public void testMusic() {
//		// 1.����SpringIoc����
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//		// 2.���������ó���
//		ioc.getBean(DepartmentMapper.class);

		System.out.println("���ţ�" + departmentMappert);

//		1. ���뼸������
//		departmentMappert.insertSelective(new Department(null, "���Բ�"));
//		departmentMappert.insertSelective(new Department(null, "��ά��"));
		/*
		 * DepartmentMapper departmentMapper =
		 * sqlSession.getMapper(DepartmentMapper.class); for (int i = 0; i < 100; i++) {
		 * String uid = UUID.randomUUID().toString().substring(0, 5) + i;
		 * departmentMapper.insertSelective(new Department(null, uid));
		 * System.out.print(i + "  "); } System.out.println();
		 * System.out.println("����������");
		 */

//		2. ����Ա����
		System.out.println("Ա����" + employeeMapper);
//		employeeMapper.insertSelective(new Employee(null, "������", "M", "1965554545@qq.com", 2));
//		��������Ա�� 

		/*
		 * EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		 * for (int i = 0; i < 1000; i++) { String uid =
		 * UUID.randomUUID().toString().substring(0, 5) + i; int randMath = (int)
		 * (Math.random() * 100 + 1); employeeMapper.insertSelective(new Employee(null,
		 * uid, "M", uid + "@qq.com", randMath)); System.out.print(i + "  "); }
		 * System.out.println(); System.out.println("����������");
		 */

//		3. ���Բ�ѯ

		System.out.println(employeeMapper.selectByPrimaryKey(50));

	}

}
