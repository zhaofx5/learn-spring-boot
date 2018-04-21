/** 
 * Project Name:learn-spring-boot 
 * File Name:UserRepository.java 
 * Package Name:com.zhaofx.learnspringboot.repository 
 * Date:2018年4月20日下午8:28:48 
 * Copyright (c) 2018, zhaofx5@qq.com All Rights Reserved. 
 * 
*/

package com.zhaofx.learnspringboot.repository;
/** 
 * ClassName:UserRepository <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2018年4月20日 下午8:28:48 <br/> 
 * @author   zhaofengxiang 
 * @version   
 * @since    JDK 1.8
 * @see       
 */

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.zhaofx.learnspringboot.model.User;

@Repository
public class UserRepository {

	private final ConcurrentHashMap<Integer, User> concurrentHashMap = new ConcurrentHashMap<>();

	private final static AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

	/**
	 * 
	 * save:(a repository for user). <br/>
	 * 
	 * @author zhaofengxiang
	 * @param user
	 * @return
	 * @since JDK 1.8
	 */
	public void save(User user) {
		Integer id = ATOMIC_INTEGER.getAndIncrement();
		user.setId(id);
		System.out.printf("user name is %s , user is %s \n", user.getId(), user.getName());
		concurrentHashMap.put(id, user);
		System.out.println(concurrentHashMap.size());

	}

	public Collection<User> findAll() {

		return concurrentHashMap.values();
	}

}
