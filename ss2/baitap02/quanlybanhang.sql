create database quanlybanhang;
use quanlybanhang;
create table customer(
cId int primary key not null,
cName varchar(50),
cAge int
);
create table `order`(
oid int primary key not null,
odate date,
ototalprice int,
cid int,
foreign key (cid)  references customer(cId)
);
create table product(
pid int primary key not null,
pname varchar(50),
pprice int 
);
create table orderdetail(
oid int ,
pid int ,
odqty int,
foreign key (oid) references `order`(oid),
foreign key (pid) references product(pid)
);