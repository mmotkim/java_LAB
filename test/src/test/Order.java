/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author Mmotkim
 */
public class Order {
    private String orderName;
    private ArrayList<Fruit> orderList;

    public Order(String orderName, ArrayList<Fruit> orderList) {
        this.orderName = orderName;
        this.orderList = orderList;
    }

    public Order() {
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public ArrayList<Fruit> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Fruit> orderList) {
        this.orderList = orderList;
    }
    
    
}
