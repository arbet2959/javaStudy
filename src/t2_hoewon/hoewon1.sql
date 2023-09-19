show tables;

create table hoewon(
	idx int auto_increment primary key,
	name varchar(20) not null,
	age int default 20,
	address varchar(50),
	gender char(2) default '여자'
);

desc hoewon;

insert into hoewon values (default,'가가가',69,'청주','남자');
insert into hoewon values (default,'나나나',85,'청주','여자');
insert into hoewon values (default,'다다다',68,'경주','남자');
insert into hoewon values (default,'라라라',25,'서울','여자');
insert into hoewon values (default,'마마마',35,'경주','남자');
insert into hoewon values (default,'바바바',35,'인천','남자');
insert into hoewon values (default,'사사사',35,'인천','남자');
insert into hoewon values (default,'아아아',35,'경주','여자');
insert into hoewon values (default,'자자자',35,'부산','남자');
insert into hoewon values (default,'차차차',35,'부산','남자');
insert into hoewon values (default,'카카카',35,'안동','남자');
insert into hoewon values (default,'타타타',35,'김해','여자');
insert into hoewon values (default,'파파파',35,'괴산','남자');
insert into hoewon values (default,'하하하',35,'울산','여자');

select * from hoewon;