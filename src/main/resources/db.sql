create table teachers(
	tid int primary key,
	tname varchar2(10) not null
);

create table classes(
	cid int primary key,
	cname varchar2(10) not null unique,
	tid int
		constraints FK_classes_teachers_id references teachers(tid)
);



insert into teachers values(1,'彭正');
insert into classes values(1001,'计科1303',1);

drop table teachers;