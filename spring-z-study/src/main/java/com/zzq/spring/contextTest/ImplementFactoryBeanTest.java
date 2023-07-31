package com.zzq.spring.contextTest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 *
 * FactoryBean也叫做Bean工厂，是用于生产Bean对象的类
 * 测试实现了FactoryBean后,注册到容器的实现
 *
 * FactoryBean的特殊之处在于它可以向容器中注册两个Bean，一个是它本身，一个是FactoryBean.getObject()方法返回值所代表的Bean。先通过如下示例代码来感受下FactoryBean的用处吧。
 *
 *  1、FactoryBean是BeanFactory支持的、用来暴露bean实例的接口，可以实现此接口来完成实例化过程比较复杂的bean的创建；
 *  2、通过beanName从spring容器获取bean实例时，一开始获取的是beanName直接关联的bean实例，
 *  	后续spring容器会根据此bean实例返回我们需要的对象实例；如果bean实例不是FactoryBean类型，则直接返回bean实例，
 *  	如果bean实例是FactoryBean类型，而beanName又是以&开头，直接返回bean实例，
 *  	如果bean实例是FactoryBean类型，而beanName不是以&开头，则返回bean实例的getObject()方法获取的对象实例（一般getObject中就是我们需要的实例对象的创建过程）；
 *  3、对于创建过程比较复杂的对象的创建，目前spring其实有很多实现方式了，而FactoryBean只是其中一种，也许我们不会采用此种方式来实现实例对象的创建，
 *      但我们需要能够看懂此种方式，知道有这种实现方式；很多第三方都沿用了此种方式，我们去追源码的时候，很容易就能碰到；
 *  4、相比普通bean的创建，FactoryBean的方式会在spring容器中多存在一个FactoryBean的实例，若想获取FactoryBean实例对象，只需要在FactoryBean的beanName加&即可；
 * @author zzq
 * @date 2023/7/31
 */
public class ImplementFactoryBeanTest {


  public static void main(String[] args) {
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

	 //简单的创建一个Bean
    BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserServiceFactoryBean.class);
    definitionBuilder.addPropertyValue("username", "lisi");

	//将BeanDefinition创建到容器对象里面去
    beanFactory.registerBeanDefinition("userService", definitionBuilder.getBeanDefinition());

	//注意：此时我们注册进Spring中的Bean有些特殊，他实现了两个实际上创建了两个Bean对象，第一个就是我们的UserServiceFactoryBean,
        //还有一个就是我们的UserService对象
        //此时id:&UserService表示的是UserServiceFactoryBean，id:UserService表示的是UserService对象。

	//获取生产出来的对象
    UserService userService = (UserService) beanFactory.getBean("userService");
    System.out.println(userService.getUsername());//lisi

	  //获取生产出来的对象
    UserServiceFactoryBean userServiceFactoryBean = (UserServiceFactoryBean) beanFactory.getBean("&userService");
    System.out.println(userServiceFactoryBean.username);//lisi
  }
public static class UserServiceFactoryBean implements FactoryBean<UserService> {

    private String username;

    public void setUsername(String username) {
      this.username = username;
    }

    @Override
    public UserService getObject() {
      UserService userService = new UserService();
      userService.setUsername(username);
      return userService;
    }

    @Override
    public Class<?> getObjectType() {
      return UserService.class;
    }
  }


  public static class UserService {
	  public String getUsername() {
		  return username;
	  }

	  public void setUsername(String username) {
		  this.username = username;
	  }

	  private String username;
  }



}
