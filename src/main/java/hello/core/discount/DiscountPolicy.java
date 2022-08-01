package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @param member
     * @param price
     * @return 얼마가 할인될지 리턴
     */

    int discount(Member member, int price);
}
