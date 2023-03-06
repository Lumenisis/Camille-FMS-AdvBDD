----------------------------
--Connect to DB
USE Shop;
----------------------------
CREATE USER 'adminDB'@'localhost'
IDENTIFIED BY 'fms2023';
GRANT ALL PRIVILEGES ON shop.*
TO 'adminDB'@'localhost';
----------------------------
CREATE USER 'adminSYS'@'localhost'
IDENTIFIED BY 'fms2023';
GRANT ALL PRIVILEGES ON shop.*
TO 'adminDB'@'localhost';
----------------------------
CREATE USER 'adminNET'@'localhost'
IDENTIFIED BY 'fms2023';
GRANT ALL PRIVILEGES ON shop.*
TO 'adminDB'@'localhost';
----------------------------
SHOW GRANTS FOR 'adminDB'@'localhost';
SHOW GRANTS FOR 'adminSYS'@'localhost';
SHOW GRANTS FOR 'adminNET'@'localhost';
----------------------------