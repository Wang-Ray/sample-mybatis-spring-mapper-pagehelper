drop table if exists country;
drop table if exists city;
drop table if exists hotel;

create table country (id int auto_increment, name varchar(32), PRIMARY KEY (id));
create table city (id int auto_increment comment 'id', name varchar(32) comment '姓名', state varchar(32) comment '州', country varchar(32) comment '国家', created_by VARCHAR(32) comment '创建人', PRIMARY KEY (id));
create table hotel (id int auto_increment, name varchar(32), address varchar(32), zip varchar(32), city int, PRIMARY KEY (id));

insert into country (name) values ('US');
insert into city (name, state, country, created_by) values ('San Francisco', 'CA', 'US', 'Angi');
insert into hotel(name, address, zip, city) values ('Conrad Treasury Place', 'William & George Streets', '4001',1);
