package com.exemple.entity;
import java.util.ArrayList;
import com.exemple.entity.Category;
import com.exemple.entity.Manufacturer;
/*


*
* */
public class Game {

    private int id;
    private String title;
    private String description;
    private ArrayList<Category> categories;
    private Manufacturer manufacturer;
    public Game(){}
    public Game(String title, String description, ArrayList<Category> categories, Manufacturer manufacturer){
        this.title = title;
        this.description = description;
        this.categories = categories;
        this.manufacturer = manufacturer;

    }
    //méthodes
    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", categories='" + categories + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }


    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }


}

