package com.zzq.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zzq
 * @date 2023/8/1
 */
@Aspect
@Component
public class EtherealAspect {

	@Pointcut("execution(public void com.zzq.spring.service.UserService.test())")
	public void a(){

	}

	@Before("a()")
	public void EtherealBefore(JoinPoint joinPoint) {
		System.out.println("EtherealBefore");
	}

}
