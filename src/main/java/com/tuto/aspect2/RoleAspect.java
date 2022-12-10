package com.tuto.aspect2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RoleAspect {
	
	Logger logger = LoggerFactory.getLogger(RoleAspect.class);
	
	@Pointcut("execution(* com.tuto.services2.impl.RoleService.getListAllRoles())")
	private void getListAllRoles() {
	}
	
	@Before("getListAllRoles()")
	private void beforegetListAllRoles(){
		logger.warn("Before getListAllRoles()");
	}

	@After("getListAllRoles()")
	private void aftergetListAllRoles(){
		logger.warn("After getListAllRoles()");
	}

	@Around("getListAllRoles()")
	private Object aroundgetListAllRoles(ProceedingJoinPoint pjp){
		logger.warn("Around getListAllRoles() begin");
		Object ret = null;
		try {
			ret = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		logger.warn("Around getListAllRoles() end");
		return ret;
	}

	@AfterReturning("getListAllRoles()")
	private void afterReturngetListAllRoles(){
		logger.warn("After return getListAllRoles()");
	}

	@AfterThrowing("getListAllRoles()")
	private void afterThrowing(){
	logger.warn("After throwing exception");
	}

}
