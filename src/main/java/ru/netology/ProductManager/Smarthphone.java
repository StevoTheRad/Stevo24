package ru.netology.ProductManager;

public class Smarthphone extends Product {

    private String manufacturer;

    public Smarthphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

}
