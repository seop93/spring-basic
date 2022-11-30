package spring1.core.order;

import spring1.core.discount.DiscountPolicy;
import spring1.core.domain.member.Member;
import spring1.core.repository.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private  final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
