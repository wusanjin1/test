package springStudy.Test05_import;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test05 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig_Test05.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String n : names) {
            System.out.println(n);
        }

        Banana b = (Banana) ac.getBean("springStudy.Test05_import.Banana");
        System.out.println(b);

        Banana b2 = (Banana) ac.getBean(Banana.class);
        System.out.println(b2);

    }
}
