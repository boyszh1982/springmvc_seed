package com.nameless.service.interceptor;

import org.aspectj.lang.JoinPoint;
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
	public void doAfterReturn(JoinPoint joinPoint){
		System.out.println("----- doAfterReturn -----");
	}
	
	@After("logging()")
	public void doAfter(JoinPoint joinPoint){
		System.out.println("----- doAfter -----");
	}
	
	@Before("logging()")
	public void doBefore(JoinPoint joinPoint){
		System.out.println("----- doBefore -----");
	}
	
	@AfterThrowing("logging()")
	public void doAfterThrowing() {
		System.out.println("----- doAfterThrowing -----");
	}
	
	@Around("logging()")
	public void doAround() {
		System.out.println("----- doAround -----");
	}
	
}
