package spring1.core.order;

import spring1.core.domain.member.Grade;
import spring1.core.domain.member.Member;
import spring1.core.service.MemberService;
import spring1.core.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "A", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new: " + member.getName());
        System.out.println("find: " + findMember.getName());

    }
}
