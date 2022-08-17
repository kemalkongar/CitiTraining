-- ------------------------------
-- Schema for Brokerage Account
-- ------------------------------ 

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
("MS", "Morgan Stanley", "NYSE", 91.35) ;


insert into Orders values 
(1, 1, 5, "SUCCESS", '2022-12-31', 100.15, '2022-08-12', "BUY"),
(2, 3, 5, "SUCCESS", '2022-12-31', 92.5, '2022-08-12', "BUY");

insert into Holdings values
(1, 1, 100, 170.1),
(2, 2, 500, 53.2),
(3, 2, 100, 52),
(4, 3, 50, 90.6);

-- select * from Securities;

-- select * from Orders;

-- select * from Holdings;
