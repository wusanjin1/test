package springStudy.test03_factoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //配置类
public class AppConfigTest3 {

    @Bean   //FruitFactoryBean 被spring托管
    public FruitFactoryBean ffb() {
        return new FruitFactoryBean();
    }
}
