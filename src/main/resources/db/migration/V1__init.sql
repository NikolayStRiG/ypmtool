create sequence ypmtool.hibernate_sequence
    increment 1
    start 100
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

create table ypmtool.tool_user_role
(
    "id"    bigint primary key  not null,
    "level" varchar(20)         not null,
    "tag"   varchar(20) unique  not null,
    "name"  varchar(255) unique not null
);

create table ypmtool.tool_user
(
    "id"           bigint primary key  not null,
    "login"        varchar(255) unique not null,
    "password"     varchar(255)        not null,
    "user_role_id" bigint REFERENCES ypmtool.tool_user_role (id),
    "forename"     varchar(255)        not null,
    "surname"      varchar(255)        not null,
    "patronymic"   varchar(255),
    "telephone"    varchar(255),
    "email"        varchar(255)
);

insert into ypmtool.tool_user_role (id, level, tag, name) values (1, 'ADMIN', 'ADMIN', 'Администратор');
insert into ypmtool.tool_user (id, login, password, user_role_id, forename, surname) VALUES (2, 'admin', 'admin', 1, 'Admin', 'Admin');
