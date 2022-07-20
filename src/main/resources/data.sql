INSERT INTO tb_customer (cpf, customer_name, account_agency, account_number, account_balance) VALUES('12345678911', 'Jhonata Luiz', '0001', '9998888', 51503 );
INSERT INTO tb_customer (cpf, customer_name, account_agency, account_number, account_balance) VALUES('98756432111', 'Bruna Maria', '0001', '5556666', 6045 );
INSERT INTO tb_customer (cpf, customer_name, account_agency, account_number, account_balance) VALUES('55555666641', 'João Gomes', '0001', '1234567', 100 );
INSERT INTO tb_customer (cpf, customer_name, account_agency, account_number, account_balance) VALUES('32564563214', 'Dona Maria', '0001', '4441234', 25 );

INSERT INTO tb_movement (description, destination_account, moment, origin_account, movement_type, movement_value) VALUES('Transferencia', '9998888', TIMESTAMP WITH TIME ZONE '2022-07-15T12:00:00Z', '5556666', 'TRANSFER', 200 );
INSERT INTO tb_movement (description, moment, origin_account, movement_type, movement_value) VALUES('Jantar', TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', '9998888', 'PAYMENT', -150 );