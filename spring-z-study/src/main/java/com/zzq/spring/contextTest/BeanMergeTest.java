package com.zzq.spring.contextTest;

import com.zzq.spring.pojo.ChildBean;
import com.zzq.spring.pojo.FatherBean;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring中BeanDefinition的合并getMergedLocalBeanDefinition测试
 * 1、如果不存在parentName，即不需要被合并，直接将bd转为RootBeanDefinition 返回即可
 * 2、如果存在parentName
 * 		先根据parentName 找到父bd，若实体存在多级继承关系，则需要递归地查找。
 * 		将父bd转为RootBeanDefinition，并将子bd与父bd进行合并
 * 		设置一些其他属性
 *
 * @author zzq
 * @date 2023/7/31
 */
public class BeanMergeTest {


	//测试xml形式的BeanDefinition合并
//	public static void main(String[] args) {
//		XmlWebApplicationContext context = new XmlWebApplicationContext();
//		context.setConfigLocation("classpath:spring-merge-beandefinition.xml");
//		context.refresh();
//		System.out.println(context.getBean(ChildBean.class));
//	}



	//通过API直接注册bean定义测试
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 将FatherBean注册到上下文的BeanFactory中
		RootBeanDefinition fatherBean = new RootBeanDefinition();
		fatherBean.setBeanClass(FatherBean.class);
		fatherBean.getPropertyValues().add("familyName", "张");
		fatherBean.getPropertyValues().add("name", "三");
		fatherBean.getPropertyValues().add("age", "60");
		context.registerBeanDefinition("fatherBean", fatherBean);

		// 将ChildBean注册到上下文的BeanFactory中
		GenericBeanDefinition childBean = new GenericBeanDefinition();
		childBean.setBeanClass(ChildBean.class);
		childBean.getPropertyValues().add("name", "三儿子");
		childBean.getPropertyValues().add("age", "18");
		childBean.setParentName("fatherBean");
		context.registerBeanDefinition("childBean", childBean);
		context.refresh();
		System.out.println(context.getBean(ChildBean.class));
	}
}
