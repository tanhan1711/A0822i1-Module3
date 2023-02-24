create database demo;
use demo;

create table products (
	id char(5) not null,
    product_code varchar(45),
    product_name varchar(45),
    product_price double,
    product_amount int,
    product_description varchar(60),
    product_status varchar(20),
primary key (id));

insert into products
values
('p1', 'pa1', 'desk', 20000, 100, 'red, cheap', 'available'),
('p2', 'pa2', 'table', 70000, 0, 'green, long', 'stock'),
('p3', 'pa3', 'lamp', 25000, 52, 'yellow, brigth', 'available'),
('p4', 'pa4', 'chair', 100000, 0, 'red, wide', 'stock'),
('p5', 'pa5', 'sofa', 5000000, 1, 'pink, soft', 'available');

create unique index product_unique_index
on products (product_code);

create index product_composite_index
on products (product_name, product_price);

explain products;

create view product_view 
as select 
	product_code, 
	product_name, 
	product_price, 
	product_status 
from 
	products;

select * from product_view;