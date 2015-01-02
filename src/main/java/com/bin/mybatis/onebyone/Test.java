package com.bin.mybatis.onebyone;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bin.mybatis.bean.Classes;
import com.bin.mybatis.utils.MybatisUtils;

public class Test {
	
	public static void main(String[] args) {
		SqlSessionFactory factory = MybatisUtils.getFactory() ;
		SqlSession session = factory.openSession() ;
		
		String statement = "com.bin.mybatis.onebyone.ClassMapper.getClass" ;
		String statement1 = "com.bin.mybatis.onebyone.ClassMapper.getClass2" ;
		Classes c = session.selectOne(statement, 2) ;
		Classes c1 = session.selectOne(statement1, 2) ;
		System.out.println(c);
		System.out.println(c1);
		
		session.commit();
		session.close();
		
		
	}

}
