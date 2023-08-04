package springStudy.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ThreadPoolExecutor;

public class TestMain {
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext:基于注解@Configuration的配置类
        //IOC完成   DI完成
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
        Apple apple = (Apple) ac.getBean("a");
        System.out.println(apple);

        ThreadPoolExecutor tpe = (ThreadPoolExecutor) ac.getBean("tpe");
        tpe.submit(() -> {
            System.out.println("hello");
        });
    }
}
