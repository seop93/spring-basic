package spring1.core.order;

import spring1.core.discount.DiscountPolicy;
import spring1.core.discount.FixDiscountPolicy;
import spring1.core.repository.MemoryMemberRepository;
import spring1.core.service.MemberService;
import spring1.core.service.MemberServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }


    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

}
