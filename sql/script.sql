create table Chief (
id int auto_increment primary key,
name varchar(50) not null);

create table Employee (
id int auto_increment primary key,
chief_id int not null,
name varchar(50) not null,
the_date date,
status varchar(50),
FOREIGN KEY (chief_id)  REFERENCES chief (id)
);