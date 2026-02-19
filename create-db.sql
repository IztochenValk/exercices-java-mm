-- Création de la BDD
CREATE DATABASE IF NOT EXISTS games_cdafad CHARSET utf8mb4;
USE games_cdafad;

-- Création des tables
CREATE TABLE IF NOT EXISTS game(
                                   id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                                   title VARCHAR(50) NOT NULL,
    `description` VARCHAR(255),
    publish_at DATE DEFAULT (CURRENT_DATE) NOT NULL,
    manufacturer_id INT NOT NULL
    )ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS category(
                                       id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                                       `name` VARCHAR(50) NOT NULL
    )ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS manufacturer(
                                           id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                                           `name` VARCHAR(50) NOT NULL
    )ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS game_category(
                                            game_id INT,
                                            category_id INT,
                                            PRIMARY KEY(game_id, category_id)
    )ENGINE=InnoDB;

-- Ajout des contraintes Foreign Key
ALTER TABLE game
    ADD CONSTRAINT fk_publish_manufacturer
        FOREIGN KEY(manufacturer_id)
            REFERENCES manufacturer(id)
            ON DELETE CASCADE;

ALTER TABLE game_category
    ADD CONSTRAINT fk_add_game
        FOREIGN KEY(game_id)
            REFERENCES game(id)
            ON DELETE CASCADE;

ALTER TABLE game_category
    ADD CONSTRAINT fk_add_category
        FOREIGN KEY(category_id)
            REFERENCES category(id)
            ON DELETE CASCADE;