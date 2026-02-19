package com.exemple.repository;

import com.exemple.database.Mysql;
import com.exemple.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryRepository {
    //Attribut
    private Connection connection;

    //Constructeur
    public CategoryRepository() {
        this.connection = Mysql.getConnexion();
    }

    //Méthodes
    //Méthode pour ajouter une categorie
    public Category save(Category category) {
        try {
            //1 Ecrire la requête
            String sql = "INSERT INTO Category (`name`) VALUE (?)";
            //2 préparer la requête
            PreparedStatement stmt = connection.prepareStatement(sql);
            //3 Assigner le paramètre
            stmt.setString(1, category.getName());
            //4 Exécuter la requête
            int rows = stmt.executeUpdate();
            //test si la requête est bien passée
            if (rows <= 0) {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return category;
    }

    //méthode pour récuperer un categorie par son id
    public Category find(int id)
    {
        Category category = null;
        try {
            //1 Ecrire la requête
            String sql = "SELECT id, `name` FROM category WHERE id = ?";
            //2 préparer la requête
            PreparedStatement stmt = connection.prepareStatement(sql);
            //3 Assigner le paramètre
            stmt.setInt(1, id);
            //4 Exécuter la requête
            ResultSet rs = stmt.executeQuery();
            //récupérer le resultat de la requête
            if (rs.next()) {
                category = new Category(rs.getInt("id"), rs.getString("name"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return category;
    }

    //Méthode pour retourner la liste de toutes les categories (ArrayList)
    public ArrayList<Category> findAll()
    {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            //1 Ecrire la requête
            String sql = "SELECT id, `name` FROM category";
            //2 préparer la requête
            PreparedStatement stmt = connection.prepareStatement(sql);
            //4 Exécuter la requête
            ResultSet rs = stmt.executeQuery();
            //récupérer le resultat de la requête
            while (rs.next()) {
                Category category = new Category(rs.getInt("id"), rs.getString("name"));
                categories.add(category);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return categories;
    }
}