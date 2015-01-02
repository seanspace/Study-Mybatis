package com.bin.mybatis.procedure;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.bin.mybatis.utils.MybatisUtils;

/**
 * 复杂查询条件的使用.
 *
 */
public class Test1 {
	
	@Test
	public void test1() {
		SqlSessionFactory factory = MybatisUtils.getFactory() ;
		SqlSession session = factory.openSession() ;
		
		String statement = "com.bin.mybatis.procedure.procedureMapper.getUserCount" ;
		Map<String, Integer> parameterMap = new HashMap<String, Integer>() ;
		parameterMap.put("sexId", 2) ;
		parameterMap.put("userCount", -1) ;
		
		session.selectOne(statement, parameterMap) ;
		
		Integer result = parameterMap.get("userCount") ;
		
		System.out.println(result);
		
		session.commit();
		session.close();
	}
	
	

}
