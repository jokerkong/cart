package com.example.demo;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
public class CurrentOrderStatusDisplay implements Observer{

    Observable observable;
    private String orderID;
    private int  orderStatus;
    public String updTm;
    public String crtTm;




    public CurrentOrderStatusDisplay(Observable observable){
        this.observable= observable;
        observable.addObserver(this);

    }


    public void update(Observable obs, Object arg) {
        //模拟订单数据
        Map<String, Map<String,String>> map = new HashMap<String, Map<String,String>>();
        Map<String,String> orderAConetet =new HashMap<String,String>();
        Map<String,String> orderBConetet =new HashMap<String,String>();
        Map<String,String> orderCConetet =new HashMap<String,String>();
        //orderA
        orderAConetet.put("emailFlag","0");
        orderAConetet.put("userNm","Python");
        orderAConetet.put("emailAddress","python@test.com");
        map.put("num20201123A",orderAConetet);
        //orderB
        orderBConetet.put("emailFlag","0");
        orderBConetet.put("userNm","PHP");
        orderBConetet.put("emailAddress","PHP@test.com");
        map.put("num20201123B",orderBConetet);
        //orderC
        orderCConetet.put("emailFlag","1");
        orderCConetet.put("userNm","JAVA");
        orderCConetet.put("emailAddress","JAVA@test.com");
        map.put("num20201123C",orderCConetet);


        if (obs instanceof CartOrderMsg){
            CartOrderMsg cartOrderMsg =(CartOrderMsg)obs;
            this.orderID= cartOrderMsg.getorderID();
            this.orderStatus= cartOrderMsg.orderStatus();
            this.crtTm=cartOrderMsg.getcrtTm();
            this.updTm=cartOrderMsg.getupdTm();
            String emailFlag = map.get(orderID).get("emailFlag");
            String emailAddress = map.get(orderID).get("emailAddress");
            String userNm = map.get(orderID).get("userNm");

//            System.out.println(emailFlag);
            try {
                boolean r=IsWithinTm.withinFive(crtTm,updTm);
                //uge within 5 min or not
                if(r==true){
                    System.out.println("with in 5 min");
                }else{
                    System.out.println("over 5min");
                    return;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // had sent or not
            if("1".equals(emailFlag)){
                System.out.println("has send to cust");
                return;
            }

            if(orderStatus!=3){
                System.out.println("didnt finish cart's order");
                return;
            }



            SendReport emailSend = new SendReportByEmail();
            emailSend.performSend(emailAddress,orderID,userNm);

        }
    }

}
