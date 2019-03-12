insert into users(username,password,enabled) values('admin','$2a$10$XHZ4F2I1NsuNq4tGhTKJi.CZr1HA0VAXiYJ.00IvAVDqFO.U/T.9W',true);
insert into authorities(username,authority) values('admin','ROLE_ADMIN');
insert into authorities(username,authority) values('admin','ROLE_USER');
insert into users(username,password,enabled) values('user','$2a$10$XHZ4F2I1NsuNq4tGhTKJi.CZr1HA0VAXiYJ.00IvAVDqFO.U/T.9W',true);
insert into authorities(username,authority) values('user','ROLE_USER');
/*
insert into roles (id, role) values (1, 'ROLE_USER')
insert into roles (id, role) values (2, 'ROLE_ADMIN')
-- insert into users (id, email, full_name, password) values (1, 'user@spring.boot', 'user', '{noop}1234')
-- insert into users (id, email, full_name, password) values (2, 'admin@spring.boot', 'admin', '{noop}1234')
insert into users (id, email, full_name, password) values (1, 'user@spring.boot', 'user', '$2a$10$XHZ4F2I1NsuNq4tGhTKJi.CZr1HA0VAXiYJ.00IvAVDqFO.U/T.9W')
insert into users (id, email, full_name, password) values (2, 'admin@spring.boot', 'admin', '$2a$10$XHZ4F2I1NsuNq4tGhTKJi.CZr1HA0VAXiYJ.00IvAVDqFO.U/T.9W')
insert into users_roles (user_id, role_id) values (1, 1)
insert into users_roles (user_id, role_id) values (2, 2)
*/