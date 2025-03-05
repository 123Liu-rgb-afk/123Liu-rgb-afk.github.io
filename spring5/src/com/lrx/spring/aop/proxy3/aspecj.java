package com.lrx.spring.aop.proxy3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author lrx
 * {@code @date} 2025/3/5 下午4:28
 */
@Aspect
@Component
public class aspecj {

    //定义一个切入点, 在后面使用时可以直接引用, 提高了复用性
    @Pointcut(value = "execution(public float com.lrx.spring.aop.proxy3.SmartDog.getSum(float, float)))")
    //@Pointcut(value = "execution(public float com.lrx.spring.aop.proxy3.SmartDog.getSum(float, float)))")
    public void myPointCut() {
    }


    //@Before(value = "execution(public float com.hspedu.spring.aop.aspectj.SmartDog.getSum(float, float))")
    //这里我们使用定义好的切入点
    @Before(value = "myPointCut()")
    public void showBeginLog(JoinPoint joinPoint) {
        //通过连接点对象joinPoint 可以获取方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("SmartAnimalAspect-切面类showBeginLog()[使用的myPointCut()]-方法执行前-日志-方法名-" + signature.getName() + "-参数 "
                + Arrays.asList(joinPoint.getArgs()));
    }
    @AfterReturning(value = "myPointCut()", returning = "res")
    public void showSuccessEndLog(JoinPoint joinPoint ,Object res) {
        //通过连接点对象joinPoint 可以获取方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("SmartAnimalAspect-切面类showSuccessEndLog[使用的myPointCut()]-返回通知-日志-方法名-" + signature.getName() + "-参数 "
                + Arrays.asList(joinPoint.getArgs()) + " 结果=" + res);
    }
    @AfterThrowing(value = "myPointCut()",throwing ="throwing")
    public void showExceptionLog(JoinPoint joinPoint,Throwable throwing) {
        //通过连接点对象joinPoint 可以获取方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("异常通知=" + throwing);
    }
    @After(value = "myPointCut()")
    public void showFinallyLog(JoinPoint joinPoint) {
        //通过连接点对象joinPoint 可以获取方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("SmartAnimalAspect-切面类showFinallyLog[使用的myPointCut()]-方法最终完成-日志-方法名-" + signature.getName() + "-参数 "
                + Arrays.asList(joinPoint.getArgs()));
    }

    @Before(value = "execution(public void Car.run())")
    public void showBeginCar(JoinPoint joinPoint) {
        joinPoint.getSignature().getName();
        joinPoint.getSignature().getDeclaringType().getSimpleName();
        joinPoint.getSignature().getDeclaringTypeName();
        joinPoint.getSignature().getModifiers();
        joinPoint.getArgs();
        joinPoint.getThis();
        joinPoint.getTarget();
        System.out.println("car前置");
    }

}
