DROP DATABASE IF EXISTS blog_content;

CREATE DATABASE blog_content;

USE blog_content;

CREATE TABLE beautyPic
(
	picId int unsigned not null AUTO_INCREMENT,
	name varchar(64) not null unique,
	urlPath varchar(256) not null,
	uploadTime timestamp not null default current_timestamp,
	size int unsigned not null default 0,
	hot int unsigned not null default 0,
	comment text null,
	deleted boolean not null default false,
	cn1 varchar(256) null,
	primary key(picId)
);

create index idx_picname on beautyPic(name);

create table picCate
(
	cateId int unsigned not null AUTO_INCREMENT,
	name varchar(32) not null unique,
	comment varchar(256) null,
	cover varchar(256) not null,
	mark smallint unsigned not null default 0,
	deleted boolean not null default false,
	cn1 varchar(256) null,
	primary key(cateId)
);

create index idx_catename on picCate(name);

create table picInCate
(
	picId int unsigned not null,
	cateId int unsigned not null,
	primary key(picId,cateId),
	constraint fk_pic foreign key(picId)
		references beautyPic(picId),
	constraint fk_cate foreign key(cateId)
		references picCate(cateId)
);
