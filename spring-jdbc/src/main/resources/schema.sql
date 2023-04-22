CREATE TABLE CUSTOMERS (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(10),
	surname VARCHAR(10),
	age INT CHECK(age > 0),
	phone_number VARCHAR(12),
	PRIMARY KEY(id)
);

CREATE TABLE ORDERS (
	id INT NOT NULL AUTO_INCREMENT,
	date DATE,
	customer_id INT,
	product_name VARCHAR(20),
	amount INT CHECK(amount > 0),
	FOREIGN KEY(customer_id) REFERENCES CUSTOMERS(id),
	PRIMARY KEY(id)
);