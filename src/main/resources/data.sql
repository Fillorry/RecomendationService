INSERT INTO CRYPTO(timestamp, symbol,price)
SELECT DATEADD(MILLISECOND, (CAST(timestamp AS NUMERIC)), TIMESTAMP '1970-01-01 00:00:00'), symbol, price
FROM CSVREAD('classpath:BTC_values.csv');

INSERT INTO CRYPTO(timestamp, symbol,price)
SELECT DATEADD(MILLISECOND, (CAST(timestamp AS NUMERIC)), TIMESTAMP '1970-01-01 00:00:00'), symbol, price
FROM CSVREAD('classpath:DOGE_values.csv');

INSERT INTO CRYPTO(timestamp, symbol,price)
SELECT DATEADD(MILLISECOND, (CAST(timestamp AS NUMERIC)), TIMESTAMP '1970-01-01 00:00:00'), symbol, price
FROM CSVREAD('classpath:ETH_values.csv');

INSERT INTO CRYPTO(timestamp, symbol,price)
SELECT DATEADD(MILLISECOND, (CAST(timestamp AS NUMERIC)), TIMESTAMP '1970-01-01 00:00:00'), symbol, price
FROM CSVREAD('classpath:LTC_values.csv');

INSERT INTO CRYPTO(timestamp, symbol,price)
SELECT DATEADD(MILLISECOND, (CAST(timestamp AS NUMERIC)), TIMESTAMP '1970-01-01 00:00:00'), symbol, price
FROM CSVREAD('classpath:XRP_values.csv');