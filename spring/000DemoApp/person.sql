create database hb;
use hb;
create table MY_Student (student_id int primary key auto_increment,
name varchar(30),country varchar(30));

insert into MY_Student (name,country)values('Smita','India');
insert into MY_Student (name,country) values('Jim','USA');

/*create table MY_Student (student_id number primary key,
name varchar2(30),country varchar2(30));

insert into MY_Student values(1,'Smita','India');
insert into MY_Student values(2,'Jim','USA');

select * from MY_Student;
delete  from MY_Student;*/