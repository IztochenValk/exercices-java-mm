package com.exemple.repository;

import com.exemple.database.Mysql;
import com.exemple.entity.Category;
import com.exemple.entity.Game;
import com.exemple.entity.Manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GameRepository {
    //Attribut
    private Connection connexion;

    //Constructeur
    public GameRepository() {
        this.connexion = Mysql.getConnexion();
    }

    public Game save(Game game) {
        try {
            //1 Ecrire la requête
            String sql = "INSERT INTO game (`title`, `description`, `manufacturer_id`) VALUE (?, ?, ?)";
            //2 préparer la requête (RETURN_GENERATED_KEYS pour récupérer l'id)
            PreparedStatement stmt = connexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //3 Assigner les paramètres
            stmt.setString(1, game.getTitle());
            stmt.setString(2, game.getDescription());
            stmt.setInt(3, game.getManufacturer().getId());
            //4 Exécuter la requête
            int rows = stmt.executeUpdate();
            //test si la requête est bien passée
            if (rows <= 0) {
                return null;
            }

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                game = new Game(id, game.getTitle(), game.getDescription(), game.getCategories(), game.getManufacturer());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return game;
    }

    public boolean saveCategoryToGame(ArrayList<Category> categories, Game game) {
        try {

            //1 Ecrire la requête
            String sql = "INSERT INTO game_category (game_id, category_id) VALUES (?, ?)";
            //2 préparer la requête
            PreparedStatement stmt = connexion.prepareStatement(sql);

            //3 Assigner les paramètres + batch
            for (Category category : categories) {
                stmt.setInt(1, game.getId());
                stmt.setInt(2, category.getId());
                stmt.addBatch();
            }

            //4 Exécuter la requête (batch)
            int[] rows = stmt.executeBatch();

            //test si la requête est bien passée
            if (rows.length <= 0) {
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public Game find(int id) {
        Game game = null;
        try {
            //1 Ecrire la requête
            String sql =
                    "SELECT g.id, g.title, g.description, " +
                            "m.id AS manufacturer_id, m.name AS manufacturer_name " +
                            "FROM game g " +
                            "LEFT JOIN manufacturer m ON m.id = g.manufacturer_id " +
                            "WHERE g.id = ?";

            //2 préparer la requête
            PreparedStatement stmt = connexion.prepareStatement(sql);
            //3 Assigner le paramètre
            stmt.setInt(1, id);
            //4 Exécuter la requête
            ResultSet rs = stmt.executeQuery();

            //récupérer le resultat de la requête
            if (rs.next()) {
                Manufacturer manufacturer = null;
                int manufacturerId = rs.getInt("manufacturer_id");
                if (!rs.wasNull()) {
                    manufacturer = new Manufacturer(manufacturerId, rs.getString("manufacturer_name"));
                }

                game = new Game(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        new ArrayList<>(),
                        manufacturer
                );

                //charger les catégories du game
                game.setCategories(findCategoriesByGameId(game.getId()));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return game;
    }

    public ArrayList<Game> findAll() {
        ArrayList<Game> games = new ArrayList<>();
        try {
            //1 Ecrire la requête
            String sql =
                    "SELECT g.id, g.title, g.description, " +
                            "m.id AS manufacturer_id, m.name AS manufacturer_name " +
                            "FROM game g " +
                            "LEFT JOIN manufacturer m ON m.id = g.manufacturer_id";

            //2 préparer la requête
            PreparedStatement stmt = connexion.prepareStatement(sql);
            //4 Exécuter la requête
            ResultSet rs = stmt.executeQuery();

            //récupérer le resultat de la requête
            while (rs.next()) {
                Manufacturer manufacturer = null;
                int manufacturerId = rs.getInt("manufacturer_id");
                if (!rs.wasNull()) {
                    manufacturer = new Manufacturer(manufacturerId, rs.getString("manufacturer_name"));
                }

                Game game = new Game(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        new ArrayList<>(),
                        manufacturer
                );

                game.setCategories(findCategoriesByGameId(game.getId()));

                games.add(game);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return games;
    }

    private ArrayList<Category> findCategoriesByGameId(int gameId) {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            //1 Ecrire la requête
            String sql =
                    "SELECT c.id, c.name " +
                            "FROM category c " +
                            "INNER JOIN game_category gc ON gc.category_id = c.id " +
                            "WHERE gc.game_id = ?";

            //2 préparer la requête
            PreparedStatement stmt = connexion.prepareStatement(sql);
            //3 Assigner le paramètre
            stmt.setInt(1, gameId);
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
