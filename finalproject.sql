-- ------------------------------
-- Schema for Brokerage Account
-- ------------------------------ 
DROP SCHEMA IF EXISTS BrokerageAccount;
CREATE SCHEMA IF NOT EXISTS BrokerageAccount;

USE BrokerageAccount ;
-- DROP TABLE OrderQueue;
-- DROP TABLE Orders;
-- DROP TABLE Holdings;
-- DROP TABLE Securities;


CREATE TABLE IF NOT EXISTS Securities(
  id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
  ticker VARCHAR(45) NOT NULL UNIQUE,
  name VARCHAR(45) NOT NULL UNIQUE,
  exchange VARCHAR(45) NOT NULL,
  current_price DECIMAL(8,2) NULL);

CREATE TABLE IF NOT EXISTS Orders(
  id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
  security_id INT NOT NULL,
  quantity INT NOT NULL,
  order_status VARCHAR(45) NOT NULL,
  execute_by DATE NULL,
  execute_price DECIMAL(8,2) NOT NULL,
  order_placed_time DATE NOT NULL,
  order_type VARCHAR(45) NOT NULL,

  CONSTRAINT securityId
    FOREIGN KEY (security_id)
    REFERENCES Securities (id)
   );

CREATE TABLE IF NOT EXISTS Holdings (
  id INT NOT NULL NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
  security INT NOT NULL,
  lot INT NOT NULL,
  buy_price DECIMAL(8,2) NOT NULL,
  CONSTRAINT securityIdHoldings
    FOREIGN KEY (security)
    REFERENCES Securities (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS OrderQueue (
  id INT NOT NULL UNIQUE PRIMARY KEY,
  CONSTRAINT orderId
    FOREIGN KEY (id)
    REFERENCES Orders(id)
   );


-- ------------------------------
-- Insert Data
-- ------------------------------

insert into Securities (id, ticker,name,exchange,current_price) values
(1, "AAPL", "Apple", "NASDAQ", 171.68),
(2, "C", "Citi", "NYSE", 54.27),
(3, "MS", "Morgan Stanley", "NYSE", 91.35),
(4, "MSFT", "Microsoft", "NASDAQ", 291.32),
(5, "GS", "Goldman Sachs", "NYSE", 353.74);


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
