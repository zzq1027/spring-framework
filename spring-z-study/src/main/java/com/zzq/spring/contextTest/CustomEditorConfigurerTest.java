package com.zzq.spring.contextTest;

import com.zzq.spring.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 分析一下 BeanFactoryPostProcessor 的子类 CustomEditorConfigurer 自定义属性编辑器来巩固一下执行流程
 *
 * 所谓属性编辑器是当你要自定义更改配置文件中的属性属性时，如 String 类型转为 Date 或者其他，下面的一个小例子展示如何 String 类型的属性怎么转化为 Address 属性
 *
 * @author zzq
 * @date 2023/7/30
 */
public class CustomEditorConfigurerTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("convert-test.xml");
       // ApplicationContext context = new FileSystemXmlApplicationContext("classpath:convert-test.xml");
        final Person bean = context.getBean(Person.class);
        System.out.println(bean);
    }
}
