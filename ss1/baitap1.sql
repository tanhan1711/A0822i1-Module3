create database student;
use student;
create table Class(
	id int primary key,
    name varchar (50)
);
create table Teacher(
 id int primary key,
 name varchar(50),
 age int,
 country text
 );
 create table Student(
 id int not null primary key,
 name varchar(45)  null,
 age int null,
 country varchar(45) null
 );
insert into Class values
(1, 'Nhan');
insert into Teacher values
(1,'Nhan',23,'VietNam');
select * from Class;
select * from Teacher;
