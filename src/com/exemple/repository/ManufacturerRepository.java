package com.exemple.repository;

import com.exemple.database.Mysql;
import com.exemple.entity.Manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManufacturerRepository {

    //Attribut
    private Connection connection;

    //Constructeur
    public ManufacturerRepository() {
        this.connection = Mysql.getConnexion();
    }

    public Manufacturer save(Manufacturer manufacturer) {
        try {
            //1 Ecrire la requête
            String sql = "INSERT INTO manufacturer (`name`) VALUE (?)";
            //2 préparer la requête
            PreparedStatement stmt = connection.prepareStatement(sql);
            //3 Assigner le paramètre
            stmt.setString(1, manufacturer.getName());
            //4 Exécuter la requête
            int rows = stmt.executeUpdate();
            //test si la requête est bien passée
            if (rows <= 0) {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return manufacturer;
    }

    public Manufacturer find(int id) {
        Manufacturer manufacturer = null;
        try {
            //1 Ecrire la requête
            String sql = "SELECT id, `name` FROM manufacturer WHERE id = ?";
            //2 préparer la requête
            PreparedStatement stmt = connection.prepareStatement(sql);
            //3 Assigner le paramètre
            stmt.setInt(1, id);
            //4 Exécuter la requête
            ResultSet rs = stmt.executeQuery();
            //récupérer le resultat de la requête
            if (rs.next()) {
                manufacturer = new Manufacturer(rs.getInt("id"), rs.getString("name"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return manufacturer;
    }

    public ArrayList<Manufacturer> findAll() {
        ArrayList<Manufacturer> manufacturers = new ArrayList<>();
        try {
            //1 Ecrire la requête
            String sql = "SELECT id, `name` FROM manufacturer";
            //2 préparer la requête
            PreparedStatement stmt = connection.prepareStatement(sql);
            //4 Exécuter la requête
            ResultSet rs = stmt.executeQuery();
            //récupérer le resultat de la requête
            while (rs.next()) {
                Manufacturer manufacturer = new Manufacturer(rs.getInt("id"), rs.getString("name"));
                manufacturers.add(manufacturer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return manufacturers;
    }

    public boolean delete(int id) {
        try {
            //1 Ecrire la requête
            String sql = "DELETE FROM manufacturer WHERE id = ?";
            //2 préparer la requête
            PreparedStatement stmt = connection.prepareStatement(sql);
            //3 Assigner le paramètre
            stmt.setInt(1, id);
            //4 Exécuter la requête
            int rows = stmt.executeUpdate();
            //test si la requête est bien passée
            if (rows <= 0) {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
