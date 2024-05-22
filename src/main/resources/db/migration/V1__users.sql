create table users
(
    id       int primary key         not null auto_increment,

    username varchar(150)            not null,
    password varchar(100),

    name     varchar(100),
    surname  varchar(150),

    created  timestamp default now() not null
);

insert into users (username, password, name, surname)
VALUES ('admin', 'admin123', null, 'Administrátor');
