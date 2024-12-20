CREATE SEQUENCE SEQ_LEITURAS
 START WITH 1
 INCREMENT BY 1
 NOCACHE
 NOCYCLE;

CREATE TABLE LEITURAS (
ID_LEITURA INT PRIMARY KEY IDENTITY,
SENSOR_ID INT,
VALOR DECIMAL(10,2),
DATA_HORA DATETIME,
FOREIGN KEY (ID_SENSOR) REFERENCES SENSORES(ID_SENSOR)
);