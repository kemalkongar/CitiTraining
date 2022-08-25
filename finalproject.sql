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
  id INT NOT NULL UNIQUE PRIMARY KEY,
  ticker VARCHAR(45) NOT NULL UNIQUE,
  name VARCHAR(300) NOT NULL,
  exchange VARCHAR(45) NOT NULL,
  t0 DECIMAL(8,2),
  tminus1 DECIMAL(8,2),
  tminus2 DECIMAL(8,2),
  tminus3 DECIMAL(8,2),
  tminus4 DECIMAL(8,2),
  tminus5 DECIMAL(8,2),
  tminus6 DECIMAL(8,2),
  tminus7 DECIMAL(8,2),
  tminus8 DECIMAL(8,2),
  tminus9 DECIMAL(8,2) NULL);

CREATE TABLE IF NOT EXISTS Orders(
  id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
  security_id INT NOT NULL,
  security_name VARCHAR(300),
  quantity INT NOT NULL,
  order_status ENUM('SUCCESS', 'FAILED', 'PENDING'),
  execute_by DATE NOT NULL,
  execute_price DECIMAL(8,2) NOT NULL,
  order_placed_time DATE NOT NULL,
  order_type ENUM('BUY', 'SELL'),

  CONSTRAINT securityId
    FOREIGN KEY (security_id)
    REFERENCES Securities (id)
   );

CREATE TABLE IF NOT EXISTS Holdings (
  id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
  security INT NOT NULL,
  security_ticker varchar(45),
  security_name varchar(300),
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

delimiter //
CREATE TRIGGER check_order
BEFORE INSERT
ON Orders 
FOR EACH ROW
BEGIN
IF NEW.execute_by < CURRENT_DATE THEN
    SIGNAL SQLSTATE '45000'  SET MESSAGE_TEXT='order expire date must be a future date';
    END IF;
IF NEW.order_placed_time > CURRENT_DATE THEN
    SIGNAL SQLSTATE '45000'  SET MESSAGE_TEXT='order must be placed in the past';
    END IF;
END;//

delimiter ;
