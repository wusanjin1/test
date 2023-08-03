package springStudy.Test05_import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Banana.class, FruitImportSelector.class})   //beanid:全路径名  -> 对象
public class AppConfig_2 {
}
