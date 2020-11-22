package com.example.demo;

public class SendReportByEmail extends SendReport {
    public SendReportByEmail(){
        sendBehavior = new EmailChannel();
    }
    @Override
    public void display() {
        System.out.println("send report by Email ");
    }
}
