/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fruitshop;

import java.util.ArrayList;

/**
 *
 * @author Mmotkim
 */
class Order {
    private String customerName;
    ArrayList<Fruit> fruitList;

    public Order() {
    }

    public Order(String customerName, ArrayList<Fruit> fruitList) {
        this.customerName = customerName;
        this.fruitList = fruitList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<Fruit> fruitList) {
        this.fruitList = fruitList;
    }
    
    
}
