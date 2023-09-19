/*상품테이블


*/
create table product (
	idx int not null auto_increment primary key,
	pName varchar(20) not null,
	price int not null
);

desc product;

insert into product values (default,'냉장고',800000);

select * from product;

create table sale (
	idx int not null auto_increment primary key, -- 판매테이블 고유번호
	pName varchar(20) not null, -- 판매 상품명
	ea  int not null default 0,
	pDate datetime not null default now() -- 판매날짜 
 );
 
 desc sale;
 
 insert into sale values (default, '냉장고', 2, default);
 select * from sale;
 
 select * from sale join product on sale.pName=product.pName where sale.pName = '자전거';
