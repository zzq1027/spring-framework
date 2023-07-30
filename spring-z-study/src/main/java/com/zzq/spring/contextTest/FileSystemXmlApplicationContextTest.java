package com.zzq.spring.contextTest;

import com.zzq.spring.service.ExampleBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author zzq
 * @date 2023/7/30
 */
public class FileSystemXmlApplicationContextTest {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");

		ExampleBean exampleBean = (ExampleBean) context.getBean("exampleBean");
        System.out.println(exampleBean.getExampleProperty());
	}
}
