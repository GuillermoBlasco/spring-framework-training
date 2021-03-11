
drop table if exists course;
drop table if exists course_type;

create table course_type (
                        id uuid not null primary key,
                        name varchar(1000) not null unique
);
create table course (
    id uuid not null primary key,
    name varchar(1000) not null unique,
    course_type_id uuid references course_type(id) on delete set null
);