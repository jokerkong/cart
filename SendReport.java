package com.example.demo;

public abstract class SendReport {
    SendBehavior sendBehavior;

    public abstract void display();

    public void setSendBehavior(SendBehavior sb){
        sendBehavior=sb;
    }

    public void performSend(String connectAddress,String orderID ,String userNM){
        sendBehavior.channel(connectAddress,orderID,userNM);
    }

}
