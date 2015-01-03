package com.bin.mybatis.integratespring.mapper;

import java.util.List;

import com.bin.mybatis.integratespring.bean.User;

public interface UserMapper {
	void save(User user);
	void update(User user);
	void delete(int id);
	User findById(int id);
	List<User> findAll();
}
