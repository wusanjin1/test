package com.yc.configs;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
@Data
@Log4j2
public class DataSourceConfig  {
    //利用DI和db.properties中的内容注入
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driverclass}")
    private String driverclass;
    //以上属性从db.properties中读取出来后，都存到了spring容器中，Environment的变量(系统环境变量也在这里)
    //#{T(java.lang.Math).random() * 100.0}
    @Value("#{T(Runtime).getRuntime().availableProcessors() * 2}")
    //spEL -> spring expresssion   language
    private int cpuCount;

    //参数 ： 第三方的框架中的类，用@Bean托管
    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource druidDataSource(){  //DruidDataSource中提供了 init 初始化方法   druid带连接池，轻量级锁
        DruidDataSource dds = new DruidDataSource();
        dds.setUrl(url);
        dds.setUsername(username);
        dds.setPassword(password);
        dds.setDriverClassName(driverclass);
        //以上只是配置了参数，并没有创建连接池，在这个类的init()中完成了连接池创建
        //当前主机的CPU数*2
//        int cpuCount = Runtime.getRuntime().availableProcessors() * 2;
        log.info("配置druid的连接池大小:" + cpuCount);
        dds.setInitialSize(cpuCount);
        dds.setMaxActive(cpuCount * 2);
        return dds;

    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverclass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DataSource dbcpDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverclass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        //TODO:更多参数
        return dataSource;
    }
}
