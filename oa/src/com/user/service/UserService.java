package com.user.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
/**
 * 用户处理层
 * @author Administrator
 *
 */
@Service
public class UserService {
	@Autowired
	private SqlSession sqlsession;
	
	/**
	 * 用户登录
	 * @param map
	 * @return
	 */
	public User loginUser(Map<String,Object> map){
		User user = sqlsession.selectOne("com.user.dao.loginUser",map);
		return user;
	}
	
	/**
	 * 获取所有用户信息
	 * @param map
	 * @return
	 */
	public List<User> getAllUser(Map<String,Object> map){
		List<User> list = sqlsession.selectList("com.user.dao.allUser",map);
		return list;
	}
}
