drop table if exists 'authorities';
drop table  if exists 'users';



create table users (
    username varchar(50) primary key not null,
    password varchar(68) not null,
    enabled tinyint not null
);

insert into users values
('admin','{noop}pass',1),
('user01','{noop}tass',1),
('user02','{noop}tass',1);


create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    unique key authorities_idx_1 (username, authority),
    constraint authorities_ibfk_1 foreign key (username)
    references users (username)
);
insert into authorities values
                          ('admin','ROLE_ADMIN'),
                          ('user01','ROLE_USER'),
                          ('user02','ROLE_USER');
