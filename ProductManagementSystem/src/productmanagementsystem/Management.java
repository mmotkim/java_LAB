/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productmanagementsystem;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Mmotkim
 */
class Management {

    

    static void displayMenu() {
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

        displayKeepers(keeperList);
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
        
        LocalDate expiryDate = input.getDate("Enter expiry date (day/month/year): ", false);
        
        LocalDate manufactureDate = input.getDate("Enter manufacture date (day/month/year): ", true);
        //check if manufacture date inputted is valid
        while(expiryDate.compareTo(manufactureDate) < 0){
            System.out.println("Manufacture date must not be after expiry date!");
            manufactureDate = input.getDate("Enter manufacture date (day/month/year): ", true);
        }
        
        String category = input.getString("Input product category: ");
        displayKeepers(keeperList);
        int keeperId = input.getNumber("Choose Store Keeper (Numeric): ", 0, keeperList.size() + 1);
        
        LocalDate receiptDate = input.getDate("Enter receipt date (day/month/year): ", false);
        while(expiryDate.compareTo(receiptDate) < 0 || receiptDate.compareTo(manufactureDate) <= 0){
            System.out.println("Receipt date must be between manufacture date and expiry date!");
            receiptDate = input.getDate("Enter receipt date (day/month/year): ", false);
        }

        Product product = new Product(id, name, location, price, expiryDate, manufactureDate, category, keeperId, receiptDate);
        productList.add(product);
        
        displayAll(productList, keeperList);
    }
    
    private static void displayKeepers(ArrayList<Keeper> keeperList) {
        System.out.println("Store Keeper List: ");
        for (Keeper keeper : keeperList) {
            System.out.println(keeper.getId() + "  |  " + keeper.getName());
        }
    }

    static void updateProduct(ArrayList<Product> productList, ArrayList<Keeper> keeperList) {
        int choice;
        //check if list is empty
        if(productList.isEmpty()){
            System.out.println("Empty product list!");
            return;
        }
        
        Product update = getProduct(productList);
        
        System.out.println("ID found!");
        System.out.println("ID\tName\tLocation\tPrice\tExpiry Date\tManufacture date\tCategory\tStoreKeeper");
        update.displayOne(keeperList);
        
        do{
            updateMenu();
            
            choice = input.getNumber("Select an option: ", -1, 10);
            
            switch(choice){
                case 1:
                    int newId = input.getNumber("Input ID: ", 0, Integer.MAX_VALUE);
                    //checks if id already exists
                    while (checkIdExisting(productList, newId)) {
                        //if new id update is from the same employee
                        if(update.getId() == newId){
                            System.out.println("ID the same as before, canceling.");
                            break;
                        }
                        else {
                            System.out.println("ID duplicated!");
                            newId = input.getNumber("Input ID: ", 0, Integer.MAX_VALUE);
                        }
                    }
                    update.setId(newId);
                    break;
                case 2:
                    update.setName(input.getString("Input Product name: "));
                    break;
                case 3:
                    update.setLocation(input.getString("Enter location: "));
                    break;
                case 4:
                    update.setPrice(input.getNumber("Input price: ", 0, Integer.MAX_VALUE));
                    break;
                case 5:
                    update.setExpiryDate(input.getDate("Enter expiry date: ", false));
                    break;
                case 6:
                    LocalDate manufactureDate = input.getDate("Enter manufacture date(day/month/year): ", true);
                    //check if manufacture date inputted is valid
                    while (update.getExpiryDate().compareTo(manufactureDate) < 0) {
                        System.out.println("Manufacture date must not be after expiry date!");
                        manufactureDate = input.getDate("Enter manufacture date (day/month/year): ", true);
                    }

                    update.setManufactureDate(manufactureDate);
                    break;
                case 7:
                    update.setCategory(input.getString("Input product category: "));
                    break;
                case 8:
                    displayKeepers(keeperList);
                   
                    update.setKeeperId(input.getNumber("Choose Store Keeper (Numeric): ", 0, keeperList.size() + 1));
                    break;
                case 9:
                    LocalDate receiptDate = input.getDate("Enter receipt date(day/month/year): ", false);
                    while (update.getExpiryDate().compareTo(receiptDate) < 0 || receiptDate.compareTo(update.getManufactureDate()) < 0) {
                        System.out.println("Receipt date must be between manufacture date and expiry date!");
                        receiptDate = input.getDate("Enter receipt date(day/month/year): ", false);
                    }
                    update.setReceiptDate(receiptDate);
                    break;
            }
                    
        } while (choice > 0);
        
        displayAll(productList, keeperList);
    }
    
    private static void displayAll(ArrayList<Product> productList, ArrayList<Keeper> keeperList) {
        System.out.println("ID found!");
        System.out.println("ID\tName\tLocation\tPrice\tExpiry Date\tManufacture date\tCategory\tStoreKeeper\tReceipt Date");
        for (Product product : productList) {
            product.displayOne(keeperList);
        }
    }
    
    static void updateMenu(){
        System.out.println("1. Update ID");
        System.out.println("2. Update name");
        System.out.println("3. Update location");
        System.out.println("4. Update price");
        System.out.println("5. Update expiry date");
        System.out.println("6. Update manufacture date");
        System.out.println("7. Update category");
        System.out.println("8. Update Store keeper");
        System.out.println("9. Update receipt Date");
        System.out.println("0. Done");
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

    static void searchProduct(ArrayList<Product> productList, ArrayList<Keeper> keeperList) {
        String searchInput = "";
        int searchNumberInput = 0;
        ArrayList<Product> foundList = new ArrayList<>();
        
        //check if list is empty
        if(productList.isEmpty()){
            System.out.println("empty list!");
            return;
        }
        
        System.out.println("1. Search by name");
        System.out.println("2. Search by category");
        System.out.println("3. Search by storekeeper");
        System.out.println("4. Search by receiptdate");
        
        int choice = input.getNumber("Choose an option", 0, 5);
        //search loop
        
        switch(choice){
            case 1:
                do{
                    searchInput = input.getString("Input product name: ");
                    for (Product product : productList) {
                        if(product.getName().toLowerCase().contains(searchInput.toLowerCase())){
                            foundList.add(product);
                        }
                    }
                    
                    if(foundList.isEmpty()){
                        System.out.println("No product found!");
                    } else{
                        displayAll(foundList, keeperList);
                        break;
                    }
                } while(true);
                break;
            case 2:
                do{
                    searchInput = input.getString("Input category: ");
                    for (Product product : productList) {
                        if(product.getCategory().toLowerCase().contains(searchInput.toLowerCase())){
                            foundList.add(product);
                        }
                    }
                    
                    if(foundList.isEmpty()){
                        System.out.println("No product found!");
                    } else{
                        displayAll(foundList, keeperList);
                        break;
                    }
                } while(true);
                break;
            case 3:
                ArrayList<Keeper> tempKeeperList = new ArrayList<>();
                do{
                    searchInput = input.getString("Input Store Keeper: ");
                    for (Keeper keeper : keeperList) {
                        if (keeper.getName().equalsIgnoreCase(searchInput)) {
                            tempKeeperList.add(keeper);
                        }
                    }
                    
                    for (Keeper keeper : tempKeeperList) {
                        for(Product product : productList){
                            if(product.getKeeperId() == keeper.getId()){
                                foundList.add(product);
                            }
                        }
                    }
                    
                    if(foundList.isEmpty()){
                        System.out.println("No product found!");
                    } else{
                        displayAll(foundList, keeperList);
                        break;
                    }
                } while(true);
                break;
            case 4:
                LocalDate searchDate;
                
                do{
                    searchDate = input.getDate("Input date: ", false);
                    for(Product product : productList){
                       if(product.getReceiptDate().equals(searchDate)){
                           foundList.add(product);
                       }
                    }
                    
                    if(foundList.isEmpty()){
                        System.out.println("No product found!");
                    } else{
                        displayAll(foundList, keeperList);
                        break;
                    }
                } while(true);
                break;      
        }
    }

    static void sortProduct(ArrayList<Product> productList, ArrayList<Keeper> keeperList) {
        //check if list is empty
        if(productList.isEmpty()){
            System.out.println("empty list!");
            return;
        }
        
        Collections.sort(productList);
        displayAll(productList, keeperList);
    }
    
    static boolean checkIdExisting(ArrayList<Product> productList, int id) {
        for (Product product : productList) {
            if(product.getId() == id){
                return true;
            }
        }
        return false;
    }
    
    
}
