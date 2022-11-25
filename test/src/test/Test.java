/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Mmotkim
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Fruit> fruitList = new ArrayList<>();
        
        Hashtable<Integer, ArrayList<Order>> orderList = new Hashtable<>();
        
        Fruit fruit1 = new Fruit("apple", 5);
        Fruit fruit2 = new Fruit("mango", 3);
        fruitList.add(fruit1);
        fruitList.add(fruit2);
        
        ArrayList<Fruit> cart1 = getCart(fruitList);
        ArrayList<Fruit> cart2 = getCart2(fruitList);
        
        orderDetails.put(1, cart1);
        orderDetails.put(2, cart2);
        
        orderList.put("Duc", orderDetails);
        
        for (String name : orderList.keySet()) {
            System.out.println("Customer: " + name);
            for (int orderNumber : orderDetails.keySet()) {
                System.out.println(orderNumber + "th Order:");
                ArrayList<Fruit> details = orderDetails.get(orderNumber );
                displayOrder(details);
            }
        }
        
        
    }

    private static ArrayList<Fruit> getCart(ArrayList<Fruit> fruitList) {
        ArrayList<Fruit> cart = new ArrayList<>();
        Fruit fruit = new Fruit("mango", 1);
        Fruit fruit2  = new Fruit("dipshit", 2);
        cart.add(fruit2);
        cart.add(fruit);
        System.out.println(cart);
        return cart;
    }
    
    private static ArrayList<Fruit> getCart2(ArrayList<Fruit> fruitList) {
        ArrayList<Fruit> cart = new ArrayList<>();
        Fruit fruit = new Fruit("mango", 2);
        cart.add(fruit);
        
        return cart;
    }
    
    static void displayOrder(ArrayList<Fruit> fruitList){
        System.out.println("FName\t\tFQuantity");
        for (Fruit fruit : fruitList) {
            System.out.println(fruit.getFruitName() + "\t\t" + fruit.getQuantity());
        }
    }
    
    
    
}
