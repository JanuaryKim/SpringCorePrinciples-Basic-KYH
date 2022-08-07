package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("스프링 컨테이너 내의 모든 빈 출력")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " Object = " + bean);
        }
    }

    @Test
    @DisplayName("스프링 컨테이너내에 애플리케이션 빈 출력")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); //빈의 정의내용을 꺼냄


            //Role ROLE_APPLICATION : 개발자가 직접 등록한 빈
            //Role ROLE_INFRASTRUCTURE : 스프링이 내부적으로 등록한 빈

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){ //디피니션에 정의된 역할이 어플리케이션 역할의 빈일때
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("beanName = " + beanDefinitionName + " object = " + bean);
            }

        }
    }
}
