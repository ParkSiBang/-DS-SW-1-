package com.shinhan.myapp.emp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

//Data Source(DB����)==>SqlSessionFactory(DB,Mapper)==>SqlSession���� 
//    ==> DAO ==>Service ==>Controller

@Slf4j
@Repository  
public class EmpDAOMybatis implements EmpDAOInterface{

	@Autowired
	SqlSession sqlSession;

	String namespace = "com.shinhan.emp.";
	
	 
	//return�� = sqlSession.selectOne("namespace�� mapper�� id", �Ķ����)
	//return�� = sqlSession.selectList("")
	//return�� = sqlSession.selectMap("")
	
	public List<EmpDTO> selectByArray(List<Integer> deptArr) {
		List<EmpDTO> emplist  = sqlSession.selectList(namespace + "selectByArray", deptArr);
		log.info("�Ķ����(list,array):" + emplist.size());
		return emplist;
	}
	
	
	
	
	public List<Map<String, Object>> selectJoin3(String jobid) {
		List<Map<String, Object>> emplist  = 
				sqlSession.selectList(namespace + "selectJoin2",jobid);
		log.info("mybatis�̿�(MAP):" + emplist.size() + "��" );
		return emplist;
	}
	
	
	public Map<String, Object> selectJoin2(String jobid) {
		
		return null;
	}

	public List<JobDTO> selectAllJob() {
		List<JobDTO> joblist  = 
				sqlSession.selectList(namespace + "selectAllJob");
		log.info("mybatis�̿�(JOB):" + joblist.size() + "��" );
		return joblist;
	}
    //Employees, Departments, Locations, Countries , Jobs 
	public List<EmpJoinDTO> selectJoin(String jobid) {
		List<EmpJoinDTO> emplist  = 
				sqlSession.selectList(namespace + "selectJoin",jobid);
		log.info("mybatis�̿�:" + emplist.size() + "��" );
		return emplist;
	}

	public List<EmpDTO> selectByDept(int dept_id) {
		List<EmpDTO> emplist  = 
				sqlSession.selectList(namespace + "selectByDept",dept_id);
		log.info("mybatis�̿�:" + emplist.size() + "��" );
		return emplist;
	}

	public List<EmpDTO> selectByJob(String job_id) {
		List<EmpDTO> emplist  = 
				sqlSession.selectList(namespace + "selectByJob",job_id);
		log.info("mybatis�̿�:" + emplist.size() + "��" );
		return emplist;
	}

	public List<EmpDTO> selectBySalary(double salary) {
		List<EmpDTO> emplist  = 
				sqlSession.selectList(namespace + "selectBySalary",salary);
		log.info("mybatis�̿�:" + emplist.size() + "��" );
		return emplist;
	}

	public List<EmpDTO> selectByCondition(Map<String, Object> map) {
		List<EmpDTO> emplist  = 
				sqlSession.selectList(namespace + "selectByCondition",map);
		log.info("!!!!!!mybatis�̿�:" + emplist.size() + "��" );
		return emplist;
	}

	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist  = sqlSession.selectList(namespace + "selectAll");
		log.info("mybatis�̿�:" + emplist.size() + "��" );
		return emplist;
	}

	public EmpDTO selectById(int empid) {
		EmpDTO emp  = sqlSession.selectOne(namespace + "selectById", empid);
		System.out.println("------------------------------------");
		log.info("mybatis�̿�:" + emp.toString() );
		return emp;
	}

	public int insert(EmpDTO emp) {
		//emp.setFirst_name(null);
		//emp.setPhone_number(null);
		int result = sqlSession.insert(namespace + "insert", emp);
		log.info("mybatis�̿�:" + result + "�� �Է�" );
		return result;
	}

	public int update(EmpDTO emp) {
		log.info("������emp:" + emp.toString());
		int result = sqlSession.update(namespace + "update", emp);
		log.info("mybatis�̿�:" + result + "�� ����" );
		return result;
	}

	public int delete(int empid) {
		int result = sqlSession.delete(namespace + "delete", empid);
		log.info("mybatis�̿�:" + result + "�� ����" );
		return result;
	}

}





