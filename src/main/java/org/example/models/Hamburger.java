package org.example.models;

import org.example.enums.BreadRollType;

import java.util.Arrays;
import java.util.Objects;

public class Hamburger implements Addable {

    private String name;
    private String meat;
    private double price;
    private BreadRollType breadRollType;
    private Addition[] additions;

    public Hamburger(String name, String meat, double price, BreadRollType breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
        this.additions = new Addition[4];
    }

    @Override
    public void addAddition(String name, double price) {
        for(int i=0; i<additions.length; i++){
            if(additions[i] == null) {
                additions[i] = new Addition(name, price);
                break;
            }
        }
    }

    public void itemizeHamburger() {
        StringBuilder hamburgerStringBuilder = new StringBuilder();
        hamburgerStringBuilder.append("Name: " + name + "\n");
        hamburgerStringBuilder.append("Meat: " + meat + "\n");
        hamburgerStringBuilder.append("Bread Roll Type: " + breadRollType + "\n");
        for (Addition addition: additions) {
            if (addition != null) {
                hamburgerStringBuilder.append("Addition name: " + addition.getName() + "\n");
                hamburgerStringBuilder.append("Addition price: " + addition.getPrice() + "\n");
                price = price + addition.getPrice();
            }
        }
        System.out.println(hamburgerStringBuilder);
        System.out.println("total price: "+ price);
        System.out.println("**********************");
    }

    public String getName() {
        return name;
    }

    public String getMeat() {
        return meat;
    }

    public BreadRollType getBreadRollType() {
        return breadRollType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Addition[] getAdditions() {
        return additions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hamburger hamburger = (Hamburger) o;
        return Objects.equals(name, hamburger.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Hamburger{" +
                "name='" + name + '\'' +
                ", meat='" + meat + '\'' +
                ", price=" + price +
                ", breadRollType=" + breadRollType +
                ", additions=" + Arrays.toString(additions) +
                '}';
    }
}
