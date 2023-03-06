----------------------------
--Connect to DB
USE Shop;
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