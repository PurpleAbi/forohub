create table topics(
    id                  int          not null auto_increment,
    title               varchar(100) not null unique,
    message             varchar(200) not null unique,
    date_of_creation    varchar(14)  not null,
    status              varchar(100) not null,
    user_id             varchar(100) not null,
    course_id           varchar(100) not null

                        primary key(id)
);