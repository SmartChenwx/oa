package com.user.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;
import com.user.entity.User;
import com.user.service.UserService;

@Controller
public class UserController {
	
	/*@Autowired
	private HttpServletResponse response;*/
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private SqlSession sqlsession;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userReg.action")
	public String userReg(User user){
		Map<String,Object> map = new HashMap<String, Object>();
		//用户电话
		map.put("phone_mobile", user.getPhone_mobile());
		//用户登录密码
		map.put("login_password", user.getLogin_password());
		//校验
		if(StringUtils.isNullOrEmpty(user.getPhone_mobile()) || StringUtils.isNullOrEmpty(user.getLogin_password())){
			return "index.jsp";
		}
		//生成唯一识别码--用户编码
		String s = UUID.randomUUID().toString(); 
		String user_code =  s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
		map.put("user_code", user_code);
		//用户注册时间
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("register_time", df.format(date));
		//保存数据
		sqlsession.insert("com.user.dao.addUser",map);
		request.setAttribute("phone_mobile", user.getPhone_mobile());
		request.setAttribute("login_password", user.getLogin_password());
		return "WEB-INF/pages/user/register_success.jsp";
	}
	
	@RequestMapping("/login.action")
	public String login(String phone_mobile,String login_password){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("phone_mobile",phone_mobile);
		map.put("login_password",login_password);
		User user = userService.loginUser(map);
		if(user!=null){
			request.setAttribute("user", user);
			return "WEB-INF/pages/user/sys_index.jsp";
		}else{
			
		}
		return "";
	}
	
	@RequestMapping("/getUserAll.action")
	@ResponseBody
	public List<User> getUserAll(Map<String,Object> map,Model model){
		List<User> list = userService.getAllUser(map);
		model.addAttribute(list);
		return list;
	}
}
