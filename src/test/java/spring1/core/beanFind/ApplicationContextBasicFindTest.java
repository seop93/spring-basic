package spring1.core.beanFind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import
        org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring1.core.order.AppConfig;
import spring1.core.service.MemberService;
import spring1.core.service.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new
            AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class); // .class는 타입지정?
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean( MemberService.class); // .class는 타입지정?
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean( "memberService",MemberServiceImpl.class); // .class는 타입지정?
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByName(){
        //ac.getBEan("xxxx", memberService.class);
        MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () ->
                ac.getBean("xxxx", MemberService.class));
    }

}
