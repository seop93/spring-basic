package spring1.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StateFullServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFullService stateFullService1 = ac.getBean(StateFullService.class);
        StateFullService stateFullService2 = ac.getBean(StateFullService.class);

        //ThreadA : A 사용자가 10000원 주문
        int userA = stateFullService1.order("userA", 10000);

        //ThreadB : B 사용자가 20000원 주문
        int userB = stateFullService2.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
        //System.out.println("price = " + price);

    }

    static class TestConfig{

        @Bean
        public StateFullService stateFullService(){
            return new StateFullService();
        }

    }

}