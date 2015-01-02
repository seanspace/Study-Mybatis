package com.bin.mybatis.onetomany;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.bin.mybatis.bean.Classes;
import com.bin.mybatis.utils.MybatisUtils;

public class Test1 {
	
	@Test
	public void test1() {
		SqlSessionFactory factory = MybatisUtils.getFactory() ;
		SqlSession session = factory.openSession() ;
		
		String statement = "com.bin.mybatis.onetomany.ClassMapper.getClass" ;
		Classes c = session.selectOne(statement, 2) ;
		System.out.println(c);
		
		session.commit();
		session.close();
	}
	
	/**
	 * 采用方式二.
	 */
	@Test
	public void test2() {
		SqlSessionFactory factory = MybatisUtils.getFactory() ;
		SqlSession session = factory.openSession() ;
		
		String statement = "com.bin.mybatis.onetomany.ClassMapper.getClass2" ;
		Classes c = session.selectOne(statement, 2) ;
		System.out.println(c);
		
		session.commit();
		session.close();
	}

}
