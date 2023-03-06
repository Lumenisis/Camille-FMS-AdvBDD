----------------------------
--Connect to DB
USE Shop;
----------------------------
--Remove article
DELETE FROM T_Articles WHERE IdArticle = 31;
DELETE FROM T_Articles WHERE IdArticle = 32;
DELETE FROM T_Articles WHERE IdArticle = 33;
----------------------------
--Display tables
SELECT * FROM T_Articles;
SELECT * FROM T_Categories;
----------------------------