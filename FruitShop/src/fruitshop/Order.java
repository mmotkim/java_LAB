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
    
    ArrayList<Fruit> fruitList;

    public Order() {
    }

    public Order(ArrayList<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    
    
    
}
