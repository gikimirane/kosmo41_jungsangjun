package com.study.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class LogAop {
	
// @Pointcut("execution)public void get*(..))")	// public void인 모든 get메소ㄷ
// @Pointcut("execution(* com.study.spring.*.*())")
// @Pointcut("execution(* com.study.spring..*.*())")

// @Pointcut("execution(* com.study.spring.Worker*())")
	
// @Pointcut("within(com.study.spring.*)")
// @Pointcut("within(com.study.spring..*)")
// @Pointcut("within(com.study.spring.Worker)")
	
//
//
	
	@Pointcut("within(com.study.spring.*)")
	private void pointcutMethod() {
	}

	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "is start.");
		
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			
			System.out.println(signatureStr + "is finished.");
			System.out.println(signatureStr + " 경과시간 : " + (et - st));
		}
	}
	
	@Before("pointcutMethod()")
	public void beforeAdvice() {
		System.out.println("beforAdvice()");
	}
	
}
