create database HB;
use HB;
CREATE TABLE HB_CUSTOMER
  (customer_Id int PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(30),
  email VARCHAR(70),
  age int,
  gender VARCHAR(6),
  birthday DATE, 
  phone VARCHAR(13));

  
INSERT INTO HB_CUSTOMER ( name ,  email ,  age ,  gender ,  birthday , 
  phone )VALUES(
'Smita','smita@gmail.com',99,'FEMALE',
'2011-11-21','9879879876');
select * from HB_CUSTOMER;

CREATE TABLE HB_CUSTOMER

  (customer_Id NUMBER PRIMARY KEY,
  name VARCHAR2(30),
  email VARCHAR2(70),
  age NUMBER,
  gender VARCHAR2(6),
  birthday DATE, 
  phone VARCHAR2(13));
  
CREATE SEQUENCE MY_CUSTOMER_SEQ;
  
INSERT INTO MY_CUSTOMER VALUES(
MY_CUSTOMER_SEQ.nextval,
'Smita','smita@gmail.com',99,'FEMALE',
'11-NOV-2011','9879879876');
select * from MY_CUSTOMER;

delete from MY_CUSTOMER;


