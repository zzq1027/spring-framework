package com.zzq.spring.contextTest;

import com.zzq.spring.service.UserService;
import org.springframework.aop.framework.ProxyFactory;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.annotation.Nullable;


/**
 * @author zzq
 * @date 2023/8/1
 */
public class AspectTest {

	public static void main(String[] args) {

		UserService userService1 = new UserService();
				ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(userService1);
		proxyFactory.addAdvice(new MethodInterceptor() {
			@Nullable
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("切面逻辑 before...");
				Object result = invocation.proceed();
//				Object result = invocation.getMethod().invoke(invocation.getThis(), invocation.getArguments());
				System.out.println("切面逻辑 after...");
				return result;
			}
		});
		UserService userService2  = (UserService) proxyFactory.getProxy();
		userService2.test();
	}
}
