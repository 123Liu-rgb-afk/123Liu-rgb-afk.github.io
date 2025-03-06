package com.lrx.spring.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @author lrx
 * {@code @date} 2025/3/6 下午9:53
 */
@Aspect
@Component
public class SmartAnimalAspect {
    @Before(value = "execution(public float com.lrx.spring.aop.SmartDog.getSum(float ,float ))")
    public static void showBeginLog() {
        System.out.println("前置通知");
    }
//这个就对应动态代理类的
//System.out.println(" 日 志 -- 方 法 名 ： "+methodName+"-- 方 法 正 常 结 束 -- 结 果 ：result="+result);
    @AfterReturning(value = "execution(public float com.lrx.spring.aop.SmartDog.getSum(float ,float))")
    public void showSuccessEndLog() {

        
        System.out.println("返回通知");
    }

    @AfterThrowing(value = "execution(public float com.lrx.spring.aop.SmartDog.getSum(float ,float))")
    public void showExceptionLog() {
        System.out.println("异常通知");
    }

    @After(value = "execution(public float com.lrx.spring.aop.SmartDog.getSum(float ,float))")
    public void showFinallyEndLog() {
        System.out.println("最终通知");
    }
}
