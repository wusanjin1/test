package springStudy.Test05_import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Banana.class})
public class AppConfig_Test05 {
}
