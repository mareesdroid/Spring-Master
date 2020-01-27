package com.mars.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class marsAopExpression {
	@Pointcut("execution(* com.mars.aop.dao.*.*(..))")
    public void forDAOPackage() {
    
    }
    
    @Pointcut("execution(* com.mars.aop.dao.*.get*(..))")
    public void getter() {
    
    }
    
    @Pointcut("execution(* com.mars.aop.dao.*.set*(..))")
    public void setter() {
    
    }
    
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void daoPackageNoGetterSetter() {
    
    }
}
