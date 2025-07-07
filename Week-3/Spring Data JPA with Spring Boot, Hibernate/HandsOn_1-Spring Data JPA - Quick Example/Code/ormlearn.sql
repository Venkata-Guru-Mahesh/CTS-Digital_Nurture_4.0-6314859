create schema ormlearn; 

USE ormlearn;

CREATE TABLE country (
  code VARCHAR(2) PRIMARY KEY,
  name VARCHAR(50)
);

INSERT INTO country VALUES ('IN', 'India'), ('US', 'United States of America');
