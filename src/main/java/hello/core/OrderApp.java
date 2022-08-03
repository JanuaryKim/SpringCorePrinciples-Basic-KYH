package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Long memberId = 1L;
        memberService.join(new Member(memberId, "MemberA", Grade.VIP));

        OrderService orderService = appConfig.orderService();

        Order itemAOrder = orderService.createOrder(memberId, "ItemA", 10000);

        System.out.println("itemAOrder = " + itemAOrder);
    }
}
