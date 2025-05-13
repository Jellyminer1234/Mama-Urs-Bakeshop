package com.example.bakery;

public class StockItem {
    private String itemName;
    private int quantity;
    private String category;
    private String dateAdded;

    public StockItem(String itemName, int quantity, String category, String dateAdded) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.category = category;
        this.dateAdded = dateAdded;
    }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDateAdded() { return dateAdded; }
    public void setDateAdded(String dateAdded) { this.dateAdded = dateAdded; }
}
