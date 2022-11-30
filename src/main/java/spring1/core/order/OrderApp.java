package spring1.core.order;

import spring1.core.domain.member.Grade;
import spring1.core.domain.member.Member;
import spring1.core.service.MemberService;
import spring1.core.service.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order:" + order);

    }
}
