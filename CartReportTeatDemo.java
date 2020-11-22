package com.example.demo;

public class CartReportTeatDemo {
    public static void main(String[] args) {
        CartOrderMsg cartOrderMsg =new CartOrderMsg();
        CurrentOrderStatusDisplay currentDispaly=new CurrentOrderStatusDisplay(cartOrderMsg);
        //orderStatus 1 means stat ,2 means change ,3 mean finished
        //完整流程订单
        System.out.println("--------------test1 begin--------------");
        cartOrderMsg.setStatus("num20201123A",1,"2020-11-23 12:30:00","2020-11-23 12:31:50");
        System.out.println("\n\n\n");
        cartOrderMsg.setStatus("num20201123A",2,"2020-11-23 12:30:00","2020-11-23 12:32:00");
        System.out.println("\n\n\n");
        cartOrderMsg.setStatus("num20201123A",3,"2020-11-23 12:30:00","2020-11-23 12:33:00");

        System.out.println("--------------test1 end--------------\n\n\n\n");

        //超过5分钟
        System.out.println("--------------test2 begin--------------");
        cartOrderMsg.setStatus("num20201123B",1,"2020-11-23 12:30:00","2020-11-23 12:35:00");
        System.out.println("\n\n\n");
        cartOrderMsg.setStatus("num20201123B",2,"2020-11-23 12:30:00","2020-11-23 12:33:00");
        System.out.println("\n\n\n");
        cartOrderMsg.setStatus("num20201123B",3,"2020-11-23 12:30:00","2020-11-23 12:40:00");
        System.out.println("--------------test2 end--------------\n\n\n\n");

        //已经发送过
        System.out.println("--------------test3 begin--------------");
        cartOrderMsg.setStatus("num20201123C",1,"2020-11-23 12:30:00","2020-11-23 12:33:00");
        System.out.println("\n\n\n");
        cartOrderMsg.setStatus("num20201123C",2,"2020-11-23 12:30:00","2020-11-23 12:33:00");
        System.out.println("\n\n\n");
        cartOrderMsg.setStatus("num20201123C",3,"2020-11-23 12:30:00","2020-11-23 12:34:00");
        System.out.println("--------------test3 end--------------\n\n\n\n");

    }
}
