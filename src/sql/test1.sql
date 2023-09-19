select * from test1;
desc test1;

/*
 * DDL(Date Definition Language) 데이터 정의어 TCARD
 */
create table test1 (
	idx int auto_increment primary key,
	name varchar(20) not null
);
desc test1;


insert into test1 values (default,'홍길동','남자');
insert into test1 values (default,'김말숙');
insert into test1 values (default,'이기자');
insert into test1 values (default,'소나무');
insert into test1 values (default,'대나무');
insert into test1 values (default,'대나무',35,'경주');
insert into test1 values (default,'대추나무',40,'원주');
insert into test1 values (default,'나도밤나무',50,'경주');
insert into test1 values (default,'대나무',74,'청주');
insert into test1 values (default,'가가가',69,'청주','남자');
insert into test1 values (default,'나나나',85,'청주','여자');
insert into test1 values (default,'다다다',68,'경주','남자');
insert into test1 values (default,'라라라',25,'서울','여자');
insert into test1 values (default,'마마마',35,'경주','남자');
insert into test1 values (default,'바바바',35,'인천','남자');
insert into test1 values (default,'사사사',35,'인천','남자');
insert into test1 values (default,'아아아',35,'경주','여자');
insert into test1 values (default,'자자자',35,'부산','남자');
insert into test1 values (default,'차차차',35,'부산','남자');
insert into test1 values (default,'카카카',35,'안동','남자');
insert into test1 values (default,'타타타',35,'김해','여자');
insert into test1 values (default,'파파파',35,'괴산','남자');
insert into test1 values (default,'하하하',35,'울산','여자');


select * from test1;

truncate table test1; --테이블구조남기고삭제
drop table test1; --테이블완전삭제

alter table test1 add column age int default 15; --컬럼 추가(add column)
alter table test1 add column addr varchar(50);  --

alter table test1 change column addr address varchar(40);         --컬럼이름변경 change
alter table test1 modify column address varchar(30);							--컬럼도메인변경 modify

alter table test1 drop column address;    --컬럼삭제

alter table test1 add column address varchar(30) not null default '청주' ; --컬럼추가
alter table test1 add column gender char(2) default '여자';

alter table test1 rename exam; -- 테이블이름변경

drop table exam;

/*
 *  DML(Date Manipulation Language) 데이터 조작어 SUID
 * 
 */
desc test1;
select * from test1;
insert into test1 values (default,'가나다',55,'제주');

select name,age from test1;

update test1 set age=25 where name='홍길동';             --update 테이블명 set 바꿀컬럼이름=값 where 조건;
update test1 set gender='남자' where name='홍길동';
update test1 set gender='남자' where name='이기자';
update test1 set gender='남자' where name='*나무' or name='대나무' or name='가나다' or name='나나나' or name='마마마';

update test1 set gender='남자' where name in ('파파파','차차차','사사사'); -- in (a,b,c) a or b or c

select * from test1 order by name asc, gender desc;  -- order by 컬럼명 desc(default는 asc)
select * from test1 order by gender desc,age asc; 
select * from test1 where age>=30 and age<40 and gender='남자' order by name desc;
select * from test1 where gender='남자' and (age>=30 and age<40 or age between 50 and 59);
select * from test1 where address in ('서울','청주') and age<=20;
select * from test1 where address='서울' or age between 20 and 29 and gender='남자';
select * from test1 where name like '가%'
select * from test1 where address like "%주";
select * from test1 where name like '%나%';
select * from test1 where name like '_나%'; -- 와일드카드 단수_ 복수%

select name,address from test1 where name like '_나%';

select * from test1 limit 10; --카디널리티 제한 limit
select * from test1 limit 10,6; --10번인덱스(=11번째) 부터 6개

update test1 set age=age+1 where address like '%주';

select * from test1 where address='서울' and gender='남자';
delete *from test1 where address='서울' and gender='남자';

desc test1;
insert into test1 values(default,'고노도',23,'해외','남자');
delete from test1 where address='해외';
