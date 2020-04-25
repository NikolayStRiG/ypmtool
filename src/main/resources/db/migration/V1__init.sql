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
    "id"           bigint primary key                            not null,
    "login"        varchar(255) unique                           not null,
    "password"     varchar(255)                                  not null,
    "user_role_id" bigint REFERENCES ypmtool.tool_user_role (id) not null,
    "forename"     varchar(255)                                  not null,
    "surname"      varchar(255)                                  not null,
    "patronymic"   varchar(255),
    "telephone"    varchar(255),
    "email"        varchar(255)
);

insert into ypmtool.tool_user_role (id, level, tag, name)
values (1, 'ADMIN', 'ADMIN', 'Администратор');
insert into ypmtool.tool_user (id, login, password, user_role_id, forename, surname)
VALUES (2, 'admin', '$2a$11$FVhb/f8..l6Sc47I07T6HOGDVjKZr3C3vDD4KbTouKN0XkdDgx2jK', 1, 'Admin', 'Admin');

create sequence ypmtool.task_id_sequence
    increment 1
    start 100
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

create table ypmtool.task_type
(
    "id"          bigint primary key  not null,
    "type"        varchar(20) unique  not null,
    "name"        varchar(255) unique not null,
    "description" varchar(255)
);

insert into ypmtool.task_type (id, type, name, description)
VALUES (1, 'feature', 'фича', 'Задача на разработку');
insert into ypmtool.task_type (id, type, name, description)
VALUES (2, 'bag', 'баг', 'Дефект');

create table ypmtool.task
(
    "id"                  bigint primary key default nextval('ypmtool.task_id_sequence'::regclass) not null,
    "name"                varchar(255)                                                             not null,
    "description"         varchar(255),
    "status"              varchar(20)                                                              not null,
    "priority"            int                default 0                                             not null,
    "type_id"              bigint references ypmtool.task_type (id)                                 not null,
    "responsible_user_id" bigint references ypmtool.tool_user (id)                                 not null,
    "finish_time"         timestamp with time zone,
    "create_user_id"      bigint references ypmtool.tool_user (id)                                 not null,
    "create_time"         timestamp with time zone                                                 not null
);

