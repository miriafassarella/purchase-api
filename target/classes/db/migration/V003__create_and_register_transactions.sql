CREATE TABLE transaction(

	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	date_register DATE NOT NULL,
	description VARCHAR(250),
	price DECIMAL (10,2) NOT NULL,
	id_school BIGINT(20) NOT NULL,
	id_product BIGINT(20) NOT NULL,
	amount_product BIGINT (20),
	price_final DECIMAL (10,2),
	FOREIGN KEY (id_school) REFERENCES school(id),
	FOREIGN KEY (id_product) REFERENCES product(id)
);

/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/01/04', 1, 1, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/01/02', 2, 2, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/02/08', 3, 3, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/02/06', 4, 4, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/03/07', 5, 5, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/03/06', 6, 6, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/04/08', 7, 7, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/04/03', 1, 8, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/05/22', 2, 9, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/05/15', 3, 10, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/06/23', 4, 11, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/06/08', 5, 12, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/07/12', 6, 13, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/07/11', 7, 14, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/08/21', 1, 15, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/08/19', 2, 16, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/09/17', 7, 17, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/09/14', 3, 18, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/09/10', 4, 19, 2);*/
/*INSERT INTO transaction (date, id_school, id_product, amount_product) value ('2023/10/09', 5, 20, 2);*/