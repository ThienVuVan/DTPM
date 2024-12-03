create database bookstore;
use bookstore;
INSERT INTO role (role_name) VALUES ('ADMIN');
INSERT INTO role (role_name) VALUES ('USER');

INSERT INTO dia_chi (city, country, state, street, zip_code)
VALUES
('New York', 'United States', 'New York', '5th Avenue', '10001'),
('Los Angeles', 'United States', 'California', 'Sunset Boulevard', '90001'),
('Tokyo', 'Japan', 'Tokyo', 'Shibuya Street', '150-0002'),
('London', 'United Kingdom', 'London', 'Baker Street', 'NW1 6XE'),
('Paris', 'France', 'Île-de-France', 'Champs-Élysées', '75008');

INSERT INTO tai_khoan (email, full_name, password, phone, username, address_id, role_id)
VALUES
('john@example.com', 'John Doe', '12345678', '1234567890', 'john', 1, 2),
('smith@example.com', 'Jane Smith', '12345678', '9876543210', 'smith', 2, 1),
('admin@example.com', 'Admin User', '12345678', '5555555555', 'admin', 3, 2)

INSERT INTO sach (book_id, title, author, price, stock, publisher_id, category_id)
VALUES
(1, 'Clean Code', 'Robert C. Martin', 599.99, 50, 1, 1),
(2, 'The Pragmatic Programmer', 'Andy Hunt & Dave Thomas', 649.99, 30, 1, 2),
(3, 'Effective Java', 'Joshua Bloch', 799.99, 20, 2, 3),
(4, 'Design Patterns', 'Erich Gamma et al.', 899.99, 15, 2, 4),
(5, 'Head First Java', 'Kathy Sierra & Bert Bates', 499.99, 60, 2, 5);