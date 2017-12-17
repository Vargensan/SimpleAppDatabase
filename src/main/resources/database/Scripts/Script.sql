DROP TABLE IF EXISTS Product;
CREATE TABLE Product(
  name VARCHAR(30)
);

DROP TABLE IF EXISTS Magazine;
CREATE TABLE Magazine(
  productName VARCHAR(30)
);

DROP TABLE IF EXISTS Receipt;
CREATE TABLE Receipt(
  cashID INT,
  paragonID INT,
  productsOrdered VARCHAR(30),
  dateFormat DATE,
  recipentName VARCHAR(30)
);

DROP TABLE IF EXISTS LoginUsers;
CREATE TABLE LoginUsers(
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  accessLevel INT DEFAULT 1,
  userName VARCHAR(20) UNIQUE,
  userPassword VARCHAR(80)
);


select userName, userPassword from loginusers where loginusers.userName = "a"

INSERT INTO Product VALUES ("hey"),("yo");
SELECT * FROM Product;
SELECT * FROM LoginUsers;