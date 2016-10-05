package spring.service.lifecycle;

import org.springframework.beans.factory.BeanNameAware;

public class LifeCycle01 implements BeanNameAware{
	public LifeCycle01(){
		System.out.println("\n::"+getClass().getName()+"defualt constructor..");
		
	}
	
	
	public void setBeanName(String name){
		System.out.println("\n::"+getClass().getName()+"setBeanName() start..");
		System.out.println("xml에 정의된 beanName : "+name);
		System.out.println("\n::"+getClass().getName()+"setBeanName() end..");
	}
	
	public void init(){
		System.out.println("\n::"+getClass().getName()+"init()");
	}
	public void destroy(){
		System.out.println("\n::"+getClass().getName()+"destroy()");
	}
}
