package com.bin.mybatis.crud;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.bin.mybatis.crud.anotation.UserMapper;
import com.bin.mybatis.helloworld.bean.User;
import com.bin.mybatis.utils.MybatisUtils;

public class CRUDTest {
	
	@Test
	public void testAdd(){
		SqlSessionFactory factory = MybatisUtils.getFactory() ;
		// 默认手动提交.
		SqlSession session = factory.openSession() ;
		
		String statement = "com.bin.mybatis.crud.userMapper.addUser" ;
		int insert = session.insert(statement,new User(-1,"KK",23)) ;
		session.commit();
		session.close(); 
		System.out.println(insert);
	}
	
	@Test
	public void testUpdate(){
		SqlSessionFactory factory = MybatisUtils.getFactory() ;
		// 默认手动提交.
		SqlSession session = factory.openSession() ;
		
		String statement = "com.bin.mybatis.crud.userMapper.updateUser" ;
		int up = session.update(statement,new User(5,"KK44",25)) ;
		session.commit();
		session.close(); 
		System.out.println(up);
	}
	
	@Test
	public void testDelete(){
		SqlSessionFactory factory = MybatisUtils.getFactory() ;
		// 默认手动提交.
		SqlSession session = factory.openSession() ;
		
		String statement = "com.bin.mybatis.crud.userMapper.deleteUser" ;
		int de = session.delete(statement,5) ;
		session.commit();
		session.close(); 
		System.out.println(de);
	}
	
	@Test
	public void testGetUser(){
		SqlSessionFactory factory = MybatisUtils.getFactory() ;
		// 默认手动提交.
		SqlSession session = factory.openSession() ;
		
		String statement = "com.bin.mybatis.crud.userMapper.getUser" ;
		User user = session.selectOne(statement,1) ;
		session.commit();
		session.close(); 
		System.out.println(user);
	}
	
	
	@Test
	public void testGetAll(){
		SqlSessionFactory factory = MybatisUtils.getFactory() ;
		// 默认手动提交.
		SqlSession session = factory.openSession() ;
		
		String statement = "com.bin.mybatis.crud.userMapper.getAllUsers" ;
		List<User> users = session.selectList(statement) ;
		
		session.commit();
		session.close(); 
		System.out.println(users);
	}
	
	@Test
	public void testAdd2(){

		SqlSessionFactory factory = MybatisUtils.getFactory() ;
		// 默认手动提交.
		SqlSession session = factory.openSession() ;
		UserMapper userMapper = session.getMapper(UserMapper.class) ;
		
		int len = userMapper.addUser(new User(-1,"TT",45)) ;
		
		session.commit();
		session.close(); 
		System.out.println(len);
		
	}
	
}
