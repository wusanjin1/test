package springStudy.test04_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test04 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig_Test04.class);

        ProductBiz pb = (ProductBiz) ac.getBean("productBizImpl");  //beanid的约定是类名的首字母小写
        pb.takein();
    }
}
