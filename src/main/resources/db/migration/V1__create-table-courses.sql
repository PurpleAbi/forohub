CREATE TABLE courses(
    id                  INT           not null auto_increment,
    name                VARCHAR (100) not null unique,
    category            VARCHAR (100) not null unique,

                        PRIMARY KEY (id)
);