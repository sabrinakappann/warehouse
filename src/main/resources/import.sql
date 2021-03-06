INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPONENT', 100, 'Gabinete para pc', 'Gabinete');
INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPONENT', 300, 'Placa mãe para pc', 'Placa mãe');
INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPONENT', 500, 'Fonte para pc', 'Fonte');
INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPONENT', 700, 'Cooler', 'Cooler');
INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPONENT', 900, 'Fonte 12V', 'Fonte');
INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPONENT', 110, 'Suporte Acrílico para Resfriador de aquário', 'Suporte Acrílico');


INSERT INTO COMPONENTS (ID) VALUES (100);
INSERT INTO COMPONENTS (ID) VALUES (300);
INSERT INTO COMPONENTS (ID) VALUES (500);
INSERT INTO COMPONENTS (ID) VALUES (700);
INSERT INTO COMPONENTS (ID) VALUES (900);
INSERT INTO COMPONENTS (ID) VALUES (110);

INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPOSITION', 200, 'PC genérico', 'PC - DESKTOP');
INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPOSITION', 400, 'Resfriador de aquário C3', 'Resfriador de aquário');

INSERT INTO COMPOSITIONS (ID) VALUES (200);
INSERT INTO COMPOSITIONS (ID) VALUES (400);

INSERT INTO composition_item_quantity ( composition_id , item_id , quantity ) VALUES (200, 100, 1);
INSERT INTO composition_item_quantity ( composition_id , item_id , quantity ) VALUES (200, 300, 1);
INSERT INTO composition_item_quantity ( composition_id , item_id , quantity ) VALUES (200, 500, 1);
INSERT INTO composition_item_quantity ( composition_id , item_id , quantity ) VALUES (200, 700, 1);

INSERT INTO composition_item_quantity ( composition_id , item_id , quantity ) VALUES (400, 700, 3);
INSERT INTO composition_item_quantity ( composition_id , item_id , quantity ) VALUES (400, 900, 1);
INSERT INTO composition_item_quantity ( composition_id , item_id , quantity ) VALUES (400, 110, 1);

INSERT INTO users(email, first_name, last_name, password) VALUES ('dono@gmail.com', 'Dono', 'da Porra Toda', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO users(email, first_name, last_name, password) VALUES ('ze@gmail.com', 'Ze', 'da Silva', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO users(email, first_name, last_name, password) VALUES ('sabrinaksilva@gmail.com', 'Sabrina', 'da Silva', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');


INSERT INTO roles (authority) VALUES ('ROLE_BUYER');
INSERT INTO roles (authority) VALUES ('ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 2);