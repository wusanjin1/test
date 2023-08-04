package springStudy.test02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 相当于一个  beans.xml配置文件
 */
@Configuration      //此注解  表示这个类是一个配置类  相当于beans.xml文件
public class AppConfig {
    @Bean       //相当于<bean id="a" class="springStudy.test02.Apple" >
    public Apple a(){
        //return new Apple();
        Apple apple = new Apple();
        apple.setId(100);  //<property name="id" value="100"></property>
        return apple;
    }
    //apple对象以 a  作键名存到 ApplicationContext容器中


    @Bean
    public ThreadPoolExecutor tpe(){
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        int maxPoolSize = corePoolSize * 2;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(maxPoolSize * 4);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,unit,workQueue);
        executor.prestartAllCoreThreads();
        return executor;
    }
}
