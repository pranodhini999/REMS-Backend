//package com.demo.RestApis;
//
//
//public class PropertyDetails {
//    private String type;
//    private int squareFeet;
//    private double amount;
//
//    // Getters and Setters
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getSquareFeet() {
//        return squareFeet;
//    }
//
//    public void setSquareFeet(int squareFeet) {
//        this.squareFeet = squareFeet;
//    }
//
//    public double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }
//}

package com.demo.RestApis;

public class PropertyDetails {
    private String type;
    private int squareFeet;
    private double amount;

    // Constructor
    public PropertyDetails(String type, int squareFeet, double amount) {
        this.type = type;
        this.squareFeet = squareFeet;
        this.amount = amount;
    }

    // Getters and Setters
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getSquareFeet() { return squareFeet; }
    public void setSquareFeet(int squareFeet) { this.squareFeet = squareFeet; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
