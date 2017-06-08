package com.nameless.service.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class ServiceInterceptor {

	//@Pointcut("execution(public * com.freud.interceptor.*.insert*(..))||execution(* com.freud.interceptor.*.add*(..))")
	@Pointcut("execution(public * com.nameless.service.impl.HomeImpl.toHome(..))")
	//@Pointcut("execution(public * com.nameless.service.impl.*.to*(..))")
	public void logging(){}
	
	@AfterReturning("logging()")
	public void doAfterReturn(JoinPoint joinPoint) throws Throwable{
		//TODO System.out.println("----- doAfterReturn ["+joinPoint.getClass()+"]-----");
	}
	
	@After("logging()")
	public void doAfter(JoinPoint joinPoint) throws Throwable{
		//TODO System.out.println("----- doAfter ["+joinPoint.getClass()+"]-----");
	}
	
	@Before("logging()")
	public void doBefore(JoinPoint joinPoint){
		//TODO System.out.println("----- doBefore ["+joinPoint.getClass()+"]-----");
	}
	
	@AfterThrowing("logging()")
	public void doAfterThrowing() {
		//TODO System.out.println("----- doAfterThrowing -----");
	}
	
	@Around("logging()")
	public Object doAround(ProceedingJoinPoint joinPoint) {
		System.out.println("----- doAround ["+joinPoint.getClass()+"] -----");
		Object result = null;
		try {
			result = joinPoint.proceed(joinPoint.getArgs());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
