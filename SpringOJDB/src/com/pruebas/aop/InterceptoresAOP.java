package com.pruebas.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class InterceptoresAOP {

	
	//public ModelAndView leerArticulos(){
	@Pointcut("execution(* com.pruebas.controladores.UsuarioController.leerArticulos(..))")
	public void interceptorLecturaUsuarios(){
		System.out.println("PointCut definido");
	}
	
	@Before("interceptorLecturaUsuarios()")
	public void before(JoinPoint jp) throws Throwable{
		System.out.println("Interceptado en Before");
		
	}
	
	@After("interceptorLecturaUsuarios()")
	public void after(JoinPoint jp) throws Throwable{
		System.out.println("Interceptado en After");
		
	}
	
	@Around("interceptorLecturaUsuarios()")
	public Object around(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("Interceptado en Around");
		
		return jp.proceed();
		
	}

}
