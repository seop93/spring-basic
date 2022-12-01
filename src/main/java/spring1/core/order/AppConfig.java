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

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService ->

    @Bean() //option name
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

}
