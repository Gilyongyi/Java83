package spring.service.lifecycle;

import org.springframework.beans.factory.FactoryBean;

import spring.service.domain.User;

public class UserFactoryBean implements FactoryBean{

	public UserFactoryBean() {
		System.out.println("::"+getClass().getName()+" default Constructor..");
	}
	
	public User getObject(){
		System.out.println("::"+getClass().getName()+".getObject()");
		return new User();
	}
	
	public Class getObjectType(){
		System.out.println("::"+getClass().getName()+".getObjectType()");
		return User.class;
	}
	
	public boolean isSingleton(){
		System.out.println("::"+getClass().getName()+".isSingleton");
		return true;
	}
	

}
