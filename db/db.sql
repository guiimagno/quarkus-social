create database quarkus-social;

create table users(
	id bigserial not null primary key,
	name varchar(100) not null,
	age integer not null
);

create table posts(
    id bigserial not null primary key,
    post_text varchar(150) not null,
    dateTime timestamp not null,
    user_id bigint not null refecences users(id)
);

creaate table followers(
    id bigserial not null primary key,
    user_id bigint not null refecences USERS(id),
    followers_id bigint not null references users(id)
);