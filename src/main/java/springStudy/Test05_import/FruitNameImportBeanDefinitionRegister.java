package springStudy.Test05_import;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 需求：根据条件（是否已经加载好了Pear，判断是否加载了Group到容器）
 */
public class FruitNameImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param annotationMetadata  :   当前扫描得注解
     * @param beanDefinitionRegistry  : 已经注册好的bean得容器
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //先判断是否已经有了Pear加载到容器
        boolean bean = beanDefinitionRegistry.containsBeanDefinition("springStudy.test03_factoryBean.Pear");
        //如果有，则再创建Grape Bean 加载到容器
        if (bean) {
            RootBeanDefinition d = new RootBeanDefinition(Grape.class);
            //并指定键为 grape
            beanDefinitionRegistry.registerBeanDefinition("grape", d);
        }
    }




}
