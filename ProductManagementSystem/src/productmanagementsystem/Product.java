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
class Product implements Comparable<Product> {
    private int id;
    private String name;
    private String location;
    private int price;
    private LocalDate expiryDate;
    private LocalDate manufactureDate;
    private String category;
    private int keeperId;
    private LocalDate receiptDate;

    public Product() {
    }

    public Product(int id, String name, String location, int price, LocalDate expiryDate, LocalDate manufactureDate, String category, int keeperId, LocalDate receiptDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.expiryDate = expiryDate;
        this.manufactureDate = manufactureDate;
        this.category = category;
        this.keeperId = keeperId;
        this.receiptDate = receiptDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getKeeperId() {
        return keeperId;
    }

    public void setKeeperId(int keeperId) {
        this.keeperId = keeperId;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }
    
    public String getKeeperName(ArrayList<Keeper> keeperList, int keeperId){
        for (Keeper keeper : keeperList) {
            if(keeper.getId() == keeperId){
                return keeper.getName();
            }
        }
        return null;
    }
    

    public void displayOne(ArrayList<Keeper> keeperList){
        System.out.println(id + "\t" + name + "\t" + location + "\t\t" + price + "\t" + expiryDate + "\t" + manufactureDate + "\t\t" + category + "\t\t" + getKeeperName(keeperList, keeperId) + "\t\t" + receiptDate);
    }

    @Override
    public int compareTo(Product o) {
        int expiry = this.expiryDate.compareTo(o.getExpiryDate());
        
        if(expiry != 0)
            return expiry;
        else return this.manufactureDate.compareTo(o.getManufactureDate());
    }
    
    
}
