package mybatis.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PojoAspectJ{
	
	
	public PojoAspectJ() {
		System.out.println("::TestAspectJ02 default Constructor");
	}

	//@Around("execution(* spring.service.aop.*.*(..))")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("[Around before"+getClass()+".invoke() start....");
		System.out.println("[Around before] ≈∏∞Ÿ ∞¥√º: "+joinPoint.getTarget().getClass().getName());
		System.out.println("[Around before] ≈∏∞Ÿ ∞¥√º¿« »£√‚ µ… method "+joinPoint.getSignature().getName());
		if(joinPoint.getArgs().length!=0){
			System.out.println("[Around before] targetObject method ¿¸¥ﬁ argument: "
					+joinPoint.getArgs()[0]);
		}
		Object obj = joinPoint.proceed();
		
		System.out.println("[Around after] ≈∏∞Ÿ ∞¥√º¿« »£√‚»ƒ return value : "+obj);
		System.out.println("[Around after]"+getClass()+".invoke() end....");
		
		return obj;
	}
	

}
