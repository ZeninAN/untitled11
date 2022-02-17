package ru.netology.Product;

import ru.netology.Product.Product;

public class Smartphone extends Product {
    private int manufacturer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, int manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public int getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(int manufacturer) {
        this.manufacturer = manufacturer;
    }
}
