package springStudy.test03_factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        //1.创建容器
        //观察容器启动，FruitFactoryBean  Pear
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigTest3.class);
        Object obj = ac.getBean("ffb");   //ffb  -> Pear
        System.out.println(obj.hashCode());

        Object obj2 = ac.getBean("&ffb");  //beanid: &ffb ->  工厂bean
        System.out.println(obj2);

        //2.pear是单例还是多例
        obj = ac.getBean("ffb");   //ffb  -> Pear
        System.out.println(obj.hashCode());

        //3.获取spring容器中所有托管的bean
        String [] beanNames = ac.getBeanDefinitionNames();
        for (String bn : beanNames) {
            System.out.println(bn);
        }
    }
}
