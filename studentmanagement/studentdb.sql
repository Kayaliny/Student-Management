CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE student (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  course VARCHAR(100) NOT NULL,
  age INT NOT NULL
);

INSERT INTO student (name, email, course, age) VALUES
('John Doe', 'john@example.com', 'Computer Science', 22),
('Jane Smith', 'jane@example.com', 'Information Technology', 21);
