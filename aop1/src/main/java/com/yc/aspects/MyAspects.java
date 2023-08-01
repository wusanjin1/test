package com.yc.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Aspect
public class MyAspects {
    //切入点表达式: 正则表达式  筛选   目标类中哪些方法加增加
    // * :
    // .. : 代表 0 或 n
    @Pointcut("execution(* com.yc.biz.*.make*(..))")
    private void a(){}

    @Before("a()")
    //@Before("execution(* com.yc.biz.*.make*(..))")
    public void recordTime() {
        Date d = new Date();
        System.out.println("=========下单的时间:" +d);
    }

    @AfterReturning("a()")
    public void sendEmail() {
        System.out.println("调用数据库查询此下单用户的email,包装信息, 发送到消息中间件 kafka/mq  . ");
    }

    @AfterReturning("a()")
    public void recordParams(JoinPoint jp) {    //记录连接点make*()  中的参数信息，  make*()就称为JoinPoint
        //从jp中可以取出一些信息  make*() 方法的信息
        System.out.println("增强的方法:" + jp.getSignature());
        System.out.println("增强的目标类:" + jp.getTarget());
        System.out.println("参数:");
        Object[] params = jp.getArgs();
        for (Object a : params) {
            System.out.println(a);
        }
    }

    ///////////////////////////////////查询是同一个商品名有不同的返回值  pid  请统计频率//////////
    ////如何获取  方法的返回值
    @Pointcut("execution(int com.yc.biz.*.findPid(String))")
    private void c() {}
    private Map<String, Long> map2 = new ConcurrentHashMap<>();
    //统计每个  商品名 编号 被查询的次数
    @AfterReturning(pointcut = "c()", returning = "retValue")
    public void recordPnameCount2(JoinPoint jp, int retValue) {   //DI方式注入
        Object[] objs = jp.getArgs();
        String pname = (String) objs[0];
        Long num = 1L;
        if (map2.containsKey(pname)){
            num = map2.get(pname);
            num++;
        }
        map2.put(pname + ":" + retValue, num);
        System.out.println("统计结果:" + map2);
    }

    ////////////////////////对异常进行处理
    @AfterThrowing(pointcut = "a()",
                    throwing = "ex")
    public void recordException(JoinPoint jp, RuntimeException ex) {    //有spring容器将捕捉到的异常传入
        System.out.println("********异常*********");
        System.out.println(ex.getMessage());
        System.out.println(jp.getArgs()[0] + "\t" + jp.getArgs()[1]);
        System.out.println("********************");

    }

    //////////////////////////查询方法特慢，想统计一下查询时长    查询方法都是 find*
    @Pointcut("execution(* com.yc.biz.*.find*(..))")
    private void d(){}

    @Around("d()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {  //pjp就是被 调用的  find*()
        long start = System.currentTimeMillis();
        Object retVal = pjp.proceed(); //返回值  find*()
        long end = System.currentTimeMillis();
        System.out.println("方法执行时长为:" + (end - start));
        return retVal;

    }

}
