package springStudy.test04_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "springStudy.test04_annotation") //指定spring容器扫描类的路径
public class AppConfig_Test04 {

    //@Bean  原来是利用  @Bean来创建Bean，交给spring托管
}
