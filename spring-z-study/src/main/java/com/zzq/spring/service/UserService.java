package com.zzq.spring.service;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author zzq
 * @date 2023/7/30
 */
@Component
public class UserService implements UserInterface,BeanNameAware {

	private String beanName;

	@Override
    public void setBeanName(String name) {
        this.beanName = name;
    }


	public void test() {
        System.out.println("BeanNameAware: " + beanName);
    }
}
