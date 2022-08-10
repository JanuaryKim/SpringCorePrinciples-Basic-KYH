package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
//        BeanB beanB = ac.getBean("beanB", BeanB.class); //애초에 beanB으로 등록된 빈이 없으므로 컴파일 에러

        Assertions.assertThat(beanA).isNotNull();
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("beanB",BeanB.class));

    }


    @Configuration
    @ComponentScan(
            //컴포넌트 스캔으로 읽혀질 애노테이션 추가
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            //컴포넌트 스캔으로 읽혀지지 않을 애노테이션 추가
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )
//    @ComponentScan(
//            //컴포넌트 스캔으로 읽혀질 애노테이션 추가
//            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class)
//    )
    static class ComponentFilterAppConfig{ //스프링 컨테이너에게 넘겨줄 Text 설정파일

    }
}
