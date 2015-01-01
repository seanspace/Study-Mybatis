package com.bin.mybatis.helloworld;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bin.mybatis.helloworld.bean.User;

public class Test {
	
	public static void main(String[] args) throws IOException {
		String resource = "conf.xml"; 
		//加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource); 
		//构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		//映射sql的标识字符串
		String statement = "com.bin.mybatis.helloworld.userMapper"+".getUser";
		//执行查询返回一个唯一user对象的sql
		User user = session.selectOne(statement, 1);
		User user2 = session.selectOne(statement, 2);
		System.out.println(user);
		System.out.println(user2);
		session.close();
	}

}
