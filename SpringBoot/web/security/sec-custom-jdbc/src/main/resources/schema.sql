create table users(
 username varchar(50) not null,
 password varchar(100) not null,
 enabled boolean not null,
 primary key(username)
);
create table authorities (
 username varchar(50) not null,
 authority varchar(50) not null
);

/*
create table users
(
   id integer not null,
   email varchar(255) not null,
   full_name varchar(255) not null,
   password varchar(255) not null,
   primary key(id)
);
create table roles
(
   id integer not null,
   role varchar(255) not null,
   primary key(id)
);
create table users_roles
(
   user_id integer not null,
   role_id integer not null,
   primary key(user_id, role_id)
);
*/