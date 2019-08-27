create table Messages(
id int primary key,
data varchar(100),
queue_id int,
foreign key(queue_id) REFERENCES MultiQueue(id)
);
commit;