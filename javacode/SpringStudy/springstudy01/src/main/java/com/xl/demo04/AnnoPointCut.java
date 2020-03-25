package com.xl.demo04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
public class AnnoPointCut {

    @Before("execution(* com.xl.demo04.UserServcieImpl.*(..))")
    public void before()
    {
        System.out.println("Anno before....");
    }

    @After("execution(* com.xl.demo04.UserServcieImpl.*(..))")
    public void after()
    {
        System.out.println("Anno after....");
    }

    @Around("execution(* com.xl.demo04.UserServcieImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {

        System.out.println("before Anno around...." + jp.getSignature().toString());

        Object proceed = jp.proceed();

        System.out.println("after Anno around...." + proceed);
    }
}
