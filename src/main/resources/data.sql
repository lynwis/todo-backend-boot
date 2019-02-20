-- jdbc:h2:mem:testdb
insert into TODO(id, username, description, target_date, is_done)
values (100001, 'pippo', 'Learn JPA!', sysdate(), false);

insert into TODO(id, username, description, target_date, is_done)
values (100002, 'pippo', 'Learn Hibernate!', sysdate(), false);

insert into TODO(id, username, description, target_date, is_done)
values (100003, 'pippo', 'Learn Spring Data!', sysdate(), false);

insert into JWT_USR_DETAILS(id, username, password, role)
values(1, 'pippo', '$2a$10$K2zab/gGsO0OxELIRroxeumSMHtWWBZZY2wBPkKD7ECa3uAKSEk2G', 'ROLE_USER_1');