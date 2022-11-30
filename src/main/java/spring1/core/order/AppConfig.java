package spring1.core.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring1.core.discount.DiscountPolicy;
import spring1.core.discount.FixDiscountPolicy;
import spring1.core.repository.MemberRepository;
import spring1.core.repository.MemoryMemberRepository;
import spring1.core.service.MemberService;
import spring1.core.service.MemberServiceImpl;

@Configuration
public class AppConfig {

    @Bean() //option name
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

}
