/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fruitshop;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Mmotkim
 */
public class FruitShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1.Create necessary objects and variables
        int choice;
        ArrayList<Fruit> fruitList = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> orderList = new Hashtable<>();
        //Key: Customer name ; Value: customer's orders
        //2.Navigational code
        do{
            //2.1 Display menu
            Management.displayMenu();
            //2.2 User inputs choice
            choice = input.getNumber("Input choice: ",0,5);
            //2.3 Perform management utilities
            switch(choice){
                //Create fruit
                case 1: 
                    Management.createFruit(fruitList);
                    break;
                //View orders
                case 2: 
                    Management.viewOrders(orderList);
                    break;
                //Shopping
                case 3: 
                    Management.shop(fruitList, orderList);
                    break;
            }
        } while(choice<4);
        
        
    }

    
   
    
}
