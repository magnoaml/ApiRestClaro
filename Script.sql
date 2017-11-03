CREATE DATABASE CLARO;
 
CREATE TABLE CLARO.CELULAR
(
	ID 		int AUTO_INCREMENT PRIMARY KEY,
    CODE	varchar(100),
	MODEL   varchar(50),
	PRICE   varchar(10),
    BRAND 	varchar(50),
    PHOTO	varchar(200),
    DAT		varchar(10)	
);

COMMIT;
