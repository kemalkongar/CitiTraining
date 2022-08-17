-- ------------------------------
-- Schema for Brokerage Account
-- ------------------------------ 

CREATE SCHEMA IF NOT EXISTS BrokerageAccount;

USE BrokerageAccount ;
-- DROP TABLE OrderQueue;
-- DROP TABLE Orders;
-- DROP TABLE Holdings;
-- DROP TABLE Securities;


CREATE TABLE IF NOT EXISTS Securities(
  idSecurities INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
  ticker VARCHAR(45) NOT NULL UNIQUE,
  name VARCHAR(45) NOT NULL UNIQUE,
  exchange VARCHAR(45) NOT NULL,
  currentPrice DECIMAL(8,2) NULL);

CREATE TABLE IF NOT EXISTS Orders(
  idOrders INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
  security INT NOT NULL,
  quantity INT NOT NULL,
  Status VARCHAR(45) NOT NULL,
  executeBy DATE NULL,
  executePrice DECIMAL(8,2) NOT NULL,
  orderPlacedTime DATE NOT NULL,
  orderType VARCHAR(45) NOT NULL,

  CONSTRAINT idSecurities
    FOREIGN KEY (security)
    REFERENCES Securities (idSecurities)
   );

CREATE TABLE IF NOT EXISTS Holdings (
  idULot INT NOT NULL NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
  security INT NOT NULL,
  lot INT NOT NULL,
  buyPrice DECIMAL(8,2) NOT NULL,
  CONSTRAINT security
    FOREIGN KEY (security)
    REFERENCES Securities (idSecurities)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS OrderQueue (
  idOrderQueue INT NOT NULL UNIQUE PRIMARY KEY,
  CONSTRAINT idOrderQueue
    FOREIGN KEY (idOrderQueue)
    REFERENCES Orders(idOrders)
   );


-- ------------------------------
-- Insert Data
-- ------------------------------ 

insert into Securities (ticker,name,exchange,currentPrice)
values ("AAPL", "Apple", "NASDAQ", 171.68),
("C", "Citi", "NYSE", 54.27),
("MS", "Morgan Stanley", "NYSE", 91.35),
 ("MSFT", "Microsoft", "NASDAQ", 291.32),
 ("GS", "Goldman Sachs", "NYSE", 353.74);


insert into Orders values 
(1, 1, 5, "SUCCESS", '2022-12-31', 170.15, '2022-08-12', "BUY"),
(2, 1, 5, "SUCCESS", '2022-12-31', 172.5, '2022-08-12', "SELL"),
(3, 1, 10, "SUCCESS", '2022-12-31', 171.15, '2022-08-17', "BUY"),
(4, 3, 5, "SUCCESS", '2022-12-31', 92.5, '2022-08-17', "BUY"),
(5, 4, 15, "SUCCESS", '2022-12-31', 290.5, '2022-08-17', "BUY"),
(6, 2, 20, "SUCCESS", '2022-12-31', 53.5, '2022-08-17', "BUY");

insert into Holdings values
(1, 1, 10, 171.15),
(2, 3, 5, 92.5),
(3, 4, 15, 350.5),
(4, 2, 20, 53.5);

-- select * from Securities;

-- select * from Orders;

-- select * from Holdings;
