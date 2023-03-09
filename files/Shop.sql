----------------------------
--Use database
DROP DATABASE if EXISTS Shop;
CREATE DATABASE Shop;
USE Shop;
----------------------------
--Create table
CREATE TABLE T_Articles (
	IdArticle 	int(4) 		PRIMARY KEY AUTO_INCREMENT,
	Description varchar(30) NOT NULL,
	Brand 		varchar(30) NOT NULL,
	UnitaryPrice float(8)   NOT NULL
)ENGINE = InnoDB;
----------------------------
--Insert articles
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Souris', 'Logitoch', 65);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Clavier', 'Microhard', 49.5);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Systeme d exploitation', 'Fenetres Vistouille', 150);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Tapis de souris', 'Chapeau bleu', 5);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Clé USB 8 To', 'Syno', 8);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Laptop', 'PH', 1199);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('CD x 500', 'CETME', 250);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('DVD-R x 100', 'CETME', 99);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('DVD+R x 100', 'CETME', 105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Batterie Laptop', 'PH', 80);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Casque Audio', 'Syno', 105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Webcam', 'Logitoch', 755);
----------------------------
--Create table
CREATE TABLE T_Categories (
	IdCategorie INT(4) PRIMARY KEY AUTO_INCREMENT,
	CatName VARCHAR(30) NOT NULL,
	Description VARCHAR(100) NOT NULL
) ENGINE = InnoDB;
----------------------------
--Insert categories
INSERT INTO T_Categories (CatName, Description) VALUES ('Hardware', 'Materiels Informatiques');
INSERT INTO T_Categories (CatName, Description) VALUES ('Software', 'Logiciels Informatiques');
INSERT INTO T_Categories (CatName, Description) VALUES ('External Device', 'Peripheriques Informatiques');
----------------------------
--Display tables
SELECT * FROM T_Articles;
SELECT * FROM T_Categories;
----------------------------
--Add article
INSERT INTO T_Articles (IdArticle, Description, Brand, UnitaryPrice) VALUES (15, 'Alimentation', 'EVGA', 215);
INSERT INTO T_Articles (IdArticle, Description, Brand, UnitaryPrice) VALUES (16, 'Serveur NAS', 'Syno', 899);
----------------------------
--Update article
UPDATE T_Articles SET IdCategorie = 1 WHERE IdArticle = 15;
UPDATE T_Articles SET IdCategorie = 1 WHERE IdArticle = 16;
----------------------------
--Display article
SELECT IdArticle, T_Articles.Description, Brand, UnitaryPrice, CatName
FROM T_Articles INNER JOIN T_Categories
ON T_Articles.IdCategorie = T_Categories.IdCategorie
WHERE IdArticle = 15;
----------------------------
--Display article
SELECT IdArticle, T_Articles.Description, Brand, UnitaryPrice, CatName
FROM T_Articles INNER JOIN T_Categories
ON T_Articles.IdCategorie = T_Categories.IdCategorie
WHERE IdArticle = 16;
----------------------------
--Display tables
SELECT * FROM T_Articles;
SELECT * FROM T_Categories;
----------------------------