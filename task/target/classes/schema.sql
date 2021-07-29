DROP TABLE IF EXISTS COUNTRY;
CREATE TABLE COUNTRY (
COUNTRY_NAME VARCHAR(255) PRIMARY KEY,
COUNTRY_CODE VARCHAR(5) NOT NULL,
COUNTRY_REGEX VARCHAR(2000) NOT NULL
);

DROP TABLE IF EXISTS PHONE_NUMBER;
CREATE TABLE PHONE_NUMBER (
COUNTRY_NAME VARCHAR(255) NOT NULL,
NUMBER_POSTFIX VARCHAR(255) PRIMARY KEY,
STATUS INT NOT NULL
);