package spring1.core.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring1.core.domain.member.Grade;
import spring1.core.domain.member.Member;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(memberVIP, 10000);
        //then
        assertEquals(1000, discount);

    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되어야 않아야 한다.")
    void vip_x(){
        //given
        Member memberVIP = new Member(2L, "memberBASIC", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(memberVIP, 10000);
        //then
        assertEquals(0, discount);

    }

}