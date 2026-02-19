package com.exemple.entity;

public class Manufacturer {
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    private String name;
    public Manufacturer() {}
    public Manufacturer(String name)
    {
        this.name=name;
    }
    public Manufacturer(int id, String name)
    {
        this.id=id;
        this.name=name;
    }
    //méthodes
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
