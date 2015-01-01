package com.bin.mybatis.order;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bin.mybatis.bean.Order;
import com.bin.mybatis.utils.MybatisUtils;

public class OrderTest {
	
	/**
	 * 表字段名和bean属性名不一致解决方法.
	 * 方法1.由于bean的属性名和数据库中的属性名不一致,所以需要通过别名实现.
	 * 方法2.resultMap映射.
	 */
	public static void main(String[] args) {
		SqlSessionFactory factory = MybatisUtils.getFactory() ;
		SqlSession session = factory.openSession() ;
		
		String statement = "com.bin.mybatis.order.orderMapper.getOrder" ;
		String statement2 = "com.bin.mybatis.order.orderMapper.getOrder2" ;
		Order order = session.selectOne(statement,1) ;
		Order order2 = session.selectOne(statement2,2) ;
		
		session.commit();
		session.close();
		
		System.out.println(order);
		System.out.println(order2);
	}

}
