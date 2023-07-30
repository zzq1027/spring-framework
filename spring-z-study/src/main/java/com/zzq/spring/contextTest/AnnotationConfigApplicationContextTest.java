package com.zzq.spring.contextTest;

import com.zzq.spring.AppConfig;
import com.zzq.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zzq
 * @date 2023/7/30
 */
public class AnnotationConfigApplicationContextTest {

    public static void main(String[] args) {

        // 扫描--->创建单例Bean BeanDefinition BeanPostPRocess
     AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	UserService userService = (UserService) context.getBean("userService");
	  userService.test();
    }
}
