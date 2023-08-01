package springStudy.test01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test1 {
    public static void main(String[] args) {
        //1.早期的程序
//        Student s = new Student();
//        s.setId(1);
//        s.setName("张三");
//        System.out.println(s.toString());

        //小结： 这叫控制不反转，程序来创建对象   Test1依赖于  Student的

        //2.引入spring的IOC机制
        //IOC:控制反转  由spring来创建对象 Student
        //                          ClassPathXmlApplicationContext: 类路径下的  xml文件
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //上面这句；  启动容器 读取class路径下的beans.xml文件，并获取bean配置的class，实例化对象，存到容器中。
        //ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
        //ApplicationContext context = new FileSystemXmlApplicationContext("file:///d:\\beans.xml");
        //第三种applicationContext
        //Resource res = new ClassPathResource("beans.xml");
        //BeanFactory context = new XmlBeanFactory(res);

//        Student ss = (Student) context.getBean("s");
//        System.out.println(ss);
//
//        //容器的好处：容器来管理bean,比如单例:
//        Student s1 = (Student) context.getBean("s");
//        Student s2 = (Student) context.getBean("s");
//        System.out.println(s1.hashCode() + "\t" + s2.hashCode());   //自动实现了单例

        //TODO:  让属性有值:   -DI  -> Dependency injection  依赖注入
        Student ss = (Student) context.getBean("s");
        System.out.println(ss);










    }
}
