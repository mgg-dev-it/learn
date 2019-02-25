insert into roles (id, role) values (1, 'ROLE_USER')
insert into roles (id, role) values (2, 'ROLE_ADMIN')
insert into users (id, email, full_name, password) values (1, 'user@spring.boot', 'user', '{noop}1234')
insert into users (id, email, full_name, password) values (2, 'admin@spring.boot', 'admin', '{noop}1234')
insert into users_roles (user_id, role_id) values (1, 1)
insert into users_roles (user_id, role_id) values (2, 2)


