package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import hello.core.member.Member;

import static org.assertj.core.api.Assertions.*;


class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy;
    @BeforeEach
    void beforeEach() {

        AppConfig appConfig = new AppConfig();
        discountPolicy = appConfig.discountPolicy();
    }



    @Test
    @DisplayName("VIP 회원은 10% 할인이 적용되어야 합니다")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when

        int discount = discountPolicy.discount(member, 10000);
        //then

        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("VIP 회원이 아닌 멤버는 할인이 되어선 안됩니다")
    void vip_x() {
        //given
        Member member = new Member(1L, "memberA", Grade.BASIC);
        //when

        int discount = discountPolicy.discount(member, 0);
        //then

        assertThat(discount).isNotEqualTo(1000);

    }
}