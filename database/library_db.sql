-- =========================================
-- Library Management System
-- MySQL 8.x
-- =========================================
DROP DATABASE IF EXISTS library_db;

-- Create database
CREATE DATABASE library_db;
USE library_db;


CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL
);
