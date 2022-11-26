/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productmanagementsystem;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Mmotkim
 */
class Management {

   

    

    

    void displayMenu() {
        System.out.println("Main Menu: ");
        System.out.println("      1. Add Storekeeper ");
        System.out.println("      2. Add product ");
        System.out.println("      3. Update product ");
        System.out.println("      4. Search product by Name, Category, Storekeeper, ReceiptDate ");
        System.out.println("      5. Sort product by Expiry date, Date of manufacture ");
        System.out.println("      6. Exit ");
    }

    static void addKeeper(ArrayList<Keeper> keeperList) {
        int id = 0;

        //declare id appropriately.
        id = keeperList.size() + 1;
        String name = input.getString("Input Store Keeper name: ");

        //create a new keeper object then add it to list
        Keeper storekeeper = new Keeper(id, name);
        keeperList.add(storekeeper);
        System.out.println("    > Added.");

    }

    static void addProduct(ArrayList<Product> productList, ArrayList<Keeper> keeperList) {
        //check if keeper list is empty
        if (keeperList.isEmpty()){
            System.out.println("No store keepers yet!");
            return;
        }
        
        int id = input.getNumber("Input Product ID: ", 0, Integer.MAX_VALUE);
        while (checkIdExisting(productList, id)) {
                System.out.println("Product id already exists!");
                id = input.getNumber("Input id: ", 0, Integer.MAX_VALUE);
            }
        
        String name = input.getString("Input Product name: ");
        String location = input.getString("Enter location: ");
        int price = input.getNumber("Input price: ", 0, Integer.MAX_VALUE);
        LocalDate expiryDate = input.getDate("Enter expiry date: ");
        LocalDate manufactureDate = input.getDate("Enter manufacture date: ");
        String category = input.getString("Input product category: ");
        
        displayKeepers(keeperList);
        int keeperId = input.getNumber("Choose Store Keeper (Numeric): ", 0, keeperList.size() + 1);
        
        LocalDate receiptDate = input.getDate("Enter receipt date: ");

        Product product = new Product(id, name, location, price, expiryDate, manufactureDate, category, keeperId, receiptDate);
        productList.add(product);
    }
    
    private static void displayKeepers(ArrayList<Keeper> keeperList) {
        System.out.println("Store Keeper List: ");
        for (Keeper keeper : keeperList) {
            System.out.println(keeper.getId() + "\t|\t" + keeper.getName());
        }
    }

    static void updateProduct(ArrayList<Product> productList, ArrayList<Keeper> keeperList) {
        //check if list is empty
        if(productList.isEmpty()){
            System.out.println("Empty product list!");
            return;
        }
        
        Product update = getProduct(productList);
        
        System.out.println("ID found!");
        System.out.println("ID\tName\tLocation\tPrice\tExpiry Date\tManufacture date\tCategory\tStoreKeeper");
        update.displayOne(keeperList);
    }
    
    private static Product getProduct(ArrayList<Product> productList) {
        int id;
        
        id = input.getNumber("Input ID: ", 0, Integer.MAX_VALUE);
        //checks if id already exists
        while(!checkIdExisting(productList, id)){
            System.out.println("ID doesn't exists!");
            id = input.getNumber("Input ID: ", 0, Integer.MAX_VALUE);
        }

        for(Product product : productList){
            if(product.getId() == id){
                return product;
            } 
        }

        return null;
    }

    static void searchProduct(ArrayList<Product> productList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void sort(ArrayList<Product> productList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void sortProduct(ArrayList<Product> productList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    private static boolean checkIdExisting(ArrayList<Product> productList, int id) {
        for (Product product : productList) {
            if(product.getId() == id){
                return true;
            }
        }
        return false;
    }
    
    
}
