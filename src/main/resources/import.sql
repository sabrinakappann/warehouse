INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPONENT', 1, 'Gabinete para pc', 'Gabinete');
INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPONENT', 3, 'Placa mãe para pc', 'Placa mãe');
INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPONENT', 5, 'Fonte para pc', 'Fonte');
INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPONENT', 7, 'Cooler', 'Cooler');
INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPONENT', 9, 'Fonte 12V', 'Fonte');
INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPONENT', 11, 'Suporte Acrílico para Resfriador de aquário', 'Suporte Acrílico');


INSERT INTO COMPONENTS (ID) VALUES (1);
INSERT INTO COMPONENTS (ID) VALUES (3);
INSERT INTO COMPONENTS (ID) VALUES (5);
INSERT INTO COMPONENTS (ID) VALUES (7);
INSERT INTO COMPONENTS (ID) VALUES (9);
INSERT INTO COMPONENTS (ID) VALUES (11);

INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPOSITION', 2, 'PC genérico', 'PC - DESKTOP');
INSERT INTO ITEMS (ITEM_TYPE,  	ID,  	DESCRIPTION,  	NAME) VALUES ('COMPOSITION', 4, 'Resfriador de aquário C3', 'Resfriador de aquário');

INSERT INTO COMPOSITIONS (ID) VALUES (2);
INSERT INTO COMPOSITIONS (ID) VALUES (4);

INSERT INTO COMPOSITION_ITEM_QUANTITY ( COMPOSITION_ID , ITEM_ID , QUANTITY ) VALUES (2, 1, 1);
INSERT INTO COMPOSITION_ITEM_QUANTITY ( COMPOSITION_ID , ITEM_ID , QUANTITY ) VALUES (2, 3, 1);
INSERT INTO COMPOSITION_ITEM_QUANTITY ( COMPOSITION_ID , ITEM_ID , QUANTITY ) VALUES (2, 5, 1);
INSERT INTO COMPOSITION_ITEM_QUANTITY ( COMPOSITION_ID , ITEM_ID , QUANTITY ) VALUES (2, 7, 1);

INSERT INTO COMPOSITION_ITEM_QUANTITY ( COMPOSITION_ID , ITEM_ID , QUANTITY ) VALUES (4, 7, 3);
INSERT INTO COMPOSITION_ITEM_QUANTITY ( COMPOSITION_ID , ITEM_ID , QUANTITY ) VALUES (4, 9, 1);
INSERT INTO COMPOSITION_ITEM_QUANTITY ( COMPOSITION_ID , ITEM_ID , QUANTITY ) VALUES (4, 11, 1);
