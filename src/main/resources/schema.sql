DROP TABLE IF EXISTS CRYPTO;
CREATE TABLE CRYPTO (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `timestamp` TIMESTAMP NOT NULL,
    `symbol` VARCHAR(10) NOT NULL,
    `price` DOUBLE NOT NULL
);

CREATE INDEX CRYPTO_INDEX
ON CRYPTO (timestamp, symbol)