package springtest02;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"springtest02.system","springtest02.user"})
public class Config {
}
