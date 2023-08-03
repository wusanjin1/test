package springStudy.Test06_Conditional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"springStudy.Test06_Conditional"})
public class AppConfig_test6 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig_test6.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String n :names) {
            System.out.println(n);
        }
    }
}
