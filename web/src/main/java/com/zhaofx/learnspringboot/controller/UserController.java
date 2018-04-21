/** 
 * Project Name:learn-spring-boot 
 * File Name:UserController.java 
 * Package Name:com.zhaofx.learnspringboot 
 * Date:2018年4月20日下午8:35:28 
 * Copyright (c) 2018, zhaofx5@qq.com All Rights Reserved. 
 * 
*/

package com.zhaofx.learnspringboot.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhaofx.learnspringboot.model.User;
import com.zhaofx.learnspringboot.repository.UserRepository;

/**
 * ClassName:UserController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年4月20日 下午8:35:28 <br/>
 * 
 * @author zhaofengxiang
 * @version
 * @since JDK 1.8
 * @see
 */
@RestController
public class UserController {

	private UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping("/user/save")
	public User save(@RequestParam String userName) {
		User user = new User();
		user.setName(userName);
		userRepository.save(user);
		return user;
	}

	@RequestMapping("/user/findall")
	public Collection<User> findAll() {
		return userRepository.findAll();
	}

}
