package springStudy.Test06_Conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component  //@Service  @Reopsitory  @Controller   -> IOC
@Conditional({SystemCondition.class})
public class NetConnection {
}
