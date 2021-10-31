create table user (
    id binary(16) not null primary key,
    external_id serial not null,
    fullname varchar(60) not null,
    username varchar(60) not null,
    email varchar(60) not null,
    password varchar(60) not null
);

create table movement (
    id binary(16) not null primary key,
    external_id serial not null,
    user_id binary(16) not null,
    type varchar(10) not null,
    created date not null,
    amount float not null,
    description varchar(60) null,
    index user_index (user_id),
    foreign key (user_id) references user(id) on delete cascade
);

commit;
