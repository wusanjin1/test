package springStudy.Test06_Conditional;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SystemCondition implements Condition {
    /**
     * 匹配方法:  看操作系统  <- Environment  <-  spring容器
     * 回调方法   <- 容器
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //Environment:  jdk:System.getEnv();
        Environment env = context.getEnvironment();
        //系统变量  os.name
        //命令行参数   os.name=Linux
        //程序
        String osname = env.getProperty("os.name");
        System.out.println(env.getProperty("user.dir"));
        System.out.println(env.getProperty("user.home"));
        if (osname.contains("Windows")) {
            return true;
        }
        return false;
    }











}
