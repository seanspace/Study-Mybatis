package com.bin.mybatis.multicondition;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.bin.mybatis.bean.ConditionUser;
import com.bin.mybatis.helloworld.bean.User;
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
		
		String statement = "com.bin.mybatis.multicondition.userMapper.getUser" ;
		ConditionUser parameter = new ConditionUser("%o%",13,18) ;
		List<User> users= session.selectList(statement,parameter) ;
		
		System.out.println(users);
		
		session.commit();
		session.close();
	}
	
	@Test
	public void testNull(){
		String nullStr = null ;
		System.out.println("---" + nullStr);
	}
	

}
