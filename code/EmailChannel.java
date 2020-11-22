package com.example.demo;

public class EmailChannel implements SendBehavior {
    @Override
    public void channel(String email ,String orderId,String userNm) {
        System.out.println("send email  "+email+"  to  "+ userNm+ "And orderID is "+orderId);
    }
}
