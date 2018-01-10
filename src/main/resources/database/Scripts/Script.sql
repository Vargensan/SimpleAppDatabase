-- GENERATING DATABASE TABLES
-- -------------------------
DROP PROCEDURE IF EXISTS createAllTables;
DELIMITER //
CREATE PROCEDURE createAllTables()
  BEGIN
    DROP TABLE IF EXISTS ReceiptProductDetails;
    DROP TABLE IF EXISTS ReceiptDetails;
    DROP TABLE IF EXISTS Receipt;
    DROP TABLE IF EXISTS CashRegister;
    DROP TABLE IF EXISTS Magazine;
    DROP TABLE IF EXISTS Product;
    DROP TABLE IF EXISTS Users;
    DROP TABLE IF EXISTS Worker;
    CREATE TABLE Worker(
  personalID VARCHAR(11) PRIMARY KEY,
  birthDate DATE,
  name VARCHAR(30),
  surname VARCHAR(30),
  position VARCHAR(30)
);
    CREATE TABLE Users(
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  workerID VARCHAR(11) UNIQUE,
  acessLevel INT DEFAULT 1,
  userlogin VARCHAR(30) UNIQUE,
  userpassword VARCHAR(100),
  FOREIGN KEY Users(workerID) REFERENCES Worker(personalID)
);
    CREATE TABLE Product(
  id INT UNSIGNED PRIMARY KEY,
  producent VARCHAR(30),
  cost FLOAT(3),
  name VARCHAR(30)
);
    CREATE TABLE Magazine(
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  productId INT UNSIGNED,
  FOREIGN KEY (productId) REFERENCES Product(id)
);
    CREATE TABLE CashRegister(
    cashID INT UNSIGNED PRIMARY KEY,
    productionDate DATE,
    actualMoney INT
    );
    CREATE TABLE Receipt(
  paragonID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  cashID INT UNSIGNED,
  recipentID VARCHAR(11) ,
  FOREIGN KEY (recipentID) REFERENCES Worker(personalID),
  FOREIGN KEY (cashID) REFERENCES CashRegister(cashID)
);
    CREATE TABLE ReceiptDetails(
  uniqueID INT UNSIGNED PRIMARY KEY ,
  paragonID INT UNSIGNED UNIQUE,
  dateFormat DATE,
  canceled BOOL DEFAULT FALSE,
  FOREIGN KEY (paragonID) REFERENCES Receipt(paragonID)
);
    CREATE TABLE ReceiptProductDetails(
  uniqueID INT UNSIGNED PRIMARY KEY ,
  paragonID INT UNSIGNED,
  product INT UNSIGNED,
  FOREIGN KEY (product) REFERENCES Product(id),
  FOREIGN KEY (paragonID) REFERENCES Receipt(paragonID)
);
  END //
DELIMITER ;


SELECT * FROM Users;
SELECT * FROM Worker;
-- END OF GENERATION USER TABLES
-- -------------------------

CALL createAllTables();


INSERT INTO Products VALUES ("hey"),("yo");
SELECT * FROM Product;
SELECT * FROM LoginUsers;

-- TRIGGERS DECLARATION
-- UPDATING MAGAZINE DETAILS WHEN INSERTING NEW PRODUCTS

-- VALIDATING USER PESEL NUMBER
DELIMITER //
DROP TRIGGER IF EXISTS checkPesel;
CREATE TRIGGER checkPesel BEFORE INSERT ON worker
  FOR EACH ROW
  BEGIN
    DECLARE yearBirth VARCHAR(4);
    DECLARE monthBirth VARCHAR(2);
    DECLARE dayBirth VARCHAR(2);
    DECLARE yearAdd VARCHAR(2);
    DECLARE delimit VARCHAR(1);
    DECLARE datebirth DATE;
    DECLARE newbirthdate DATE;
    DECLARE stringbirth VARCHAR(11);
    DECLARE age INT;
    DECLARE integerMonth INT UNSIGNED;
    DECLARE integerYear INT UNSIGNED;
    DECLARE formater VARCHAR(9);

    SET formater = '%y-%m-%d';
    SET newbirthdate = NEW.birthDate;

    SET yearBirth = (SELECT SUBSTRING(NEW.personalID,1,2));
    SET monthBirth = (SELECT SUBSTRING(NEW.personalID,3,2));
    SET dayBirth = (SELECT SUBSTRING(NEW.personalID,5,2));
    SET delimit = '-';


    SET integerMonth = (SELECT CAST(monthBirth AS UNSIGNED));
    SET integerYear = (SELECT CAST(yearBirth AS UNSIGNED));

    IF integerMonth > 20 THEN
      SET integerMonth = integerMonth - 20;
      SET integerYear = 2000+integerYear;
      SET formater = '%Y-%m-%d';

      SET yearBirth = integerYear;
      SET monthBirth = integerMonth;
    END IF;

    SET stringbirth = (SELECT CONCAT(yearBirth,delimit,monthBirth,delimit,dayBirth));

    SET datebirth = (SELECT STR_TO_DATE(stringbirth,formater));

    IF datebirth <> newbirthdate THEN
      SIGNAL SQLSTATE  '45000'
      SET MESSAGE_TEXT = 'Invalid PESEL or Birthdate!';
    END IF;

    SET age = (SELECT YEAR(CURRENT_TIMESTAMP) - YEAR(newbirthdate) - (RIGHT(CURRENT_TIMESTAMP,5) < RIGHT(newbirthdate,5)));
    IF age < 16 THEN
      SIGNAL SQLSTATE '45001'
      SET MESSAGE_TEXT = 'Pracownik jest za młody aby pracować w firmie!';
    END IF;
    IF age > 68 THEN
      SIGNAL SQLSTATE '45002'
      SET MESSAGE_TEXT = 'Pracownik jest za stary aby pracować w fimie!';
    END IF;

  END //
DELIMITER ;

-- END OF VALIDATION USER PESEL NUMBER

DELIMITER //
CREATE TRIGGER productReceiptCorrect AFTER INSERT ON receiptproductdetails
  FOR EACH ROW
  BEGIN


  END //
DELIMITER ;

DELIMITER  //
CREATE TRIGGER removeFromMagazine BEFORE DELETE ON Product
  FOR EACH ROW
  BEGIN

  END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER updateCashLog AFTER UPDATE ON Receipt
FOR EACH ROW
  BEGIN

  END //
DELIMITER ;


-- PROCEDURES DECLARATION
-- BEGIN OF PROCEDURES DECLARATION

DELIMITER //
CREATE PROCEDURE checkIfProductIsInMagazine (IN productId INT, OUT isIn BOOLEAN)
  BEGIN

  END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getAmountOfAvailableProducts(IN productId INT, OUT ammount INT)
  BEGIN

  END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE addProductToReceipt (IN productID INT, IN paragonID INT)
  BEGIN

  END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE removeProductFromReceipt (IN productID INT, IN paragonID INT)
  BEGIN

  END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getSumOfMoneyForReceipt (IN productID INT, OUT money INT)
  BEGIN

  END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE removeProductsFromMagazine (IN productID INT)
  BEGIN

  END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getIDofRandomProductFromMagazine (IN productID INT)
  BEGIN

  END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE addMoneyToCash (IN money INT, IN cashID INT)
  BEGIN

  END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE discardReceipt (IN paragonID INT)
  BEGIN

  END //
DELIMITER ;

-- END OF PROCEDURE DECLARATION