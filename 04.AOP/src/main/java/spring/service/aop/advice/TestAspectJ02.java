package spring.service.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestAspectJ02{
	
	
	public TestAspectJ02() {
		System.out.println("::TestAspectJ02 default Constructor");
	}

	/*@Pointcut("execution(* *.getMessage(..))")
	public void work(){
		System.out.println("::work() pointcut call......");
	}*/
	
	@Before("execution(* *.getMessage(..))")
	public void before(JoinPoint joinPoint){
		System.out.println("[before LOG]"+getClass()+".before() start....");
		System.out.println("[before LOG] targetObject:"+joinPoint.getTarget().getClass().getName());
		System.out.println("[before LOG] TargetObject method :"+joinPoint.getSignature().getName());
		if(joinPoint.getArgs().length!=0){
			System.out.println("[before LOG]targetObject method argument :"+joinPoint.getArgs()[0]);
		}
		System.out.println("[before LOG]"+getClass()+".before() end....");
	}
	
	@AfterReturning(pointcut="within(spring.service.aop..*)",returning="returnValue")
	public void afterReturning (JoinPoint joinPoint,Object returnValue){
		System.out.println("[after LOG ]"+getClass()+".afterReturning() start....");
		System.out.println("[after LOG ] targetObject call Method :"+joinPoint.getTarget().getClass().getName());
		System.out.println("[after LOG ] ≈∏∞Ÿ ∞¥√º »£√‚µ» method :"+joinPoint.getSignature().getName());
		System.out.println("[after LOG ≈∏∞Ÿ ∞¥√º »£√‚»ƒ return value :"+returnValue);
		System.out.println("[after LOG ]"+getClass()+".before() end....");
	}
	@Around("execution(* spring.service.aop.*.*(..))")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("[Around before"+getClass()+".invoke() start....");
		System.out.println("[Around before] ≈∏∞Ÿ ∞¥√º:"+joinPoint.getTarget().getClass().getName());
		System.out.println("[Around before] ≈∏∞Ÿ ∞¥√º¿« »£√‚ µ… method"+joinPoint.getSignature().getName());
		if(joinPoint.getArgs().length!=0){
			System.out.println("[Around before] targetObject method ¿¸¥ﬁ argument: "
					+joinPoint.getArgs()[0]);
		}
		Object obj = joinPoint.proceed();
		
		System.out.println("[Around after] ≈∏∞Ÿ ∞¥√º¿« »£√‚»ƒ return value : "+obj);
		System.out.println("[Around after]"+getClass()+".invoke() end....");
		
		return obj;
	}
	@AfterThrowing(pointcut="execution(public * *(..))",throwing="throwable")
	public void afterThrowing(JoinPoint joinPoint,Throwable throwable){
		System.out.println("[exception]"+getClass()+".afterThrowing() start....");
		System.out.println("[exception]≈∏∞Ÿ ∞¥√º :"+joinPoint.getTarget().getClass().getName());
		System.out.println("[exception] ≈∏∞Ÿ ∞¥√º¿« »£√‚ µ» method"+joinPoint.getSignature().getName());
		System.out.println("[exception] Exception πﬂª˝");
		System.out.println("[exception] Exception Message : "+throwable.getMessage());
		System.out.println("[exception]"+getClass()+".afterThrowing() end....");
	}
	

}
