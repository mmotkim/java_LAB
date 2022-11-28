/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productmanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author Mmotkim
 */
public class ProductManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1. Create necessary objects and variables
        int choice; 
        ArrayList<Keeper> keeperList = new ArrayList<>();
        ArrayList<Product> productList = new ArrayList<>();
        //2. Navigational Code
        do{
            //2.1 display menu
            Management.displayMenu();
            //2.2 get user choice on options
            choice = input.getNumber("Input choice: ",0,7);
            //2.3 perform functions
            switch(choice){
                case 1:
                    Management.addKeeper(keeperList);
                    break;
                case 2:
                    Management.addProduct(productList, keeperList);
                    break;
                case 3:
                    Management.updateProduct(productList, keeperList);
                    break;
                case 4:
                    Management.searchProduct(productList, keeperList);
                    break;
                case 5:
                    Management.sortProduct(productList, keeperList);
                    break;
            }
        } while (choice < 6);
    }
    
}
