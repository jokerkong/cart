package com.example.demo;
import  java.util.Observable;

public class CartOrderMsg extends Observable{
    private String getorderID;
    private int orderStatus;
    private String updTm;
    private String crtTm;

    public CartOrderMsg(){};

    public void statusChanged(){
        setChanged();
        notifyObservers();
    }

    public void setStatus(String getorderID, int orderStatus,String crtTm,String updTm) {
        this.getorderID = getorderID;
        this.orderStatus=orderStatus;
        this.crtTm=crtTm;
        this.updTm=updTm;

        statusChanged();
    }



    public String getorderID() {
        return getorderID;
    }

    public int orderStatus() {
        return orderStatus;
    }
    public String getcrtTm() {
        return crtTm;
    }
    public String getupdTm() {
        return updTm;
    }

}
