/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fruitshop;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author Mmotkim
 */
class Management {

    static void displayMenu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("\t1. Create Fruit");
        System.out.println("\t2. View orders");
        System.out.println("\t3. Shopping(For buyer)");
        System.out.println("\t4. Exit");
    }

    static void createFruit(ArrayList<Fruit> fruitList) {
        //create objects

        //loop to get user input
        do {
            int id = input.getNumber("Input id: ", 0, Integer.MAX_VALUE);

            while (checkIdExisting(fruitList, id)) {
                System.out.println("fruit id already exists!");
                id = input.getNumber("Input id: ", 0, Integer.MAX_VALUE);
            }

            String name = input.getString("Input fruit name: ");

            int price = input.getNumber("Input price: ", 0, Integer.MAX_VALUE);

            int quantity = input.getNumber("Input quantity: ", 0, Integer.MAX_VALUE);

            String origin = input.getString("Input origin: ");

            //create a new fruit object and add it to arraylist
            Fruit fruit = new Fruit(id, name, price, quantity, origin);
            fruitList.add(fruit);

            //ask for continuition from user
            String choice = input.getDoubleChoice("Do you want to continue (Y/N): ", "Y", "N");

            if (choice.equals("N")) {
                //display fruit list
                displayFruits(fruitList, false);
                break;
            }

        } while (true);

    }

    static void viewOrders(Hashtable<Order, ArrayList<Fruit>> orderList) {
        if (orderList.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }

        for (Map.Entry<Order, ArrayList<Fruit>> order : orderList.entrySet()) {
            ArrayList<Fruit> orderFruitList = order.getValue();

            System.out.println("Customer: " + order.getKey().getCustomerName());
            displayFruits(orderFruitList, true);
        }

    }

    static void shop(ArrayList<Fruit> fruitList, Hashtable<Order, ArrayList<Fruit>> orderList) {
        ArrayList<Fruit> tempFruitList = fruitList;
        ArrayList<Fruit> cart = new ArrayList<>();
        do {
            displayFruits(tempFruitList, false);

            int inputId = input.getNumber("Input fruit ID to buy: ", 0, Integer.MAX_VALUE);
            //check if fruit id exists
            while (!checkIdExisting(fruitList, inputId)) {
                System.out.println("Inputted ID not found! try again.");
                inputId = input.getNumber("Input fruit ID to buy: ", 0, Integer.MAX_VALUE);
            }

            int buyQuantity = input.getNumber("Input quantity of fruit: ", 0, Integer.MAX_VALUE);
            //checks if input quantity exceeds fruit stock
            while (checkStock(tempFruitList, inputId, buyQuantity)) {
                System.out.println("Not enough fruit in stock! try again.");
                buyQuantity = input.getNumber("Input quantity of fruit: ", 0, Integer.MAX_VALUE);
            }

            //add the fruit to cart and perform subtractions
            //if fruit in cart already exists:
            if (checkIdExisting(cart, inputId)) {
                for (Fruit fruit : cart) {
                    if (fruit.getId() == inputId){
                        fruit.setQuantity(fruit.getQuantity() + buyQuantity);
                        //perorm subtractions
                        subtractQuantity(tempFruitList, inputId, buyQuantity);
                    }
                }
            } 
            //if fruit inputted into cart is a new fruit
            else if (!checkIdExisting(cart, inputId)) {
                for (Fruit fruit : tempFruitList) {
                    if(fruit.getId() == inputId){
                        Fruit fruitOrder = new Fruit(inputId, fruit.getName(), fruit.getPrice(), buyQuantity, fruit.getOrigin());
                        cart.add(fruitOrder);
                        //perform subtractions
                        subtractQuantity(tempFruitList, inputId, buyQuantity);
                    }
                }
            }

            //ask for continuition from user
            String choice = input.getDoubleChoice("Do you want to order now (Y/N): ", "Y", "N");

            if (choice.equals("Y")) {
                System.out.println("Your order:");
                displayFruits(cart, true);

                String customerName = input.getString("Input your name: ");

                Order order = new Order(customerName, cart);
                orderList.put(order, cart);

                //Update original fruit list
                fruitList = tempFruitList;
                break;
            }

        } while (true);
    }

    static boolean checkIdExisting(ArrayList<Fruit> fruitList, int id) {
        for (Fruit fruit : fruitList) {
            if (id == fruit.getId()) {
                return true;
            }
        }

        return false;
    }

    static void displayFruits(ArrayList<Fruit> fruitList, boolean viewAsOrder) {
        int total = 0;

        if (viewAsOrder) {
            System.out.println("Fruit Name\tPrice\t\tQuantity\tAmount");
            for (Fruit fruit : fruitList) {
                System.out.println(fruit.getName()
                        + "\t\t" + fruit.getPrice()
                        + "\t\t" + fruit.getQuantity()
                        + "\t\t" + (fruit.getPrice() * fruit.getQuantity()) + "$");

                total += fruit.getPrice() * fruit.getQuantity();     
            }
            System.out.println("Total: " + total + "$");
        } else {
            System.out.println("Item\t\tFruit Name\tOrigin\t\tPrice\t\tQuantity");
            for (Fruit fruit : fruitList) {
                System.out.println(fruit.getId() + "\t\t" + fruit.getName()
                        + "\t\t" + fruit.getOrigin() + "\t\t" + fruit.getPrice()
                        + "\t\t" + fruit.getQuantity());

                total += fruit.getPrice() * fruit.getQuantity();
            }
        }
    }

    static boolean checkStock(ArrayList<Fruit> fruitList, int id, int quantity) {
        for (Fruit fruit : fruitList) {
            if (fruit.getId() == id) {
                if (fruit.getQuantity() < quantity) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static void subtractQuantity(ArrayList<Fruit> fruitList, int id, int quantity){
        for (Fruit fruit : fruitList) {
            if (fruit.getId() == id){
                fruit.setQuantity(fruit.getQuantity() - quantity);
                break;
            }
        }
    }

}
