package com.bin.mybatis.cache;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.bin.mybatis.bean.CUser;
import com.bin.mybatis.utils.MybatisUtils;

/**
 * 测试缓存
 * 1. 一级缓存(session级别),
 * 		> session.clearCache();// 清除sesion缓存.
 * 		> 执行CUD操作,该作用域下所有 select 中的缓存将被clear
 * 		> session关闭前会先清空缓存.
 * 2. 二级缓存,可以配置成Ehcache
 * 		> 作用范围是Mapper映射文件.<cache></cache>标签开启二级缓存.
 * 		> 二级缓存,需要对应的实体实现Serializable,才能
 */
public class Test1 {
	
	@Test
	public void testLevelOne() {
		SqlSessionFactory factory = MybatisUtils.getFactory() ;
		SqlSession session = factory.openSession() ;
		
		String statement = "com.bin.mybatis.cache.cacheMapper.getUser" ;
		
		CUser user = session.selectOne(statement, 1) ;
		System.out.println(user);
		
		CUser user1 = session.selectOne(statement, 1) ;
		System.out.println(user1);
		
		System.out.println("-----------------------------");
		session.clearCache();// 清除sesion缓存.
		CUser user2 = session.selectOne(statement, 1) ;
		System.out.println(user2);
		
		System.out.println("-----------------------------");
		session.update("com.bin.mybatis.cache.cacheMapper.updateUser", new CUser(1, "Tom", 13)) ;
		CUser user3 = session.selectOne(statement, 1) ;
		System.out.println(user3);
		//Cache Hit Ratio [com.bin.mybatis.cache.cacheMapper]: 0.5
		session.commit();
		session.close();
	}
	
	@Test
	public void testLevelTwo() {
		SqlSessionFactory factory = MybatisUtils.getFactory() ;
		SqlSession session = factory.openSession() ;
		
		String statement = "com.bin.mybatis.cache.cacheMapper.getUser" ;
		
		CUser user = session.selectOne(statement, 1) ;
		System.out.println(user);
		session.commit();
		session.close();
		
		// 本次查询,将采用二级缓存的数据.不查询数据库.
		SqlSession session2 = factory.openSession() ;
		CUser user2 = session2.selectOne(statement, 1) ;
		System.out.println(user2);
		session2.commit();
		session2.close();
	}
	
	

}
