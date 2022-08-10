package hello.core.singletone;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigTest {

    @Test
    @DisplayName("AppConfig의 실체 확인")
    void AppConfigPrint() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String key : beanDefinitionNames) {

            BeanDefinition beanDefinition = ac.getBeanDefinition(key);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION)
            {
                Object bean = ac.getBean(key);

                System.out.println("key = " + key + " , value = " + bean);
            }
        }
    }
}
