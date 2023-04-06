INSERT INTO brand (id, name) VALUES (1, 'Zara');
INSERT INTO brand (id, name) VALUES (2, 'Stradivarius');
INSERT INTO brand (id, name) VALUES (3, 'Bershka');
INSERT INTO brand (id, name) VALUES (4, 'Oysho');

INSERT INTO product (id, name) VALUES (35455, 'Camiseta manga corta');
INSERT INTO product (id, name) VALUES (35456, 'Camiseta manga larga');
INSERT INTO product (id, name) VALUES (35457, 'Pantalón slim');
INSERT INTO product (id, name) VALUES (35458, 'Pantalón clasic');
INSERT INTO product (id, name) VALUES (35459, 'Chaqueta');

INSERT INTO price (id, brand_id, start_date, end_date, price_list, product_id, priority, amount, currency) VALUES (1, 1 ,TIMESTAMP '2020-06-14 00:00:00', TIMESTAMP '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR');
INSERT INTO price (id, brand_id, start_date, end_date, price_list, product_id, priority, amount, currency) VALUES (2, 1 ,TIMESTAMP '2020-06-14 15:00:00', TIMESTAMP '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR');
INSERT INTO price (id, brand_id, start_date, end_date, price_list, product_id, priority, amount, currency) VALUES (3, 1 ,TIMESTAMP '2020-06-15 00:00:00', TIMESTAMP '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR');
INSERT INTO price (id, brand_id, start_date, end_date, price_list, product_id, priority, amount, currency) VALUES (4, 1 ,TIMESTAMP '2020-06-15 16:00:00', TIMESTAMP '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');